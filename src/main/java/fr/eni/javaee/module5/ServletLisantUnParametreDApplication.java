package fr.eni.javaee.module5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletLisantUnParametreDApplication
 */
@WebServlet("/modules/module5/ServletLisantUnParametreDApplication")
public class ServletLisantUnParametreDApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAdministrateur = this.getServletContext().getInitParameter("EMAIL_ADMINISTRATEUR");
		PrintWriter out = response.getWriter();
		out.println("L'email de l'administrateur est : " +emailAdministrateur);
		out.println("L'information est accessible depuis toutes les servlets et toutes les JSP");
		out.println("Dans une JSP, il faut écrire : application.getInitParameter(\"EMAIL_ADMINISTRATEUR\")");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
