package com.bankingapplication.adminpage;

import java.util.List;
import java.util.Scanner;

import com.bankingapplication.bankdetails.BankDetails;
import com.bankingapplication.loginorregisterpage.LoginOrRegisterPageView;
import com.bankingapplication.loginorregisterpage.LoginPageViewToAdminPageView;

public class AdminPageView implements LoginPageViewToAdminPageView,AdminPageControllerToViewCall{

	private Scanner scan = new Scanner(System.in);
	private AdminPageViewToControllerCall adminPageViewToControllerCall;
	public AdminPageView() {
		
		adminPageViewToControllerCall = new AdminPageController(this);
	}
	@Override
	public void adminMainPage() {

		System.out.println("\n**************ADMIN PAGE**************");
		System.out.println("\n1) Show User Details\n2) Remove User\n3) Back\n4) Exit");
		System.out.print("\nEnter Input : ");
		int input = scan.nextInt();
		switch(input) {
		
			case 1:
				adminPageViewToControllerCall.getUserDetails();
				break;
			case 2:
				removeUser();
				break;
			case 3:
				new LoginOrRegisterPageView().mainPage();
				break;
			case 4:
				System.out.println("Exitted!!!");
				break;
			default:
				System.out.println("\nWrong Input");
		}
	}
	public void removeUser() {
	
		System.out.print("\nEnter User Id : ");
		String userId= scan.next();
		
		if(userId.length() == 4) {
			for(int i = 0;i<4;++i) {
				if(userId.charAt(i) < 48 || userId.charAt(i) > 57) {
					
					System.out.println("\nWrong User Id!!!");
				}
			}
			removeUser();
		}
		else {
		adminPageViewToControllerCall.removeUser(userId);
		}
	}
	@Override
	public void removeSuccessfully() {
	
		System.out.println("User Id Remove Successfully!!!");
		adminMainPage();
	}
	@Override
	public void removeFailed() {
		
		System.out.println("User Id Remove Failed!!!");
		adminMainPage();
	}
	@Override
	public void showDetails(List<BankDetails> userDetails) {
		
		System.out.printf("\n%s%10s%17s%16s%16s\n","UserId","Name","Account Number","Mobile Number","Date Of Birth");
		for(int i = 0;i<userDetails.size();++i) {
			
			System.out.printf("\n%5s%10s%17s%16s%16s",userDetails.get(i).getUserId(),userDetails.get(i).getName(),userDetails.get(i).getAccountNumber(),userDetails.get(i).getMobileNo(),userDetails.get(i).getDateOfBirth());
		}
		adminMainPage();
	}
}