package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.productDAO;
import bean.Product;

public class productListServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
	     List<Product> products= new productDAO().listProduct();
	     request.setAttribute("products",products);
	    request.getRequestDispatcher("listProduct.jsp").forward(request, response);
	}

}
