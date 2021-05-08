package dataAccess.Concrete;

import java.util.ArrayList;
import java.util.List;

import dataAccess.Abstract.UserDal;
import entities.Concretes.User;

public class UserClass implements UserDal {

	private List<User> users = new ArrayList<User>();
	
	public UserClass() {
		
		User user1 = new User(1, "Esra", "Dere",
				"edere@gmail.com", "777777", true);
		
		users.add(user1);
	}
	
	@Override
	public void add(User user) {
		System.out.println("Kaydedildi : " + user.getEmail());
		users.add(user);
	}

	@Override
	public void update(User user) {
		User userUpdate = users.stream()
				.filter(u->u.getId()==user.getId())
				.findFirst()
				.orElse(user);
		
		userUpdate.setEmail(user.getEmail());
		userUpdate.setFirstName(user.getFirstName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setVerify(user.isVerify());
		
		
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u->u.getId()==userId)
				.findFirst()
				.orElse(null);
		users.remove(userToDelete);
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.getEmail()==email)
				.findFirst()
				.orElse(null);
		return user;
	}

}
