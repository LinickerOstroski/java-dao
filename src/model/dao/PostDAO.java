package model.dao;

import java.util.List;

import model.ModelException;
import model.entities.Post;

public interface PostDAO {
	boolean save(Post post) throws ModelException; //criação
	List<Post> listAll() throws ModelException; //leitura
	boolean update(Post post) throws ModelException; //update
	boolean delete(Post post) throws ModelException; //delete
	Post findByID(int id) throws ModelException; 
}
