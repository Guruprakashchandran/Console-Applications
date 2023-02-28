package com.bankingapplication.adminpage;

import java.util.List;

import com.bankingapplication.bankdetails.BankDetails;

public interface AdminPageControllerToViewCall {

	void removeSuccessfully();

	void removeFailed();

	void showDetails(List<BankDetails> userDetails);

}
