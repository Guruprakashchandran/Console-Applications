package com.chatapplication.loginorregisterpage;

import com.chatapplication.userdetails.User;
import com.chatapplication.userdetails.UserDetailsRepository;

public class LoginOrRegisterPageModel implements LoginOrRegisterPageControllerToModelCall {

	private LoginOrRegisterPageModelToControllerCall loginOrRegisterPageModelToControllerCall;

	public LoginOrRegisterPageModel(LoginOrRegisterPageController loginOrRegisterPageController) {

		loginOrRegisterPageModelToControllerCall = loginOrRegisterPageController;
	}

	@Override
	public void setUserDetails(User user) {

		boolean register = UserDetailsRepository.getInstance().addDetails(user);
		if (register) {

			loginOrRegisterPageModelToControllerCall.addedSuccessfully();
		} else {

			loginOrRegisterPageModelToControllerCall.userMobileNoExist();
		}
	}

	@Override
	public void checkLogin(User user) {

		User userDetail = UserDetailsRepository.getInstance().checkLogin(user);

		if (userDetail != null) {

			loginOrRegisterPageModelToControllerCall.loginSuccess(user);
		} else {

			loginOrRegisterPageModelToControllerCall.loginFailed();
		}
	}

	@Override
	public void closeConnection() {
		
		UserDetailsRepository.getInstance().closeConnection();
	}
}