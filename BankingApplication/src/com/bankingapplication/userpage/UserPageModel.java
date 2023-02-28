package com.bankingapplication.userpage;

import java.util.List;

import com.bankingapplication.bankdetails.BankDetails;
import com.bankingapplication.transaction.TransactionRepository;
import com.bankingapplication.transaction.Transactions;
import com.bookingapplication.bankdetailsrepository.BankDetailsRepository;

public class UserPageModel implements UserPageControllerToModelCall{

	private String userId;
	private UserPageModelToControllerCall userPageModelToControllerCall;
	public UserPageModel(UserPageController userPageController) {

		userPageModelToControllerCall = userPageController;
	}

	@Override
	public void checkPinNumberforDeposit(int pin,String userId) {
		
		if(BankDetailsRepository.getInstance().checkPin(pin,userId)) {
			this.userId = userId;
			userPageModelToControllerCall.pinVerifySuccessfullyforDeposit();
		}
		else {
			
			userPageModelToControllerCall.pinVerifyFailedforDeposit(userId);
		}
	}

	@Override
	public void depositMoney(int money) {
		
		BankDetailsRepository.getInstance().depositMoney(money,userId);
		userPageModelToControllerCall.depositSuccessfully(money,userId);
	}

	@Override
	public void checkPinNumberforWithdrawal(int pin, String userId) {
	
		if(BankDetailsRepository.getInstance().checkPin(pin,userId)) {
			this.userId = userId;
			userPageModelToControllerCall.pinVerifySuccessfullyforWithdrawal();
		}
		else {
			
			userPageModelToControllerCall.pinVerifyFailedforWithdrawal(userId);
		}
	}

	@Override
	public void withdrawMoney(int money) {
	
		int value = BankDetailsRepository.getInstance().withdrawMoney(money,userId);
		if(value == 0) {
			
			userPageModelToControllerCall.withdrawalSuccessfully(userId);
		}
		else {
			
			userPageModelToControllerCall.withdrawalFailed(value,userId);
		}
	}

	@Override
	public void changePass(String pass, String userId) {
		
		BankDetailsRepository.getInstance().changePass(pass,userId);
	}

	@Override
	public void changePin(int pin, String userId) {
	
		BankDetailsRepository.getInstance().changePin(pin,userId);
		userPageModelToControllerCall.changePinSuccessfully(userId);
	}

	@Override
	public void changeDateOfBirth(String dateOfBirth, String userId) {
		
		String[] num = dateOfBirth.split("/");
		boolean correctSyntax = true;
		int[] val = new int[num.length];
		for (int i = 0; i < num.length; ++i) {

			if (i != 2 && num[i].charAt(0) >= 48 && num[i].charAt(0) <= 57 && num[i].charAt(1) >= 48
					&& num[i].charAt(1) <= 57) {

				val[i] = Integer.parseInt(num[i]);
				if (val[0] > 31 || val[0] < 0) {

					correctSyntax = false;
				} else if (val[1] < 0 || val[1] > 12) {

					correctSyntax = false;
				}
			} else if (num[i].charAt(0) >= 48 && num[i].charAt(0) <= 57 && num[i].charAt(1) >= 48
					&& num[i].charAt(1) <= 57 && num[i].charAt(2) >= 48 && num[i].charAt(2) <= 57
					&& num[i].charAt(3) >= 48 && num[i].charAt(3) <= 57) {

				val[i] = Integer.parseInt(num[i]);
				if (val[i] < 1950 || val[i] > 2020) {

					correctSyntax = false;
				}
			} else {

				correctSyntax = false;
			}
		}
		if(correctSyntax == true) {
			
			BankDetailsRepository.getInstance().changeDateOfBirth(dateOfBirth,userId);
			userPageModelToControllerCall.changeDob(userId);
		}
		else {
			
			userPageModelToControllerCall.dobWrong(userId);
		}
	}

	@Override
	public void changeMobNumber(String mobileNo, String userId) {
		
		boolean correctSyntax = true;
		for(int i = 0;i<mobileNo.length();++i) {
			
			if(mobileNo.charAt(i) < 48 || mobileNo.charAt(i) > 57) {
				
				correctSyntax = false;
				break;
			}
		}
		if(correctSyntax == true) {
			
			BankDetailsRepository.getInstance().changeMobNumber(mobileNo,userId);
			userPageModelToControllerCall.successfullyChangedMobileno(userId);
		}
		else {
			
			userPageModelToControllerCall.wrongMobileNo(userId);
		}
	}

	@Override
	public void checkBalance(int pin, String userId) {
		
		int amount = BankDetailsRepository.getInstance().checkBalance(pin,userId);
		if(amount != 0) {
			
			userPageModelToControllerCall.balance(amount,userId);
		}
		else {
			
			userPageModelToControllerCall.wrongPin(userId);
		}
	}

	@Override
	public void transactions(String userId) {
		
		List<Transactions> transactions = TransactionRepository.getInstance().getUserTransactions(userId);
		userPageModelToControllerCall.showGetMoney(transactions);
	}

	@Override
	public void checkTransacionDetails(String userId,int pin, String accountNumber, int money,String message) {
		
		
		List<BankDetails> trans = BankDetailsRepository.getInstance().moneyTransfer(userId,pin,accountNumber,money);
		if(trans == null) {
			
			userPageModelToControllerCall.transactionFailed(userId);
		}
		else {
			TransactionRepository.getInstance().addTransaction(userId,trans.get(0).getUserId(),trans.get(1).getName(), trans.get(0).getName(), trans.get(0).getAccountNumber(), money,message);
			userPageModelToControllerCall.transactionSuccess(userId);
		}
	}
}
