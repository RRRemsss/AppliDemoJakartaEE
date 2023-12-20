package fr.eni.javaee.module6;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import fr.eni.javaee.module6.bo.Voiture;

/**
 * Servlet implementation class ServletExpressionLanguage
 */
@WebServlet("/modules/module6/ServletExpressionLanguage")
public class ServletExpressionLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		if (random.nextBoolean())
		{
			Voiture voiture = new Voiture("Renault", "Zoe", "AA123BB", 5230);
			request.setAttribute("voiture", voiture);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module6/pageExpressionLanguage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
