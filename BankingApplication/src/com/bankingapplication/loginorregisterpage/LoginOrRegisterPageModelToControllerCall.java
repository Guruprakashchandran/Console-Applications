package com.bankingapplication.loginorregisterpage;

public interface LoginOrRegisterPageModelToControllerCall {

	void loginSuccessfully(String userId);

	void userIdNotFound();

	void wrongPassword();

	void wrongDetail(String string);

	void checkingOTP(int otp);

	void wrongOTP();

	void registerSuccessfully();

	void registrationFailed();

	void setOtpPin();

	void adminUsernameWrong();

	void adminPasswordWrong();

	void adminLoginSuccess();

}
