package epsi.webservices.servlet;

import epsi.webservices.dao.DaoUser;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="NewUserServlet", urlPatterns={"/newUser"})
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(NewUserServlet.class);   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("processing GET on /newUser");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/newUser.html");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("processing POST on /newUser");
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd1");
		
		DaoUser.newUser(login, pwd);
		log.info("User "+login+" créé");
		
		response.sendRedirect("login");
	}
}
