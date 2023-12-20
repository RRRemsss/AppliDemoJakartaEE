package fr.eni.javaee.module2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;


/**
 * Servlet implementation class ServletEcrivantDesEnTetes
 */
@WebServlet("/modules/module2/ServletEcrivantDesEnTetes")
public class ServletEcrivantDesEnTetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setStatus(HttpServletResponse.SC_OK);
	response.setLocale(Locale.FRANCE);
	response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	response.setHeader("MON_ENTETE", "MA_VALEUR");
	
	response.getWriter().append("Des en-têtes ont été écrits");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
