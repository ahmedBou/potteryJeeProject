package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.PotterieDaoImpl;
import dao.UserLoginImpl;
import metier.entities.Potterie;
import metier.entities.User;

/**
 * Servlet implementation class PotteryController
 */
@WebServlet(name="cs",urlPatterns = {"*.do"})
@MultipartConfig(maxFileSize = 16177215)
public class PotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PotterieDaoImpl metier = new PotterieDaoImpl();
	UserLoginImpl metierUser = new UserLoginImpl();
  
    public PotteryController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("the path is "+path);
		
		if(path.equals("/index.do")) {
			ArrayList<Potterie> getProd = metier.getPotterie();
			HttpSession session = request.getSession();
			session.setAttribute("data", getProd);
			request.getRequestDispatcher("adminView.jsp").forward(request,response);
		
		}else if(path.equals("/indexUser.do")) {
			ArrayList<Potterie> getProd = metier.getPotterie();
			HttpSession session = request.getSession();
			session.setAttribute("data", getProd);
			request.getRequestDispatcher("userView.jsp").forward(request,response);
		}else if(path.equals("/login.do")){
			System.out.println(" enter to login doGet");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}else if(path.equals("/deconnection")){
			HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.removeAttribute("CURRENT_USER");
	            }

	            request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else if(path.equals("/search.do")) {
			String nm = request.getParameter("nm");
			System.out.println(nm);
			Potterie model = new Potterie();
			model.setNom(nm);
			List<Potterie> prod = metier.nmPotterie("%" +nm + "%");
			HttpSession session = request.getSession();
			List<String> imagelist = new ArrayList<String>();
			long countVote=0;
			for (Potterie p : prod) {
				byte[] imageBytes = p.getImages();
				System.out.println(imageBytes);
				countVote = metier.getVotePrd(p.getId());
				imagelist.add(Base64.getEncoder().encodeToString(imageBytes));
				System.out.println(imagelist.get(0));
			}
			
			
			session.setAttribute("data", prod);
			session.setAttribute("images",imagelist);
			session.setAttribute("count", countVote);
			request.getRequestDispatcher("adminView.jsp").forward(request,response);
			
		}else if(path.equals("/delete.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			System.out.println("the id to be deleted is: "+id);
			
			metier.delete(id);
			//request.getRequestDispatcher("adminView.jsp").forward(request,response);
			response.sendRedirect("search.do?nm=");
		}
			else if(path.equals("/editPr.do")) {
				//je recupere le id pr chercher le produit 
			Long id= Long.parseLong(request.getParameter("id"));
			Potterie p = metier.getPotterie(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("editPr.jsp").forward(request,response);
		
		}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String path = request.getServletPath();
		System.out.println("the path is "+path);

		if(path.equals("/addPottery.do")) {
			System.out.println("im in add section");
			System.out.println("hello");
			
			
			String nom = request.getParameter("nom");
			String quantite = request.getParameter("quantite");
			String prix = request.getParameter("prix");
			String desc = request.getParameter("desc");
			
			InputStream inputStream = null;
	        Part filePart = request.getPart("image");
	        
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        } 
	        byte[] image = IOUtils.toByteArray(inputStream);
			Potterie p = metier.save(new Potterie(nom, Integer.parseInt(quantite), Double.parseDouble(prix), image, desc));
//			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}else if(path.equals("/addPottery.do")) {
	 		Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String quantite = request.getParameter("quantite");
			String prix = request.getParameter("prix");
			String desc = request.getParameter("desc");
			
			InputStream inputStream = null;
	        Part filePart = request.getPart("image");
	        
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        } 
	        byte[] image = IOUtils.toByteArray(inputStream);
			Potterie p = metier.save(new Potterie(id,  nom, Integer.parseInt(quantite), Double.parseDouble(prix), image, desc));
			metier.updatePotterie(p);
			request.setAttribute("p", p);
			response.sendRedirect("search.do?nm=");
		
		}else if(path.equals("/upProducts.do")) {
			Long id =Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String quantite = request.getParameter("quantite");
			String prix = request.getParameter("prix");
			String desc = request.getParameter("desc");
			InputStream inputStream = null;
	        Part filePart = request.getPart("image");
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        } 
	        byte[] image = IOUtils.toByteArray(inputStream);

//				System.out.println(title + " " + price + " " + ControllerProduct.id );
				System.out.println("success");
				Potterie p = metier.updatePotterie(new Potterie(id, nom, Integer.parseInt(quantite), Double.parseDouble(prix), image, desc));
				request.setAttribute("p", p);
				response.sendRedirect("search.do?nm=");

			
		}else if(path.equals("/login.do")){
			System.out.println(" enter to login in doPost");
			String email = request.getParameter("email");
			String pswd = request.getParameter("pswd");

			User p;
			try {
				p = metierUser.userLogin(email, pswd);
				
				if (p != null) {
					if (p.getRole() == 1) {
						// administrator						
						HttpSession session = request.getSession(true);
	                    session.setAttribute("CURRENT_USER", p);
		
						request.getRequestDispatcher("adminView.jsp").forward(request,response);						
						
					}else {
						// client
						HttpSession session = request.getSession(true);
	                    session.setAttribute("CURRENT_USER", p);
						request.getRequestDispatcher("userView.jsp").forward(request,response);
					}
	
				}else {
					System.out.println("p == null");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}
