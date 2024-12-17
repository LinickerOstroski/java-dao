package model.dao;

import java.util.ArrayList;
import java.util.Date;
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
	public List<User> listAll() {
		List<User> users = new ArrayList<>();		
		String sqlQuery = "SELECT * FROM users;";

		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.statement();

		dbHandler.executeQuery(sqlQuery);


		while (dbHandler.next()) {
			int userId = dbHandler.getInt("id");
			String userName = dbHandler.getString("nome");
			String userSex = dbHandler.getString("sexo");
			String userEmail = dbHandler.getString("email");
			
			User u = new User(userId);
			u.setName(userName);
			u.setSex(Character.toChars(0)[0]);
			u.setEmail(userEmail);
			users.add(u);
		}
	
		dbHandler.close();
		
		return users;
	}


	@Override
	public User findByID(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
