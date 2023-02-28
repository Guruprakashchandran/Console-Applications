package com.bankingapplication.userpage;

public interface UserPageViewToControllerCall {

	void depositMoney(int money);

	void checkPinNumberforWithdrawal(int pin, String userId);

	void checkPinNumberforDeposit(int pin, String userId);

	void withdrawMoney(int money);

	void changePass(String pass, String userId);

	void changePin(int pin, String userId);

	void changeDateOfBirth(String dateOfBirth, String userId);

	void changeMobNumber(String mobileNo, String userId);

	void checkBalance(int pin, String userId);

	void transactions(String userId);

	void checkTransacionDetails(String userId, int pin, String accountNumber, int money, String message);
}
