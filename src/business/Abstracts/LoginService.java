package business.Abstracts;


import entities.Concretes.EntityClass;
import entities.Concretes.User;

public interface LoginService {

	void register(User user);
	void verify(User user, String token);
	boolean userExists(String email);
	void login(EntityClass dto);
}
