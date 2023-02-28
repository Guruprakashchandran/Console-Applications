package com.bankingapplication.adminpage;

import java.util.List;

import com.bankingapplication.bankdetails.BankDetails;

public class AdminPageController implements AdminPageViewToControllerCall,AdminPageModelToControllerCall{

	private AdminPageControllerToModelCall adminPageControllerToModelCall;
	private AdminPageControllerToViewCall adminPageControllerToViewCall;
	public AdminPageController(AdminPageView adminPageView) {
		
		adminPageControllerToModelCall = new AdminPageModel(this);
		adminPageControllerToViewCall = adminPageView;
	}

	@Override
	public void removeUser(String userId) {
		
		adminPageControllerToModelCall.removeUser(userId);
	}

	@Override
	public void removeFailed() {

		adminPageControllerToViewCall.removeFailed();
	}

	@Override
	public void removeSuccessfully() {

		adminPageControllerToViewCall.removeSuccessfully();
	}

	@Override
	public void getUserDetails() {
		
		adminPageControllerToModelCall.getUserDetails();
	}

	@Override
	public void showDetails(List<BankDetails> userDetails) {
		
		adminPageControllerToViewCall.showDetails(userDetails);
	}
}
