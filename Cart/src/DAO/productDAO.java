package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class productDAO {// �� product��ȫ����ѯ
	public static void mian(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("");
	}
//ͨ��idֵ ��ȡ����product
	public Product getId(int id){
		String sql="select * from product where id="+id;
		Product p= null;
		try {
			String ue="sa";
			String pd="123456";
			String url="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(url);
			
			Connection c= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=cart",ue,pd);//��������
			Statement s= c.createStatement();
			ResultSet rs=s.executeQuery(sql	);
			if(rs.next()){
				p= new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));//��ȡp������ 
			}
		} catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Product> listProduct()// ��ʾ���в�Ʒ ����product���ϵ���
	{
		List<Product> products = new ArrayList<Product>();
		
		try {// �������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// �������ݿ�
			Connection c = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=cart", "sa",
					"123456");
			
			String sql = "select * from product ";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Product po = new Product();//�����µĶ���  ��ӵ���������� 
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				po.setId(id);
				po.setName(name);
				po.setPrice(price);
				products.add(po);
			}
			s.close();
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return products;
	}

}
