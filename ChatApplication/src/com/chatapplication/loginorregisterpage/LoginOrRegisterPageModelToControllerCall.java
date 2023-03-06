package com.chatapplication.loginorregisterpage;

import com.chatapplication.userdetails.User;

public interface LoginOrRegisterPageModelToControllerCall {

	void addedSuccessfully();

	void userMobileNoExist();

	void userEmailExist();

	void loginFailed();

	void loginSuccess(User userDetail);

}
