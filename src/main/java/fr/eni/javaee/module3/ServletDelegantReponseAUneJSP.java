package fr.eni.javaee.module3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletDelegantResponseAUneJSP
 */
@WebServlet("/modules/module3/ServletDelegantReponseAUneJSP")
public class ServletDelegantReponseAUneJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDelegantReponseAUneJSP() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		//rd=request.getRequestDispatcher("/WEB-INF/modules/module3/demonstrations/premiereJSPDansWEB-INF.jsp");
		//rd=this.getServletContext().getRequestDispatcher("/modules/module3/demonstrations/secondePremiereJSP");
		rd = this.getServletContext().getNamedDispatcher("premiereJSPDansWEB_INF");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
