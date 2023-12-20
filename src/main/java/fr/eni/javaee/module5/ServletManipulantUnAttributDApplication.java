package fr.eni.javaee.module5;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletManipulantUnAttributDApplication
 */
/**
 * Servlet implementation class ServletManipulantUnAttributDApplication
 */
@WebServlet("/modules/module5/ServletManipulantUnAttributDApplication")
public class ServletManipulantUnAttributDApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().setAttribute("attributDApplication", "Bonjour tout le monde");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module5/afficherAttributApplication.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}