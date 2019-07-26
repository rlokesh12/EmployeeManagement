package com.db.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.employeemanagementsystem.bean.LoginBean;
import com.db.employeemanagementsystem.util.DBUtil;

public class LoginDAOImpl implements LoginDAO {

	public boolean authenticate(LoginBean login) {
		String query = "select * from login_table where username=? and password=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtil.getConnection();
		// statement / preparedstatemnet / callablestatement
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(connection);
		}
		
		return false;
	}

}
