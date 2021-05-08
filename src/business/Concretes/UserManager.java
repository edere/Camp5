package business.Concretes;

import java.util.List;

import business.Abstracts.UserService;
import core.EmailService;
import dataAccess.Concrete.UserClass;
import entities.Concretes.User;

public class UserManager implements UserService {
	
	private UserClass userclass;
	private EmailService eMailService;
	
	
	public UserManager(UserClass userclass, EmailService eMailService) {
		this.userclass = userclass;
		this.eMailService = eMailService;
	}

	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userclass.add(user);
			
			eMailService.send(user.getEmail(), "Kayýt Baþarýlý");
		}
		
	}

	@Override
	public void update(User user) {
		
		if (userValidate(user)) {
			userclass.update(user);
		}
		
	}

	@Override
	public void delete(int userId) {
		userclass.delete(userId);
		
	}

	@Override
	public User get(String email) {
		
		return userclass.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userclass.getAll()) {
			System.out.println(user.getId() + " " + user.getEmail());
		}
		return userclass.getAll();
	}
	

    public boolean userValidate(User user) {
	if(user.getFirstName().length() >=2 && user.getLastName().length() >=2) {
		return true;
	}else {
	System.out.println("Ad ve Soyadýnýz en az 2 harf olmalýdýr. ");
	return false;
	}

}

	
}