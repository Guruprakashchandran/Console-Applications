package com.chatapplication.loginorregisterpage;

import com.chatapplication.userdetails.User;

public interface LoginOrRegisterPageControllerToModelCall {

	void setUserDetails(User user);

	void checkLogin(User user);

	void closeConnection();

}
