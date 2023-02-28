package com.bankingapplication.loginorregisterpage;

public interface LoginOrRegisterPageViewToControllerCall {

	void checkLoginCredentials(String creditCardNo, String pin);

	void verifyOTP(int newOtp, int otp);

	void setPin(int pin);

	void checkRegistrationDetails(String userId, String accountNumber, String creditCardNumber, String password,
			String mobileNo, String dateOfBirth, String conPassword);

	void checkAdminLogin(String userName, String password);

}
