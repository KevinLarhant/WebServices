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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private final static Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;

		if (request.getSession().getAttribute("login") != null) {
			response.sendRedirect("index.jsp");
		} else {
			//TODO : changer la page
			requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.include(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		if (DaoUser.checkCredentials(login, pwd)) {
			request.getSession().setAttribute("login", login);
		}

		response.sendRedirect("index.jsp");
	}
}
