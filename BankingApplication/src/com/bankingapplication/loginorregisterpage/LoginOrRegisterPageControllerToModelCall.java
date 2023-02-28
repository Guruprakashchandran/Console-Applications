package com.bankingapplication.loginorregisterpage;

public interface LoginOrRegisterPageControllerToModelCall {

	void checkLoginCredentials(String creditCardNo, String pin);

	void checkRegistrationDetails(String userId, String accountNumber,String creditCardNumber, String password, String mobileNo,
			String dateOfBirth, String conPassword);

	void verifyOTP(int newOtp, int otp);

	void setPin(int pin);

	void checkAdminLogin(String userName, String password);

}
