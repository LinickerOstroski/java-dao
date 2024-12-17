package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler {
	private Connection connection;
	private PreparedStatement preparedStatement;
//	private Statement statement;
	
	public void prepareStatement(String sql) {
		try {
			connection = MySQLConnectionFactory.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			
		}catch(SQLException sqle) {
			
		}catch(ClassNotFoundException cnfe) {
			
		}finally {
			try {
				connection.close();
			}catch (Exception e) {
				
			}
		}
	}

	public void setString(int index, String value) {
		try {			
			preparedStatement.setString(index, value);
		}catch(SQLException e) {
			
		}
	}

	public void setInt(int index, int value) {
		try {			
			preparedStatement.setInt(index, value);
		}catch(SQLException e) {
			
		}
		
	}
	public int executeUpdate() {
		try {
			return preparedStatement.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void close() {
		if(preparedStatement != null) {
			try {
				preparedStatement.close();				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
}	
