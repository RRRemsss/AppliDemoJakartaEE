package fr.eni.javaee.module7;

import java.util.Date;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerDemarrageArret
 *
 */
@WebListener
public class ListenerDemarrageArret implements ServletContextListener {
	private static Date dateDemarrage;
	

	/**
	 * @return the dateDemarrage
	 */
	public static Date getDateDemarrage() {
		return dateDemarrage;
	}

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Démarrage de l'application");
    	ListenerDemarrageArret.dateDemarrage = new Date();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Arret de l'application");
    }
	
}
