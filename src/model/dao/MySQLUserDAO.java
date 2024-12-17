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
			
	}
	

	@Override
	public boolean delete(User user) {

		String sqlDelete = "DELETE FROM users WHERE id = ?;";
		
		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.prepareStatement(sqlDelete);
		
		dbHandler.setInt(1, user.getId());
		
		int rowsAffected =  dbHandler.executeUpdate();
		
		dbHandler.close();
		
		return rowsAffected > 0;
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
