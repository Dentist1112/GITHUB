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
		//��ȡ½���������Ʒ  ��������   
		//�ظ�����ʱ  ������µ�id�������� 
		response.setContentType("text/html;charset=utf-8");
		int num = Integer.parseInt(request.getParameter("num"));//��ȡ�������� 
		int pid =Integer.parseInt(request.getParameter("pid"));//��ȡ��Ʒidת��Ϊ����
		//��ȡ��ʱ��product�Ķ��� 
		Product p = new productDAO().getId(pid);
		//����������
		orderItem oi =new orderItem();
		//���ö��������� 
		oi.setNum(num);
		oi.setProduct(p);
		//��������   ��ӽ�ȥ 
		List<orderItem> ois= (List<orderItem>) request.getSession().getAttribute("ois");//��ȡ��ǰ�Ựֵ 
	    if(null==ois){
	    	ois= new ArrayList<orderItem>();//������ǰ�¶�������  ��ֹ���ֻỰֵΪ�� 
	        request.getSession().setAttribute("ois", ois);//������ǰ�Ựֵ 
	    }
	    
	    boolean found=false;
	    //����Ƿ��ظ�
	    for (orderItem oid : ois) {
			if(oid.getProduct().getId()==oi.getProduct().getId()){//idֵ��ͬ  �ı�oi��ֵ ���
				oid.setNum(oi.getNum()+oid.getNum());//�����µ�ֵ 
				found=true;
				break;
			}
		}
	    if(!found)
	    {
	    	ois.add(oi);
	    }
	    response.sendRedirect("listOrderItem.jsp");//������������ʾ���µ�jsp�ļ�����  
	}

}
