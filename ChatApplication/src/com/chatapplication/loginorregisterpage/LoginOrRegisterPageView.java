package com.chatapplication.loginorregisterpage;

import java.util.Scanner;

import com.chatapplication.personalchat.PersonalChatView;
import com.chatapplication.userdetails.User;
import com.chatapplication.util.ChatUtil;

public class LoginOrRegisterPageView implements LoginOrRegisterPageControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private LoginOrRegisterPageViewToControllerCall loginOrRegisterPageViewToControllerCall;

	public LoginOrRegisterPageView() {

		loginOrRegisterPageViewToControllerCall = new LoginOrRegisterPageController(this);
	}

	public static void main(String[] args) {

		new LoginOrRegisterPageView().mainPage();
	}

	private void mainPage() {

		System.out.println("\n*****************CHAT APPLICATION********************");

		boolean isTrue = true;

		while (isTrue) {

			try {
				System.out.println("\n1) Login\n2) Register\n3) Exit");
				System.out.print("\nEnter Input : ");
				int input = scan.nextInt();
				switch (input) {

				case 1:
					login();
					break;
				case 2:
					register();
					break;
				case 3:
					System.out.println("Exitted!!!");
					loginOrRegisterPageViewToControllerCall.closeConnection();
					isTrue = false;
					break;
				default:
					System.out.println("Wrong Input !!!");
				}
			} catch (Exception e) {

				scan.nextLine();
				System.out.println("\nWrong Input!!!");
			}
		}
	}

	private void login() {

		System.out.print("\n---------------Login Page-----------------");
		System.out.println("\nIf you want to Exit Press 2");
		String mobileNo = getMobileNo();
		String password = getPasswordforLogin();
		User user = new User(null,mobileNo,null,0,null ,password,null);
		loginOrRegisterPageViewToControllerCall.checkLogin(user);
	}

	private String getPasswordforLogin() {

		System.out.print("\nEnter Password : ");
		String password = scan.next();
		if (password.equals("2")) {

			return "2";
		} else {

			if (!ChatUtil.checkPassword(password)) {

				System.out.println("\nWrong Input!!!");
				password = getPasswordforLogin();
			}
		}
		return password;
	}

	private void register() {

		System.out.println("\n-------Registration Page------------");

		String name = getName();
		if (name.equals("2")) {
			return;
		}
		String mobileNo = getMobileNo();
		if (mobileNo.equals("2")) {
			return;
		}
		String emailId = getEmailId();
		if (emailId.equals("2")) {
			return;
		}
		String dateOfBirth = getDateOfBirth();
		if (dateOfBirth.equals("2")) {
			return;
		}
		int age = ChatUtil.checkAge(dateOfBirth);
//		if (age == 2) {
//
//			return;
//		}
		String password = getPassword();
		if (password.equals("2")) {
			return;
		}
		String about = getAbout();
		User user = new User(name, mobileNo, emailId, age, dateOfBirth, password, about);
		loginOrRegisterPageViewToControllerCall.setUserDetails(user);
	}

	private String getDateOfBirth() {

		System.out.print("\nEnter Date Of Birth (DD/MM/YYYY): ");
		String dateOfBirth = scan.next();
		if (dateOfBirth.equals("2")) {
			mainPage();
		} else {
			if (!ChatUtil.checkDateOfBirth(dateOfBirth)) {

				System.out.println("Invalid Date Of Birth!!!");
				dateOfBirth = getDateOfBirth();
			}

		}
		return dateOfBirth;
	}

	private String getAbout() {

		scan.nextLine();
		System.out.print("\nEnter about : ");
		String about = scan.nextLine();
		return about;
	}

	private String getName() {

		System.out.println("\nIf You Want Press 2");
		System.out.print("\nEnter Name : ");
		String name = scan.next();
		if (name.equals("2")) {

			return "2";
		} else {

			if (!ChatUtil.checkName(name)) {

				System.out.println("Invalid Name!!!");
				name = getName();
			}
		}
		return name;
	}

	private String getMobileNo() {

		System.out.print("\nEnter Mobile Number : ");
		String mobileNo = scan.next();
		if (mobileNo.equals("2")) {

			return "2";
		} else {

			if (!ChatUtil.checkMobileNumber(mobileNo)) {

				System.out.println("Invalid Mobile Number!!!");
				mobileNo = getMobileNo();
			}
		}
		return mobileNo;
	}

	private String getEmailId() {

		System.out.print("\nEnter emailId : ");
		String emailId = scan.next();
		if (emailId.equals("2")) {

			return "2";
		} else {

			if (!ChatUtil.checkEmailId(emailId)) {

				System.out.println("Invalid Email ID!!!");
				emailId = getEmailId();
			}
		}
		return emailId;
	}
	
	private String getPassword() {

		System.out.print("\nEnter Password (Minimum Length 8): ");
		String password = scan.next();
		if (password.equals("2")) {
			return "2";
		}
		if(ChatUtil.checkPasswordLength(password)) {
			
			System.out.print("\nEnter Confirm Password : ");
			String conPassword = scan.next();
			if (!ChatUtil.checkPassword(password, conPassword)) {
				
				System.out.println("Invalid Confirm Password!!!");
				password = getPassword();
			}
//			return password;
			
		}
		else {
			
			System.out.println("Invalid Password Length!!!");
			password = getPassword();
		}
		return password;
	}

	@Override
	public void addedSuccessfully() {

		System.out.println("\nDetails Added Successfully!!!");
	}

	@Override
	public void userMobileNoExist() {

		System.out.println("\nUser Mobile Number Or Email Id Already Exist!!!");
	}

	@Override
	public void userEmailExist() {

		System.out.println("\nUser Email Id Already Exist!!!");
	}

	@Override
	public void loginFailed() {

		System.out.println("\nLogin Failed!!!");
	}

	@Override
	public void loginSuccess(User user) {

		System.out.println("\nLogin Successfully!!!");
		new PersonalChatView().mainOptionsPage(user);
	}
}
