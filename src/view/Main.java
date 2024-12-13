package view;

import model.dao.UserDAO;
import model.entities.User;

public class Main {

	public static void main(String[] args) {
		User emerson = new User();
		emerson.setName("Emerson DAO");
		emerson.setEmail("emerson@gmail.com");
		emerson.setSex('M');
		
//		UserDAO dao = new MySQLUserDAO();
//		dao.save(emerson);
	}

}
