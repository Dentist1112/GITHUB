package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class userDAO {
	// 查阅用户信息 name password
	public User getUser(String name1, String password1) {
		// 创建数据库链接
		User result = null;//每次创建新对象
		String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String username = "sa";
		String pd = "123456";
		try {
			Class.forName(url);
			
			Connection c = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=cart", username,
					pd);
			//System.out.println("connected success");
			String sql = "select * from users where name=? and password=? ";
			PreparedStatement ps = c.prepareStatement(sql);//都是正确的呀 
			ps.setString(1, name1);
			ps.setString(2, password1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result=new User();
				result.setId(rs.getInt(1));
				result.setName(name1);
				result.setPassword(password1);
			}
			ps.close();
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
