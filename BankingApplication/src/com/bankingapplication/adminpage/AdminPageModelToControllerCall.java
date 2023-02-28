package com.bankingapplication.adminpage;

import java.util.List;

import com.bankingapplication.bankdetails.BankDetails;

public interface AdminPageModelToControllerCall {

	void removeFailed();

	void removeSuccessfully();

	void showDetails(List<BankDetails> userDetails);

}
