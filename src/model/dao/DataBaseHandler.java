package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.ModelException;

public class DataBaseHandler {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet rs;

	public void statement() throws ModelException{
		try {
			connection = MySQLConnectionFactory.getConnection();

			statement = connection.createStatement();

		}catch(Exception e) {
			try {
				connection.close();
			} catch (Exception e2) {}
			
			throw new ModelException("Erro ao criar o statement", e);
			
		}finally {}
	}


	public void prepareStatement(String sql) {
		try {
			connection = MySQLConnectionFactory.getConnection();

			preparedStatement = connection.prepareStatement(sql);

		}catch(Exception e) {
			try {
				connection.close();
			} catch (Exception e2) {}
		}finally {}
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

		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {}
		}

		if(statement != null) {
			try {
				statement.close();
			}catch(Exception e) {}
		}

		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		preparedStatement = null;
		rs = null;
		statement = null;
		connection = null;

	}


	public void executeQuery(String sqlQuery) {
		try {
			rs = statement.executeQuery(sqlQuery);
		} catch (SQLException e) {}
	}
	
	public void executeQuery() {
		try {
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {}
	}


	public boolean next() {
		try {
			return rs.next();
		} catch (SQLException e) {}
		return false;
	}


	public String getString(String column) {
		try {
			return rs.getString(column);
		} catch (SQLException e) {
		}
		
		return "";
	}


	public Date getDate(String column) {
		try {
			return rs.getDate(column);
		} catch (SQLException e) {
		}
		return null;
	}


	public int getInt(String string ) {
		try {
			return rs.getInt(string);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}




}	
