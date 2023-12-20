package fr.eni.javaee.module2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class ServletLectureTousEnTete
 */

@WebServlet("/modules/module2/ServletLectureTousLesEnTetes")
public class ServletLectureTousLesEnTetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		
		String userAgent = request.getHeader("user-agent");
		sb.append("User-Agent : ").append(userAgent).append(System.lineSeparator());
		
		Enumeration<String> listeEnTete = request.getHeaderNames();
		while (listeEnTete.hasMoreElements()) {
			String entete = listeEnTete.nextElement();
			sb.append(entete +" : ");
			Enumeration<String> valeurs = request.getHeaders(entete);
			while (valeurs.hasMoreElements()) {
				sb.append(valeurs.nextElement());
				if(valeurs.hasMoreElements()) {
					sb.append(", ");
				}
			}
			sb.append(System.lineSeparator());
		}
		
		response.getWriter().append(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
