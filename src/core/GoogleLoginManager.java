package core;

import business.Abstracts.UserService;
import entities.Concretes.EntityClass;
import entities.Concretes.User;

public class GoogleLoginManager implements ExtrernalLoginService {

	private UserService userService;
	
	public GoogleLoginManager(UserService userService) {
		
		this.userService = userService;
	}

	@Override
	public void register(String email) {
		
		if(userExists(email)==false) {
			userService.add(null);
			
		}else {
			User user = userService.get(email);
			
			EntityClass ec = new EntityClass();
			ec.setPassword(user.getPassword());
			ec.setEmail(user.getEmail());
		}
		
	}

	@Override
	public boolean userExists(String email) {
		if (userService.get(email)!=null) {
			return true;
			
		} return false;
	}

	@Override
	public void login(EntityClass ec) {
		
		if(ec!=null && ec.getPassword().equals(ec.getPassword())) {
			System.out.println("Oldu.");
		}
			else {
				System.out.println("Olmadýýý.");
			}
		}
		
	}


