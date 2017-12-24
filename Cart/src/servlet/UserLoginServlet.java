package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import bean.User;

public class UserLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");//获取属性值 
		User user = new userDAO().getUser(name, password);
		if (null != user) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("list");
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
