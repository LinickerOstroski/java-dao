package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.entities.User;

public class MySQLUserDAO implements UserDAO{
	
	private static final String JDBC_DRIVER_NAME = 
			"com.mysql.jdbc.Driver";
	
	private static final String DATABASE_URL = 
			"jdbc:mysql://127.0.0.1/facebook";

	// Credenciais
	static final String USER = "root";
	static final String PASSWORD = "";

	@Override
	public boolean save(User user) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			Class.forName(JDBC_DRIVER_NAME);

			connection = DriverManager.getConnection(
					DATABASE_URL, USER, PASSWORD);
			
			String sqlInsert = "INSERT INTO users VALUES "
					+ " (DEFAULT, ?, ?, ?);";
			
			preparedStatement = connection.prepareStatement(sqlInsert);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSex().toString());
			preparedStatement.setString(3, user.getEmail());
			
			int rowsAffected =  preparedStatement.executeUpdate();

			// Necessário fechar os recursos
			preparedStatement.close();
			connection.close();
			
			return rowsAffected > 0;
		} catch (SQLException sqlError) {
			// Erro na execução da SQL
			sqlError.printStackTrace();
		} catch (Exception generalError) {
			// Errors na carga do drive (Class.forName)
			generalError.printStackTrace();
		} finally {
			// Para fechar os recursos em caso de erros
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException sSqlError) {
				sSqlError.printStackTrace();
			}
			
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException cSqlError) {
				cSqlError.printStackTrace();
			} 
		}	
		
		return false;
	}
	

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
