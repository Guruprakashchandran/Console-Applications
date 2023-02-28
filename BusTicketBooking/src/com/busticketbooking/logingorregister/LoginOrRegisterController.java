package com.busticketbooking.logingorregister;

public class LoginOrRegisterController implements LoginOrRegisterViewToControllerCall,LoginOrRegisterModelToControllerCall{

	private LoginOrRegisterControllerToModelCall loginOrRegisterControllerToModelCall;
	private LoginOrRegisterControllerToViewCall loginOrRegisterControllerToViewCall;
	
	public LoginOrRegisterController(LoginOrRegisterView loginOrRegisterView) {
	
		loginOrRegisterControllerToModelCall = new LoginOrRegisterModel(this);
		loginOrRegisterControllerToViewCall = loginOrRegisterView;
	}

	@Override
	public void checkUserRegistrationDetails(String name, String mobileNo, String emailId, String password) {
		
		loginOrRegisterControllerToModelCall.checkUserRegistrationDetails(name,mobileNo,emailId,password);
	}

	@Override
	public void registerSuccessfully() {
		
		loginOrRegisterControllerToViewCall.registerSuccessfully();
	}

	@Override
	public void registerFailed() {
		
		loginOrRegisterControllerToViewCall.registerFailed();
	}

	@Override
	public void checkUserLogin(String emailId, String password) {
		
		loginOrRegisterControllerToModelCall.checkUserLogin(emailId,password);
;	}

	@Override
	public void loginFailed() {
		
		loginOrRegisterControllerToViewCall.loginFailed();
	}

	@Override
	public void loginSuccessfully(String emailId) {
		
		loginOrRegisterControllerToViewCall.loginSuccessfully(emailId);
	}

	@Override
	public void checkAdminLogin(String userName,String password) {
		
		loginOrRegisterControllerToModelCall.checkAdminLogin(userName,password);
	}

	@Override
	public void adminLoginSuccess() {
		
		loginOrRegisterControllerToViewCall.adminLoginSuccess();
	}

	@Override
	public void adminLoginFailed() {

		loginOrRegisterControllerToViewCall.adminLoginFailed();
	}
}
