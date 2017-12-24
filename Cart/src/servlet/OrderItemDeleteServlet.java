package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.orderItem;

public class OrderItemDeleteServlet extends HttpServlet {
/*
 * 1、获取pid ois对象数组 
 * 删除对象数组中的id为pid的产品对象 
 * 什么方法将数组中的对象删除的呀？removeall
 * 删除存在pid值的对象 可好  ？
 * */
	public OrderItemDeleteServlet() {
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
		response.setContentType("text/html;charset=utf-8");//设置编码
		int pid =Integer.parseInt(request.getParameter("pid"));//获取参数值  
		List<orderItem> ois  = (List<orderItem>)request.getSession().getAttribute("ois");//获取当前数组对象
		List<orderItem> oiDelete = new ArrayList<orderItem>();
		//寻找存在对象 
		if(null!=ois){//若不为空 
		for(orderItem oi : ois){
			if(oi.getProduct().getId()==pid)//存在 
			oiDelete.add(oi);
			break;
			}
		
		}
		ois.removeAll(oiDelete);
		response.sendRedirect("listOrderItem.jsp");
	}
}
