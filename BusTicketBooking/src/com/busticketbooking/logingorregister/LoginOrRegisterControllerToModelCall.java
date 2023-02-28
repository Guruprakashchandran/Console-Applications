package com.busticketbooking.logingorregister;

public interface LoginOrRegisterControllerToModelCall {

	void checkUserRegistrationDetails(String name, String mobileNo, String emailId, String password);

	void checkUserLogin(String emailId, String password);

	void checkAdminLogin(String userName, String password);

}
