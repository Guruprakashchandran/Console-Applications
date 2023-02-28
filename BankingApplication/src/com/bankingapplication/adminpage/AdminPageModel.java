package com.bankingapplication.adminpage;

import java.util.List;

import com.bankingapplication.bankdetails.BankDetails;
import com.bookingapplication.bankdetailsrepository.BankDetailsRepository;

public class AdminPageModel implements AdminPageControllerToModelCall{

	private AdminPageModelToControllerCall adminPageModelToControllerCall;
	
	public AdminPageModel(AdminPageController adminPageController) {
	
		adminPageModelToControllerCall = adminPageController;
	}

	@Override
	public void removeUser(String userId) {

		if(BankDetailsRepository.getInstance().removeUser(userId)) {
			
			adminPageModelToControllerCall.removeSuccessfully();
		}
		else {
			
			adminPageModelToControllerCall.removeFailed();
		}
	}

	@Override
	public void getUserDetails() {
		
		List<BankDetails> userDetails = BankDetailsRepository.getInstance().getDetails(); 
		adminPageModelToControllerCall.showDetails(userDetails);
	}
}
