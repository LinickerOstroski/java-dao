package view;

import model.ModelException;
import model.dao.DAOFactory;
import model.dao.PostDAO;
import model.dao.UserDAO;
import model.entities.Post;

public class Main {

	public static void main(String[] args) throws ModelException {
		//		User emerson = new User(8);

		PostDAO dao = (PostDAO) DAOFactory.getDAO(PostDAO.class);
//
////		
//		for(Post post : dao.listAll()) {
//			System.out.println("Id: " + post.getId());
//			System.out.println("Content: " + post.getContent());
//			System.out.println("Post Date: " + post.getDate());
//			System.out.println("User id: " + post.getUser_id());
//			System.out.println();
//		}
		 
		
//		Post post = new Post();
//		post.setContent("Hello linicker");
//		post.setDate("2024-12-28");
//		post.setUser_id(4);
//		dao.save(post);
		
		
//
//		User user = null;
//		try {
//			user = dao.findByID(4);
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//		}
//
//		if(user != null) {
//			System.out.println("Id: " + user.getId());
//			System.out.println("Nome: " + user.getName());
//			System.out.println("Sexo: " + user.getSex());
//			System.out.println("Email: " + user.getEmail());
//			System.out.println();
//		}
		
		
//		Post post = null;
//		
//		try {
//			post = dao.findByID(2);
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//		}
//		
//		if(post != null) {
//			System.out.println("Id: " + post.getId());
//			System.out.println("Content: " + post.getContent());
//			System.out.println("Post Date: " + post.getDate().toString());
//			System.out.println("User id: " + post.getUser_id());
//			System.out.println();
//		}else {
//			System.out.println("nulo");
//		}
	}
}
