package view;

import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entities.User;

public class Main {

	public static void main(String[] args) {
		User emerson = new User(8);
		
		UserDAO dao = (UserDAO) DAOFactory.getDAO(UserDAO.class);
		
		for(User user : dao.listAll()) {
			System.out.println("Id: " + user.getId());
			System.out.println("Nome: " + user.getName());
			System.out.println("Sexo: " + user.getSex());
			System.out.println("Email: " + user.getEmail());
		}
	}

}
