package business.Abstracts;

import java.util.List;

import entities.Concretes.User;

public interface UserService {

	void add(User user);
	void update(User user);
	void delete(int userId);
	User get(String email);
	List<User> getAll();
}
