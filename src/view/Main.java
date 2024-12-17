package view;

import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entities.User;

public class Main {

	public static void main(String[] args) {
		User emerson = new User(8);
		
		UserDAO dao = (UserDAO) DAOFactory.getDAO(UserDAO.class);
		System.out.println(dao.delete(emerson));
	}

}
