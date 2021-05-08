package business.Concretes;

import business.Abstracts.LoginService;
import business.Abstracts.UserService;
import core.Utils;
import entities.Concretes.EntityClass;
import entities.Concretes.User;

public class LoginManager implements LoginService{
	
	private UserService userService;
	
	public LoginManager(UserService userServices) {
		
		this.userService = userServices;
	}

	@Override
	public void register(User user) {
		
		if (userValidate(user) 
				&& passwordValidate(user.getPassword())
				&& userExists(user.getEmail())==false
				&& Utils.emailValidate(user.getEmail())) 
		{

			userService.add(user);
		}
		System.out.println("Olmadı");
		
	}

	@Override
	public void verify(User user, String token) {
		if (user!=null && token.length()>20) {
			User exitsUser = userService.get(user.getEmail());
			exitsUser.setVerify(true);	
			
			userService.update(exitsUser);
			System.out.println("Oldu");
		}
		System.out.println("Olmadııı");
		
	}

	@Override
	public boolean userExists(String email) {
        User user = userService.get(email);
		
		if (user==null) {
			return false;
		}
		System.out.println("Email mevcut. " + email);
		return true;
		
	}

	@Override
	public void login(EntityClass ec) {
        User user = userService.get(ec.getEmail());
		
		if (user!=null && user.getPassword().equals(ec.getPassword())) {
			
			System.out.println("Giriş temamm");
		}
		System.out.println("Üzgünüzzzz.");
		
	}
	
	public boolean userValidate(User user) {
		if(user!=null && 
				!user.getFirstName().isEmpty() &&
				!user.getLastName().isEmpty() && 
				!user.getEmail().isEmpty() &&
				!user.getPassword().isEmpty()) {
			
			return true;
		}
		return false;
	}
	
	 public boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
		}
		System.out.println("Şifreniz en az 6 karakter olmalııı.");
		return false;
		
	}
	
}
