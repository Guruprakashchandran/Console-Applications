package com.bankingapplication.loginorregisterpage;

import java.util.Scanner;

import com.bankingapplication.adminpage.AdminPageView;
import com.bankingapplication.userpage.UserPageView;

public class LoginOrRegisterPageView implements LoginOrRegisterPageControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private LoginPageViewToAdminPageView loginPageViewToAdminPageView;
	private LoginOrRegisterPageViewToUserPageView loginOrRegisterPageViewToUserPageView;
	private LoginOrRegisterPageViewToControllerCall loginOrRegisterPageViewToControllerCall;

	public LoginOrRegisterPageView() {

		loginOrRegisterPageViewToControllerCall = new LoginOrRegisterPageController(this);
	}

	public static void main(String[] args) {

		new LoginOrRegisterPageView().mainPage();
	}

	public void mainPage() {

//		System.out.println("**************KASE THAN KADAVULADA**************");
		System.out.println("\n*****************Banking Application**************");
		System.out.println("\n1) User Page\n2) Admin Page\n3) Exit");
		System.out.print("\nPlease!!!Enter the Input : ");
		int input = scan.nextInt();
		switch (input) {

		case 1:

			userPageDetails();
			break;
		case 2:
			adminLogin();
			break;
		case 3:

			System.out.println("Exitted!!!");
			break;
		default:

			System.out.println("\nWrong Input!!!");
			System.out.println("Re Enter the Input!!!");
			mainPage();
		}
	}

	public void userPageDetails() {

		System.out.println("\n---------------User Page-----------");
		System.out.println("\n1) Login\n2) Registration\n3) Back\n4) Exit");
		System.out.print("\nPlease!!!Enter the Input : ");
		int input = scan.nextInt();
		scan.nextLine();
		switch (input) {

		case 1:
			userLogin();
			break;
		case 2:
			userRegistration();
			break;
		case 3:
			mainPage();
			break;
		case 4:
			System.out.println("Exitted!!!");
			break;
		default:
			System.out.println("Wrong Input!!!");
			System.out.println("ReEnter the Input!!!");
		}
	}

	public void userLogin() {

		System.out.println("\n-----Login Page-----");
		System.out.print("\nEnter User Id (Unique Id): ");
		String userId = scan.next();
		System.out.print("\nEnter Password : ");
		String password = scan.next();
		loginOrRegisterPageViewToControllerCall.checkLoginCredentials(userId, password);
	}

	public void userRegistration() {

		System.out.println("\n----------Registration Page------------");
		System.out.println("\nIf you Want Exit Enter 2");
		System.out.print("\nEnter User Id (4 Digit number) : ");
		String userId = scan.next();
		if(userId.equals("2")) {
			
			mainPage();
		}
		else {
			System.out.print("Enter Account No : ");
			String accountNumber = scan.next();
			System.out.print("Enter Name : ");
			String name = scan.next();
			System.out.print("Enter Mobile No : ");
			String mobileNo = scan.next();
			System.out.print("Enter Date of Birth (Ex : 01/01/2001): ");
			String dateOfBirth = scan.next();
			System.out.print("Enter Password (length above 8): ");
			String password = scan.next();
			System.out.print("Confirm Password : ");
			String conPassword = scan.next();
			loginOrRegisterPageViewToControllerCall.checkRegistrationDetails(userId, name,accountNumber,password, mobileNo,
					dateOfBirth,conPassword);
		}
	}

	@Override
	public void loginSuccessfully(String userId) {

		System.out.println("\n" + userId + " Login Successfully!!");
		loginOrRegisterPageViewToUserPageView = new UserPageView();
		loginOrRegisterPageViewToUserPageView.userMainPage(userId);
	}

	@Override
	public void userIdNotFound() {

		System.out.println("\nWrong User Id!!!");
		userLogin();
	}

	@Override
	public void wrongPassword() {

		System.out.println("\nWrong Password!!!");
		userLogin();
	}

	@Override
	public void wrongDetails(String string) {

		String[] errors = string.split(" ");
		System.out.println();
		for (int i = 0; i < errors.length; ++i) {

			System.out.println("Wrong " + errors[i]);
		}
		userRegistration();
	}

	@Override
	public void checkingOTP(int otp) {

		System.out.println("\n-----------Checking OTP-----------");
		System.out.println("OTP - " + otp);
		System.out.print("\nEnter OTP : ");
		int newOtp = scan.nextInt();
		loginOrRegisterPageViewToControllerCall.verifyOTP(newOtp, otp);
	}

	@Override
	public void wrongOTP() {

		System.out.println("\nWrong OTP!!!");
		userRegistration();
	}

	@Override
	public void registerSuccessfully() {

		System.out.println("\nRegistered Successfully!!!");
		userLogin();
	}

	@Override
	public void registrationFailed() {

		System.out.println("\nRegistration Failed!!!");
		System.out.print("\nSet Pin (4 digit): ");
		int pin = scan.nextInt();
		loginOrRegisterPageViewToControllerCall.setPin(pin);
	}

	@Override
	public void setOtpPin() {

		System.out.print("\nSet Pin (4 digit): ");
		int pin = scan.nextInt();
		loginOrRegisterPageViewToControllerCall.setPin(pin);
	}
	public void adminLogin() {
		
		System.out.print("\nEnter the UserName : ");
		String userName = scan.next();
		System.out.print("Enter Password : ");
		String password = scan.next();
		loginOrRegisterPageViewToControllerCall.checkAdminLogin(userName,password);
		
	}

	@Override
	public void adminLoginSuccess() {

		System.out.println("\nAdmin Login Successfully!!!");
		loginPageViewToAdminPageView = new AdminPageView();
		loginPageViewToAdminPageView.adminMainPage();
	}

	@Override
	public void adminPasswordWrong() {

		System.out.println("\nAdmin Password Wrong!!!");
		mainPage();
	}

	@Override
	public void adminUsernameWrong() {
		
		System.out.println("\nAdmin UserName Wrong!!!");
		mainPage();
	}
}
