package com.busticketbooking.logingorregister;

import java.util.Scanner;

import com.busticketbooking.adminpage.AdminPageView;
import com.busticketbooking.passengerpage.PassengerPageView;
import com.busticketbooking.utils.UtilsClass;

public class LoginOrRegisterView implements LoginOrRegisterControllerToViewCall{

	private Scanner scan = new Scanner(System.in);
	private LoginOrRegisterViewToControllerCall loginOrRegisterViewToControllerCall;
	private UtilsClass util = new UtilsClass();
	
	public LoginOrRegisterView() {
		
		loginOrRegisterViewToControllerCall = new LoginOrRegisterController(this);
	}
	
	public static void main(String[] args) {
		
		new LoginOrRegisterView().mainPage();
	}
	public void mainPage() {
		
		try {
			System.out.println("\n**********BUS TICKET BOOKING**********");
			System.out.println("\n1) User\n2) Admin\n3) Exit");
			System.out.print("\nEnter Input : ");
			int input = scan.nextInt();
			switch(input) {
			
				case 1:
					userLoginOrRegister();
					break;
				case 2:
					adminLogin();
					break;
				case 3:
					System.out.println("\nExitted!!");
					break;
				default : 
					System.out.println("\nWrong input !!!");
					mainPage();
			}
		}
		catch(Exception e) {
			
			System.out.println("Wrong Input!!!");
			mainPage();
		}
	}

	private void userLoginOrRegister() {
		
		System.out.println("\n*************User Page*****************");
		System.out.println("\n1) Login\n2) Register\n3) Back\n4) Exit");
		System.out.print("\nEnter Input : ");
		int input = scan.nextInt();
		scan.nextLine();
		switch(input) {
		
			case 1:
				userLogin();
				break;
			case 2:
				userRegister();
				break;
			case 3:
				System.out.println("\nExitted!!!");
				break;
			default : 
				System.out.println("\nWrong Input!!!");
				userLoginOrRegister();
		}
	}

	private void userRegister() {
		
		System.out.println("\n----------Registration Page-----------------");
		System.out.println("\nIf You want to Back press 2");
		System.out.print("\nEnter Your Name : ");
		String name = scan.nextLine();
		if(name.equals("2")) {
			
			userLoginOrRegister();
		}
		System.out.print("Enter Your Mobile Number : ");
		String mobileNo = scan.next();
		System.out.print("Enter Your Email id : ");
		String emailId = scan.next();
		System.out.print("Enter Password (Minimum Length 8): ");
		String password = scan.next();
		System.out.print("Enter Confirm Password : ");
		String confirmPassword = scan.next();
		if(util.checkMobileNo(mobileNo) && util.checkEmailId(emailId) && util.checkPassword(password, confirmPassword)) {
			
			loginOrRegisterViewToControllerCall.checkUserRegistrationDetails(name,mobileNo,emailId,password);
		}
		else {
			
			System.out.println("\nWrong Details");
			scan.nextLine();
			userRegister();
		}
	}


	private void userLogin() {

		System.out.println("\n------------Login Page-------------");
		System.out.print("\nEnter User Email Id - ");
		String emailId = scan.next();
		System.out.print("Enter password - ");
		String password = scan.next();
		if(util.checkEmailId(emailId)) {
			
			loginOrRegisterViewToControllerCall.checkUserLogin(emailId,password);
		}
		else {
			
			System.out.println("\nEmail Id Invalid!!!");
		}
	}

	private void adminLogin() {
		
		System.out.println("\n-------------Admin Login Page--------------------");
		System.out.print("\nEnter UserName - ");
		String userName = scan.next();
		System.out.print("\nEnter Password - ");
		String password = scan.next();
		loginOrRegisterViewToControllerCall.checkAdminLogin(userName,password);
	}

	@Override
	public void registerSuccessfully() {
		
		System.out.println("\nRegistration Successfully!!!");
		userLogin();
	}

	@Override
	public void registerFailed() {
		
		System.out.println("\nRegistration Failed!!");
		userLoginOrRegister();
	}

	@Override
	public void loginSuccessfully(String emailId) {
		
		System.out.println("\nLogin Successfully!!!");
		new PassengerPageView().passengerPage(emailId);
	}

	@Override
	public void loginFailed() {
		
		System.out.println("\nLogin Failed!!!");
	}

	@Override
	public void adminLoginSuccess() {
		
		System.out.println("\nLogin Successfully!!!");
		new AdminPageView().adminMainPage();
	}

	@Override
	public void adminLoginFailed() {
		
		System.out.println("\nLogin Failed!!!");
		mainPage();
	}
}
