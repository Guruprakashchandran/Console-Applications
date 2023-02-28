package com.busticketbooking.logingorregister;

public interface LoginOrRegisterModelToControllerCall {

	void registerSuccessfully();

	void registerFailed();

	void loginFailed();

	void loginSuccessfully(String emailId);

	void adminLoginSuccess();

	void adminLoginFailed();

}
