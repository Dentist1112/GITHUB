package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrderItemDAO;
import bean.Order;
import bean.User;
import bean.orderItem;
/*判断用户是否登录 
 * 获取前台数据 
 * 调用insert方法 
 * */
public class creatOrderServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public creatOrderServlet() {
		super();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取当前会话值 
		   User user = (User) request.getSession().getAttribute("user");//将字符串转化为对象 
		if(null==user){
			response.sendRedirect("login.jsp");
		}
		//存在  获取当前订单项 
		Order o= new Order();
		o.setUser(user);//设置用户 
		List<orderItem> ois= (List<orderItem>)request.getSession().getAttribute("ois");//订单项数组 
	    
		for(orderItem oi:ois){
			oi.setOrder(o);
			new OrderItemDAO().insert(oi);
		}
		ois.clear();
		response.getWriter().println("订单创建成功");
	}

}
