package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.orderItem;//������ 

public class OrderItemDAO {
	//���浽���ݿ⵱�� 
	public static void main(String[] args) {
	
}

	public void insert(orderItem oi){
	
	try {
		String ue="sa";
		String pd="123456";
		String url="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		Class.forName(url);
		Connection c = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=cart", ue, pd);//�������� 
		String sql="insert into orderItem(uid,number,oid) values(?,?,?)";
		PreparedStatement p= c.prepareStatement(sql);
		p.setInt(1,oi.getProduct().getId());
		p.setInt(2, oi.getNum());
		p.setInt(3, oi.getOrder().getId());
		p.execute();
		p.close();
		c.close();//why ???
		
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	
}


}
