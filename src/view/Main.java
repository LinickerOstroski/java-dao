package view;

import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entities.User;

public class Main {

	public static void main(String[] args) {
		User emerson = new User(8);
		emerson.setName("Emerson DAO Id 8");
		emerson.setEmail("emerson8@gmail.com");
		emerson.setSex('M');
		
		UserDAO dao = (UserDAO) DAOFactory.getDAO(UserDAO.class);
		System.out.println(dao.update(emerson));
	}

}
