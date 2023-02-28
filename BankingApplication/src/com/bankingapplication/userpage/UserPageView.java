package com.bankingapplication.userpage;

import java.util.List;
import java.util.Scanner;

import com.bankingapplication.loginorregisterpage.LoginOrRegisterPageView;
import com.bankingapplication.loginorregisterpage.LoginOrRegisterPageViewToUserPageView;
import com.bankingapplication.transaction.Transactions;

public class UserPageView implements LoginOrRegisterPageViewToUserPageView, UserPageControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private UserPageViewToControllerCall userPageViewToControllerCall;

	public UserPageView() {

		userPageViewToControllerCall = new UserPageController(this);
	}

	public void userMainPage(String userId) {

		System.out.println("\n*************USER MAIN PAGE*************");
		userPageViewToControllerCall.transactions(userId);
		System.out.println(
				"\n1) Deposit Money\n2) Withdraw Money\n3) Money Transfer\n4) Check Account Balance\n5) Edit Personal Details\n6) Back\n7) Exit");
		System.out.print("\nEnter the Input : ");
		int input = scan.nextInt();
		switch (input) {

		case 1:
			depositMoney(userId);
			break;
		case 2:
			withdrawMoney(userId);
			break;
		case 3:
			moneyTransfer(userId);
			break;
		case 4:
			checkAccountBalance(userId);
			break;
		case 5:
			editPersonalDetails(userId);
			break;
		case 6:
			new LoginOrRegisterPageView().mainPage();
			break;
		case 7:

			System.out.println("\nExitted!!!");
		}
	}

	private void editPersonalDetails(String userId) {

		System.out.println("1) Change Mobile no\n2) Date Of Birth\n3) Change PIN\n4) Change Password\n5) back\n6) Exit");
		System.out.print("Enter the Input : ");
		int input = scan.nextInt();
		switch (input) {

		case 1:
			changeMobileNumber(userId);
			break;
		case 2:
			changeDateOfBirth(userId);
			break;
		case 3:
			changePin(userId);
			break;
		case 4:
			changePassword(userId);
			break;
		case 5:
			new LoginOrRegisterPageView().mainPage();
			break;
		case 6:
			System.out.println("\nExitted!!!");
			break;
		default:
			System.out.println("\nWrong Input!!!");
			editPersonalDetails(userId);
		}
	}

	private void changePassword(String userId) {

		System.out.print("\nChange Password (length above 8): ");
		String pass = scan.next();
		System.out.print("Enter Confirm Password : ");
		String conPass = scan.next();
		if (pass.length() > 7 && pass.equals(conPass)) {

			userPageViewToControllerCall.changePass(pass, userId);
		} else {

			System.out.println("\nPlease!!!Enter Password Length above 8");
			changePassword(userId);
		}
	}

	private void changePin(String userId) {

		System.out.print("\nEnter the Pin (4 digit): ");
		int pin = scan.nextInt();
		if (pin > 999 && pin < 10000) {

			userPageViewToControllerCall.changePin(pin, userId);
		} else {

			System.out.println("Wrong Pin!!!");
			changePin(userId);
		}
	}

	private void changeDateOfBirth(String userId) {

		System.out.print("\nEnter the Date Of Birth (01/01/2001): ");
		String dateOfBirth = scan.next();
		if (dateOfBirth.length() == 10) {

			userPageViewToControllerCall.changeDateOfBirth(dateOfBirth, userId);
		} else {

			System.out.println("Wrong Date Of Birth!!!");
			changeDateOfBirth(userId);
		}
	}

	private void changeMobileNumber(String userId) {

		System.out.print("\nEnter the Mobile Number : ");
		String mobileNo = scan.next();
		if (mobileNo.length() == 10) {

			userPageViewToControllerCall.changeMobNumber(mobileNo, userId);
		} else {

			System.out.println("Wrong Mobile Number !!!");
			changeMobileNumber(userId);
		}
	}

	private void checkAccountBalance(String userId) {

		int pin = getPin();
		userPageViewToControllerCall.checkBalance(pin, userId);
	}

	private void moneyTransfer(String userId) {

		System.out.println("\n----------Money Transfer----------------");
		int pin = getPin();
		System.out.println("Enter Account number : ");
		String accountNumber = scan.next();
		System.out.print("Please!!!Enter Money : ");
		int money = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter Message : ");
		String message = scan.nextLine();
//		System.out.println();
		userPageViewToControllerCall.checkTransacionDetails(userId,pin,accountNumber,money,message);
		
	}

	private void withdrawMoney(String userId) {

		int pin = getPin();
		userPageViewToControllerCall.checkPinNumberforWithdrawal(pin, userId);
	}

	private void depositMoney(String userId) {

		int pin = getPin();
		userPageViewToControllerCall.checkPinNumberforDeposit(pin, userId);
	}

	@Override
	public void pinVerifySuccessfullyforDeposit() {

		System.out.print("\nPlease!!Enter Money : ");
		int money = scan.nextInt();
		userPageViewToControllerCall.depositMoney(money);
	}

	@Override
	public void depositSuccessfully(int money, String userId) {

		System.out.println("\n" + money + " amount Deposited Successfully!!!");
		userMainPage(userId);
	}

	@Override
	public void pinVerifyFailedforDeposit(String userId) {

		System.out.println("\nWrong Pin!!!");
		userMainPage(userId);
	}

	@Override
	public void pinVerifyFailedforWithdrawal(String userId) {

		System.out.println("\nWrong Pin");
		userMainPage(userId);
	}

	@Override
	public void pinVerifySuccessfullyforWithdrawal() {

		System.out.print("\nPlease!!Enter Money : ");
		int money = scan.nextInt();
		userPageViewToControllerCall.withdrawMoney(money);
	}

	@Override
	public void withdrawalFailed(int money, String userId) {

		System.out.println("\nOnly You have " + money + " amount");
		userMainPage(userId);
	}

	@Override
	public void withdrawalSuccessfully(String userId) {

		System.out.println("\nWithdrawal Successfully!!!");
		userMainPage(userId);
	}

	@Override
	public void wrongMobileNo(String userId) {

		System.out.println("\nWrong Mobile Number!!!");
		editPersonalDetails(userId);
	}

	@Override
	public void successfullyChangedMobileno(String userId) {

		System.out.println("\nSuccessfully Mobile Number Changed!!!");
		userMainPage(userId);
	}

	@Override
	public void changeDob(String userId) {

		System.out.println("\nSuccessfully Date Of Birth Changed!!!");
		userMainPage(userId);
	}

	@Override
	public void changePinSuccessfully(String userId) {

		System.out.println("\nSuccessfully PIN Changed!!!");
		userMainPage(userId);
	}

	@Override
	public void dobWrong(String userId) {

		System.out.println("\nWrong Date Of Birth Information!!!");
		editPersonalDetails(userId);
	}

	@Override
	public void wrongPin(String userId) {

		System.out.println("Wrong Pin!!!");
		System.out.println("Re Enter Pin");
		editPersonalDetails(userId);
	}

	@Override
	public void balance(int amount, String userId) {

		System.out.println("Account Balance : " + amount);
		userMainPage(userId);
	}
	private int  getPin() {
		
		System.out.print("Enter Pin : ");
		int pin = scan.nextInt();
		if(pin < 1000 || pin > 9999) {
			
			System.out.println("\nWrong Input!!!");
			getPin();
		}
		return pin;
	}

	@Override
	public void showGetMoney(List<Transactions> transactions) {
		
		if(transactions.size()>0) {
		
			for(int i = 0;i<transactions.size();++i) {
				
				System.out.printf("\n%s%5s%20s",transactions.get(i).getSenderName(),transactions.get(i).getMoney()," Money Sended To You!!!");
			}
			System.out.println();
		}
	}

	@Override
	public void transactionSuccess(String userId) {
		
		System.out.println("\nTransaction Successfully!!");
		userMainPage(userId);
	}

	@Override
	public void transactionFailed(String userId) {
		
		System.out.println("\nTransaction Failed!!!");
		userMainPage(userId);
	}
}
