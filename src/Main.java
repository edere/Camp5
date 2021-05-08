import business.Concretes.LoginManager;
import business.Concretes.UserManager;
import core.GoogleEmailManager;
import dataAccess.Concrete.UserClass;
import entities.Concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserClass usercs = new UserClass();
		LoginManager authManager = new LoginManager(new UserManager(usercs,
				new GoogleEmailManager()));
		
		
		
		User etem = new User(4,"Esra", "Dere", 
				"edereee@gmail.com", "77777522",true);
		
		authManager.register(etem);
		
		UserManager userManager = new UserManager(new UserClass(),
				new GoogleEmailManager());
	
		userManager.update(etem);

	}

}
