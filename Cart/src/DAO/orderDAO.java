package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Order;

public class orderDAO {// 将订单对象保存到数据库中
	public void insert(Order o) {
		String sql = "insert into order(uid) values(?)";
		try {
			String user = "sa";
			String ps = "123456";
			String jdbc = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(jdbc);
			Connection c = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=cart", user, ps);
			PreparedStatement p =c.prepareStatement(sql);
			p.setInt(1, o.getUser().getId());
			p.execute();//执行此语句 
			ResultSet rs = p.getGeneratedKeys();
			if(rs.next()){
				int id=	rs.getInt(1);
				o.setId(id);//设置订单中的项目 
			}
			p.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
