package dataAccess.Abstract;

import java.util.List;

import entities.Concretes.User;

public interface UserDal {

	void add(User user);
	void update(User user);
	void delete(int userId);
	List<User> getAll();
	User get(String email);
}
