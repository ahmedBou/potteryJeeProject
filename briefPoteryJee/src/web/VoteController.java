package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoteForProductsImpl;

/**
 * Servlet implementation class VoteController
 */
@WebServlet("/VoteController")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VoteForProductsImpl metier;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteController() {
        super();
        metier =  new VoteForProductsImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int personid = Integer.parseInt(request.getParameter("personid"));
			int productid = Integer.parseInt(request.getParameter("productid"));
			
			System.out.println(personid);
			System.out.println(productid);
			
			
			metier.makeVote(personid, productid);
			
			

		
	}

}
