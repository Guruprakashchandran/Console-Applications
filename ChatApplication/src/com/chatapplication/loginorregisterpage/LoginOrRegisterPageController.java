package com.chatapplication.loginorregisterpage;

import com.chatapplication.userdetails.User;

public class LoginOrRegisterPageController implements LoginOrRegisterPageViewToControllerCall,LoginOrRegisterPageModelToControllerCall{

	private LoginOrRegisterPageControllerToViewCall loginOrRegisterPageControllerToViewCall;
	private LoginOrRegisterPageControllerToModelCall loginOrRegisterPageControllerToModelCall;
	public LoginOrRegisterPageController(LoginOrRegisterPageView loginOrRegisterPageView) {
		
		loginOrRegisterPageControllerToViewCall = loginOrRegisterPageView;
		loginOrRegisterPageControllerToModelCall = new LoginOrRegisterPageModel(this);
	}
	@Override
	public void setUserDetails(User user) {
		
		loginOrRegisterPageControllerToModelCall.setUserDetails(user);
	}
	@Override
	public void userMobileNoExist() {
		
		loginOrRegisterPageControllerToViewCall.userMobileNoExist();
	}
	@Override
	public void addedSuccessfully() {
		
		loginOrRegisterPageControllerToViewCall.addedSuccessfully();
	}
	@Override
	public void userEmailExist() {
		
		loginOrRegisterPageControllerToViewCall.userEmailExist();
	}
	@Override
	public void checkLogin(User user) {
	
		loginOrRegisterPageControllerToModelCall.checkLogin(user);
	}
	@Override
	public void loginFailed() {
		
		loginOrRegisterPageControllerToViewCall.loginFailed();
	}
	@Override
	public void loginSuccess(User user) {
		
		loginOrRegisterPageControllerToViewCall.loginSuccess(user);
	}
	@Override
	public void closeConnection() {
	
		loginOrRegisterPageControllerToModelCall.closeConnection();
	}
}
