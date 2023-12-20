package fr.eni.javaee.module4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/modules/module4/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			Context context = new InitialContext();
			//Recherche de la DataSource
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			
			//Demande une connexion. La méthode getConnexion met la demande en attente tant qu'il n'y a pas 
			//de connexion disponibles dans le pool
			Connection cnx = dataSource.getConnection();
			
			//Vérifier si la connexion est ouverte ou non
			out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte") + ".");
			
			//Libérer la connexion lorsqu'il n'y en plus besoin. Non fermée mais remise dans le pool
			cnx.close();
			
			
			
					
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
