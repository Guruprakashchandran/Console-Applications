package com.bankingapplication.loginorregisterpage;

public interface LoginOrRegisterPageControllerToViewCall {

	void loginSuccessfully(String userId);

	void userIdNotFound();

	void wrongPassword();

	void wrongDetails(String string);

	void checkingOTP(int otp);

	void wrongOTP();

	void registerSuccessfully();

	void registrationFailed();

	void setOtpPin();

	void adminLoginSuccess();

	void adminPasswordWrong();

	void adminUsernameWrong();

}
