package model.dao;

import java.util.List;

import model.ModelException;
import model.entities.User;

public interface UserDAO {
	boolean save(User user); //criação
	List<User> listAll() throws ModelException; //leitura
	boolean update(User user); //update
	boolean delete(User user); //delete
	User findByID(int id); 
}
