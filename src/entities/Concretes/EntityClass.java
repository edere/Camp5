package entities.Concretes;

import entities.Abstracts.Login;

public class EntityClass implements Login {

	private String email;
	private String password;
	public EntityClass() {
		
	}

	public EntityClass(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
