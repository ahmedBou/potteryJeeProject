package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PotterieDaoImpl;
import metier.entities.Potterie;

/**
 * Servlet implementation class getContents
 */

public class getContents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PotterieDaoImpl metier = new PotterieDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getContents() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Potterie> _ListsPottery = new ArrayList<Potterie>();

		_ListsPottery = metier.getPotterie();

		_ListsPottery.forEach(record -> {
			System.out.println(record.toString());
		});
		
		request.setAttribute("LISTS_POTTERY", _ListsPottery);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminView.jsp");
		dispatcher.forward(request, response);

	}

}
