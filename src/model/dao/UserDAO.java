package model.dao;

import java.util.List;

import model.entities.User;

public interface UserDAO {
	boolean save(User user); //criação
	List<User> listAll(); //leitura
	boolean update(User user); //update
	boolean delete(User user); //delete
	User findByID(User user); 
}
