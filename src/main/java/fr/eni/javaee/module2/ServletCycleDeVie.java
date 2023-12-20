package fr.eni.javaee.module2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletCycleVie
 */

@WebServlet ("/modules/module2/ServletCycleDeVie")
public class ServletCycleDeVie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nombrePassageInit=0;
	private int nombreAppelServlet=0;
	private int nombreDestroy=0;
       
	@Override
	public void init() throws ServletException {
		this.nombrePassageInit+=1;
		super.init();
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.nombreAppelServlet+=1;
		response.getWriter().append("nombreAppelServlet :").append(String.valueOf(this.nombreAppelServlet));
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("nombrePassageInit: " ).append(String.valueOf(this.nombrePassageInit));
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("nombreDestroy: " ).append(String.valueOf(this.nombreDestroy));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.nombreDestroy+=1;
		doGet(request, response);
	}

}
