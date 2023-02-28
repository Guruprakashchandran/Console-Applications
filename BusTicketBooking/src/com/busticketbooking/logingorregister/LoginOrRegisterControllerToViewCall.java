package com.busticketbooking.logingorregister;

public interface LoginOrRegisterControllerToViewCall {

	void registerSuccessfully();

	void registerFailed();

	void loginSuccessfully(String emailId);

	void loginFailed();

	void adminLoginSuccess();

	void adminLoginFailed();

}
