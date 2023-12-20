package fr.eni.javaee.module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eni.javaee.module6.bo.Voiture;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExpressionLanguage
 */
@WebServlet("/modules/module6/ServletBalisesJSTL")
public class ServletBalisesJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBalisesJSTL() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		if(random.nextBoolean())
		{
			Voiture voiture = new Voiture("RENAULT","ZOE","AA123BB", 5236);
			request.setAttribute("voiture", voiture);
		}
		
		List<Voiture> voitures = new ArrayList<>();
		voitures.add(new Voiture("AUDI","RS6","AZ456QS", 46434));
		voitures.add(new Voiture("MERCEDES","CLASSE C","ER789DF",5319));
		voitures.add(new Voiture("PEUGEOT","308","CV345TY",134567));
		request.setAttribute("voitures", voitures);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module6/pageBalisesJSTL.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}