package model.entities;

public class User {
	private int id;
	private String name;
	private String sex;
	private String email;
	
	public User() {
		this(0); //isso aqui é igual o super
	}
	
	public User(int id){
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	
}
