package com.bankingapplication.userpage;

import java.util.List;

import com.bankingapplication.transaction.Transactions;

public interface UserPageModelToControllerCall {


	void depositSuccessfully(int money, String userId);

	void pinVerifySuccessfullyforDeposit();

	void pinVerifyFailedforDeposit(String userId);

	void pinVerifySuccessfullyforWithdrawal();

	void pinVerifyFailedforWithdrawal(String userId);

	void withdrawalFailed(int money, String userId);

	void withdrawalSuccessfully(String userId);

	void dobWrong(String userId);

	void changePinSuccessfully(String userId);

	void changeDob(String userId);

	void successfullyChangedMobileno(String userId);

	void wrongMobileNo(String userId);

	void balance(int amount, String userId);

	void wrongPin(String userId);

	void showGetMoney(List<Transactions> transactions);

	void transactionFailed(String userId);

	void transactionSuccess(String userId);

}
