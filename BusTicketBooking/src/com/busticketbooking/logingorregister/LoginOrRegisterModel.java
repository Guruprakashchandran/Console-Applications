package com.busticketbooking.logingorregister;

import com.busticketbooking.userdetails.UserDetailsRepository;

public class LoginOrRegisterModel implements LoginOrRegisterControllerToModelCall{

	private LoginOrRegisterModelToControllerCall loginOrRegisterModelToControllerCall;

	public LoginOrRegisterModel(LoginOrRegisterController loginOrRegisterController) {
	
		loginOrRegisterModelToControllerCall = loginOrRegisterController;
	}

	@Override
	public void checkUserRegistrationDetails(String name, String mobileNo, String emailId, String password) {
		
		if(UserDetailsRepository.getInstance().addUser(name,mobileNo,emailId,password)) {
			
			loginOrRegisterModelToControllerCall.registerSuccessfully();
		}
		else {
			
			loginOrRegisterModelToControllerCall.registerFailed();
		}
	}

	@Override
	public void checkUserLogin(String emailId, String password) {

		if(UserDetailsRepository.getInstance().checkUserLogin(emailId,password)) {
			
			loginOrRegisterModelToControllerCall.loginSuccessfully(emailId);
		}
		else {
			
			loginOrRegisterModelToControllerCall.loginFailed();
		}
	}

	@Override
	public void checkAdminLogin(String userName,String password) {
		
		if(userName.equals("guru") && password.equals("Owner")) {
			
			loginOrRegisterModelToControllerCall.adminLoginSuccess();
		}
		else {
			
			loginOrRegisterModelToControllerCall.adminLoginFailed();
		}
	}
}
