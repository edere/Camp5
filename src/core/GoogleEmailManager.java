package core;

import Web.GoogleMailManager;

public class GoogleEmailManager implements EmailService {
	
	private GoogleMailManager googleMailManager;
	
	public GoogleEmailManager() {
		googleMailManager = new GoogleMailManager();
	}
	
	@Override
	public void send(String email, String message) {
		
		googleMailManager.send(email, message);
		
	}

}
