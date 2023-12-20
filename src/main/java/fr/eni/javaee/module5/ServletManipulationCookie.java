package fr.eni.javaee.module5;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletManipulantCookie
 */
@WebServlet("/modules/module5/ServletManipulationCookie")
public class ServletManipulationCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletManipulationCookie() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();//permet d'écrire/afficher l'information à utilisateur
		Cookie[] cookies = request.getCookies();// création d'un tableau de cookie inititialisé avec la méthode request.getCookie.
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");//Initialisation de SimpleDateFormat pour afficher au format HH MM SS
		
		if(cookies==null)//Pas de cookie
		{
			out.println("Il n'y a pas de cookie.");
			out.println("C'est peut-être le premier passage de l'utilisateur.");
			out.println("Ou le fait qu'il n'accepte pas les cookies.");
			out.println("Date : " + sdf.format(new Date()));
			
			out.println();
			out.println("Voici les cookies nouvellement créés :");
			
			for(int i=0;i<3;i++)//Création de 3 cookies (si pas de cookie) avec un nom et une valeur,
				//le nom du cookie aura un nom aléatoire préfixé de "unNom_" suivi d'une valeur aléatoire
				// compris entre 0 et 999.
			{
				Random rd = new Random();
				Cookie unCookie = new Cookie("unNom_"+rd.nextInt(1000), "uneValeur_"+rd.nextInt(1000));
				unCookie.setMaxAge(rd.nextInt(10));//Durée de vie du cookie (9 sec)
				response.addCookie(unCookie);// j'ajoute mon cookie
				out.println(unCookie.getName()+"="+unCookie.getValue()+", durée="+unCookie.getMaxAge()+" secondes.");
			}//Affichage des infosdu cookie que je renvoie à l'utilisateur
		}
		else // j'ai des cookies
		{//Affichage du tableau de cookies
			out.println("Voici les cookies qui transitent entre le navigateur du client et le serveur :");
			for(Cookie unCookie:cookies)
			{
				out.println(unCookie.getName()+"="+unCookie.getValue());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}