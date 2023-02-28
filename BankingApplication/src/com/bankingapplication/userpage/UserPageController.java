package com.bankingapplication.userpage;

import java.util.List;

import com.bankingapplication.transaction.Transactions;

public class UserPageController implements UserPageViewToControllerCall, UserPageModelToControllerCall {

	private UserPageControllerToModelCall userPageControllerToModelCall;
	private UserPageControllerToViewCall userPageControllerToViewCall;

	public UserPageController(UserPageView userPageView) {

		userPageControllerToModelCall = new UserPageModel(this);
		userPageControllerToViewCall = userPageView;
	}

	@Override
	public void checkPinNumberforDeposit(int pin, String userId) {

		userPageControllerToModelCall.checkPinNumberforDeposit(pin, userId);
	}

	@Override
	public void pinVerifySuccessfullyforDeposit() {

		userPageControllerToViewCall.pinVerifySuccessfullyforDeposit();
	}

	@Override
	public void depositMoney(int money) {
	
		userPageControllerToModelCall.depositMoney(money);
	}

	@Override
	public void depositSuccessfully(int money,String userId) {

		userPageControllerToViewCall.depositSuccessfully(money,userId);
	}

	@Override
	public void checkPinNumberforWithdrawal(int pin, String userId) {

		userPageControllerToModelCall.checkPinNumberforWithdrawal(pin,userId);
	}

	@Override
	public void pinVerifyFailedforDeposit(String userId) {

		userPageControllerToViewCall.pinVerifyFailedforDeposit(userId);
	}

	@Override
	public void pinVerifySuccessfullyforWithdrawal() {
		
		userPageControllerToViewCall.pinVerifySuccessfullyforWithdrawal();
	}

	@Override
	public void pinVerifyFailedforWithdrawal(String userId) {
		
		userPageControllerToViewCall.pinVerifyFailedforWithdrawal(userId);
	}

	@Override
	public void withdrawMoney(int money) {
		
		userPageControllerToModelCall.withdrawMoney(money);
	}

	@Override
	public void withdrawalFailed(int money,String userId) {
		
		userPageControllerToViewCall.withdrawalFailed(money,userId);
	}

	@Override
	public void withdrawalSuccessfully(String userId) {
		
		userPageControllerToViewCall.withdrawalSuccessfully(userId);
	}

	@Override
	public void changePass(String pass, String userId) {
	
		userPageControllerToModelCall.changePass(pass,userId);
	}

	@Override
	public void changePin(int pin, String userId) {

		userPageControllerToModelCall.changePin(pin,userId);
	}

	@Override
	public void changeDateOfBirth(String dateOfBirth, String userId) {
		
		userPageControllerToModelCall.changeDateOfBirth(dateOfBirth,userId);
	}

	@Override
	public void changeMobNumber(String mobileNo, String userId) {
		
		userPageControllerToModelCall.changeMobNumber(mobileNo,userId);
	}

	@Override
	public void dobWrong(String userId) {
		
		userPageControllerToViewCall.dobWrong(userId);
	}

	@Override
	public void changePinSuccessfully(String userId) {

		userPageControllerToViewCall.changePinSuccessfully(userId);
	}

	@Override
	public void changeDob(String userId) {

		userPageControllerToViewCall.changeDob(userId);
	}

	@Override
	public void successfullyChangedMobileno(String userId) {

		userPageControllerToViewCall.successfullyChangedMobileno(userId);
	}

	@Override
	public void wrongMobileNo(String userId) {

		userPageControllerToViewCall.wrongMobileNo(userId);
	}

	@Override
	public void checkBalance(int pin, String userId) {
		
		userPageControllerToModelCall.checkBalance(pin,userId);
	}

	@Override
	public void balance(int amount,String userId) {
		
		userPageControllerToViewCall.balance(amount,userId);
	}

	@Override
	public void wrongPin(String userId) {

		userPageControllerToViewCall.wrongPin(userId);
	}

	@Override
	public void transactions(String userId) {
		
		userPageControllerToModelCall.transactions(userId);
	}

	@Override
	public void showGetMoney(List<Transactions> transactions) {
		
		userPageControllerToViewCall.showGetMoney(transactions);
	}

	@Override
	public void checkTransacionDetails(String userId,int pin, String accountNumber, int money,String message) {
		
		userPageControllerToModelCall.checkTransacionDetails(userId,pin,accountNumber,money,message);
	}

	@Override
	public void transactionFailed(String userId) {

		userPageControllerToViewCall.transactionFailed(userId);
	}

	@Override
	public void transactionSuccess(String userId) {

		userPageControllerToViewCall.transactionSuccess(userId);
	}
}
