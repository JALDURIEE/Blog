package com.ping.blog.daoimpl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ping.blog.common.DBConnection;
import com.ping.blog.dao.UserDao;
import com.ping.blog.util.EncryptStringUtil;
import com.ping.blog.vo.User;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	public User queryUserByUserName(String userName) {
		// TODO Auto-generated method stub
		connection = DBConnection.getConnection();
		String sql = "select * from users where userName='" + userName + "'";
		User user = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNickName(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setEmail(rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if(statement!=null){
					statement.close();
				}
				DBConnection.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return user;
	}

	public boolean verifyUser(User user, String password) {
		// TODO Auto-generated method stub
		
		try {
			if(EncryptStringUtil.MD5(password).equals(user.getPassword())){
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
