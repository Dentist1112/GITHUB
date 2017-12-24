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
 * 1����ȡpid ois�������� 
 * ɾ�����������е�idΪpid�Ĳ�Ʒ���� 
 * ʲô�����������еĶ���ɾ����ѽ��removeall
 * ɾ������pidֵ�Ķ��� �ɺ�  ��
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
		response.setContentType("text/html;charset=utf-8");//���ñ���
		int pid =Integer.parseInt(request.getParameter("pid"));//��ȡ����ֵ  
		List<orderItem> ois  = (List<orderItem>)request.getSession().getAttribute("ois");//��ȡ��ǰ�������
		List<orderItem> oiDelete = new ArrayList<orderItem>();
		//Ѱ�Ҵ��ڶ��� 
		if(null!=ois){//����Ϊ�� 
		for(orderItem oi : ois){
			if(oi.getProduct().getId()==pid)//���� 
			oiDelete.add(oi);
			break;
			}
		
		}
		ois.removeAll(oiDelete);
		response.sendRedirect("listOrderItem.jsp");
	}
}
