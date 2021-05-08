package core;

import entities.Concretes.EntityClass;

public interface ExtrernalLoginService {

	
	void register(String email);
	boolean userExists(String email);
	void login(EntityClass ec);
}
