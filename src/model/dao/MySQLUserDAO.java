package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.entities.User;

class MySQLUserDAO implements UserDAO{

	@Override
	public boolean save(User user) {
		
			String sqlInsert = "INSERT INTO users "
					+ "VALUES(DEFAULT, ?,?,?);";
			
			DataBaseHandler dbHandler = new DataBaseHandler();
			dbHandler.prepareStatement(sqlInsert);
			
			dbHandler.setString(1, user.getName());
			dbHandler.setString(2, user.getSex().toString());
			dbHandler.setString(3, user.getEmail());
			
			int rowsAffected =  dbHandler.executeUpdate();

			// Necessário fechar os recursos
			dbHandler.close();
			
			return rowsAffected > 0;
		
	}
	
	@Override
	public boolean update(User user) {
			
			String sqlUpdate = "UPDATE users "
					+ "SET nome = ?,"
					+ "sexo = ?, "
					+ "email = ? "
					+ "WHERE id = ?; ";
			
			DataBaseHandler dbHandler = new DataBaseHandler();
			dbHandler.prepareStatement(sqlUpdate);
			
			dbHandler.setString(1, user.getName());
			dbHandler.setString(2, user.getSex().toString());
			dbHandler.setString(3, user.getEmail());
			dbHandler.setInt(4, user.getId());
			
			int rowsAffected =  dbHandler.executeUpdate();
			
			dbHandler.close();
			
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
	public boolean delete(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = MySQLConnectionFactory.getConnection();
			
			String sqlUpdate = "";
			
			preparedStatement = connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSex().toString());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getId());
			
			int rowsAffected =  preparedStatement.executeUpdate();
			
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
	public User findByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
