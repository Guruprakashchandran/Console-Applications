package com.bankingapplication.loginorregisterpage;

public class LoginOrRegisterPageController
		implements LoginOrRegisterPageViewToControllerCall, LoginOrRegisterPageModelToControllerCall {

	private LoginOrRegisterPageControllerToViewCall loginOrRegisterPageControllerToViewCall;
	private LoginOrRegisterPageControllerToModelCall loginOrRegisterPageControllerToModelCall;

	public LoginOrRegisterPageController(LoginOrRegisterPageView loginOrRegisterPageView) {

		loginOrRegisterPageControllerToModelCall = new LoginOrRegisterPageModel(this);
		loginOrRegisterPageControllerToViewCall = loginOrRegisterPageView;
	}

	@Override
	public void checkLoginCredentials(String userId, String password) {

		loginOrRegisterPageControllerToModelCall.checkLoginCredentials(userId, password);
	}

	@Override
	public void checkRegistrationDetails(String userId, String name,String accountNumber, String password, String mobileNo,
			String dateOfBirth, String conPassword) {

		loginOrRegisterPageControllerToModelCall.checkRegistrationDetails(userId, name,accountNumber, password, mobileNo,
				dateOfBirth, conPassword);
	}

	@Override
	public void loginSuccessfully(String userId) {

		loginOrRegisterPageControllerToViewCall.loginSuccessfully(userId);
	}

	@Override
	public void userIdNotFound() {

		loginOrRegisterPageControllerToViewCall.userIdNotFound();
	}

	@Override
	public void wrongPassword() {

		loginOrRegisterPageControllerToViewCall.wrongPassword();
	}

	@Override
	public void wrongDetail(String string) {

		loginOrRegisterPageControllerToViewCall.wrongDetails(string);
	}

	@Override
	public void checkingOTP(int otp) {

		loginOrRegisterPageControllerToViewCall.checkingOTP(otp);
	}

	@Override
	public void verifyOTP(int newOtp, int otp) {

		loginOrRegisterPageControllerToModelCall.verifyOTP(newOtp, otp);
	}

	@Override
	public void wrongOTP() {

		loginOrRegisterPageControllerToViewCall.wrongOTP();
	}

	@Override
	public void registerSuccessfully() {

		loginOrRegisterPageControllerToViewCall.registerSuccessfully();
	}

	@Override
	public void setPin(int pin) {

		loginOrRegisterPageControllerToModelCall.setPin(pin);
	}

	@Override
	public void registrationFailed() {

		loginOrRegisterPageControllerToViewCall.registrationFailed();
	}

	@Override
	public void setOtpPin() {

		loginOrRegisterPageControllerToViewCall.setOtpPin();
	}

	@Override
	public void checkAdminLogin(String userName, String password) {
		
		loginOrRegisterPageControllerToModelCall.checkAdminLogin(userName,password);
	}

	@Override
	public void adminUsernameWrong() {
		
		loginOrRegisterPageControllerToViewCall.adminUsernameWrong();
	}

	@Override
	public void adminPasswordWrong() {
	
		loginOrRegisterPageControllerToViewCall.adminPasswordWrong();
	}

	@Override
	public void adminLoginSuccess() {
	
		loginOrRegisterPageControllerToViewCall.adminLoginSuccess();
	}
}
