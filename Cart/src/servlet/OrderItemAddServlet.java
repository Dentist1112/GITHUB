package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.productDAO;
import bean.Product;
import bean.orderItem;

public class OrderItemAddServlet extends HttpServlet   {

	public OrderItemAddServlet() {
		super();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by th
		 * e server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取陆续购买的商品  创建数组   
		//重复购买时  添加了新的id到数据中 
		response.setContentType("text/html;charset=utf-8");
		int num = Integer.parseInt(request.getParameter("num"));//获取购买数量 
		int pid =Integer.parseInt(request.getParameter("pid"));//获取商品id转化为整型
		//获取此时的product的对象 
		Product p = new productDAO().getId(pid);
		//创建订单项
		orderItem oi =new orderItem();
		//设置订单项属性 
		oi.setNum(num);
		oi.setProduct(p);
		//创建数组   添加进去 
		List<orderItem> ois= (List<orderItem>) request.getSession().getAttribute("ois");//获取当前会话值 
	    if(null==ois){
	    	ois= new ArrayList<orderItem>();//创建当前新订单对项  防止出现会话值为空 
	        request.getSession().setAttribute("ois", ois);//创建当前会话值 
	    }
	    
	    boolean found=false;
	    //检查是否重复
	    for (orderItem oid : ois) {
			if(oid.getProduct().getId()==oi.getProduct().getId()){//id值相同  改变oi的值 相加
				oid.setNum(oi.getNum()+oid.getNum());//设置新的值 
				found=true;
				break;
			}
		}
	    if(!found)
	    {
	    	ois.add(oi);
	    }
	    response.sendRedirect("listOrderItem.jsp");//将订单内容显示在新的jsp文件当中  
	}

}
