package com.busticketbooking.userdetails;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserDetailsRepository {

	private static UserDetailsRepository userDetailsRepository;
	private Map<String,User> user = new LinkedHashMap<>();
	public UserDetailsRepository() {}
	
	public static UserDetailsRepository getInstance() {
		
		if(userDetailsRepository == null) {
			
			userDetailsRepository = new UserDetailsRepository();
		}
		return userDetailsRepository;
	}

	public boolean addUser(String name, String mobileNo, String emailId, String password) {
		
		if(user.containsKey(emailId)) {
			
			return false;
		}
		User detail = new User(name,mobileNo,emailId,password);
		user.put(emailId, detail);
		return true;
	}

	public boolean checkUserLogin(String emailId, String password) {
		
		if(user.containsKey(emailId) && user.get(emailId).getPassword().equals(password)) {
			
			return true;
		}
		return false;
	}


}
