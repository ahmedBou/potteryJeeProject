package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PotterieDaoImpl;
import metier.entities.Potterie;

/**
 * Servlet implementation class PotServlet
 */

public class PotServlet extends HttpServlet {
		
	PotterieDaoImpl metier = new PotterieDaoImpl();
    public PotServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("the path is"+path);
		
		if(path.equals("/index.do")){
			ArrayList<Potterie> pottery_ = metier.getPotterie();
//			for (Potterie potterie : pottery_) {
//				System.out.println("la liste de plante a chercher"+ potterie.toString());
//
//				
//			}
//			request.setAttribute("pottery", pottery_);
			request.getRequestDispatcher("adminView.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

}
