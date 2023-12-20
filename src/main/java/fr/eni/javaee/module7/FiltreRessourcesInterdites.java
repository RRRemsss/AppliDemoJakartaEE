package fr.eni.javaee.module7;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(dispatcherTypes = { 
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD, 
		DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = "/modules/module7/ServletInterdite")

public class FiltreRessourcesInterdites implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltreRessourcesInterdites() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println(httpRequest.getServletPath());
		if (!httpRequest.getServletPath().toLowerCase().contains("interdit")) {
			// Laissons passer la requête vers là où elle doit aller
			chain.doFilter(request, response);
		} else {
			// Renvoyons une 403 à l'utilisateur
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}