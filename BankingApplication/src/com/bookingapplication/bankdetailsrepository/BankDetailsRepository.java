package com.bookingapplication.bankdetailsrepository;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bankingapplication.bankdetails.BankDetails;
import com.bankingapplication.transaction.Transactions;

public class BankDetailsRepository {

	private static BankDetailsRepository bankDetailsRepository = null;

	private Map<String, BankDetails> bankDetails = new LinkedHashMap<>();

	private BankDetailsRepository() {

//		BankDetails bank;
//		bank = new BankDetails(null,null,"1234 5678 9012 3456",null,null,null,0);
//		bankDetails.put("1234 5678 9012 3456",bank);
//		bank = new BankDetails(null,null,"2345 6789 0123 4567",null,null,null,0);
//		bankDetails.put("2345 6789 0123 4567",bank);
//		bank = new BankDetails(null,null,"3456 7890 1234 5678",null,null,null,0);
//		bankDetails.put("3456 7890 1234 5678",bank);
//		bank = new BankDetails(null,null,"4567 8901 2345 6789",null,null,null,0);
//		bankDetails.put("4567 8901 2345 6789",bank);
//		bank = new BankDetails(null,null,"5678 9012 3456 7890",null,null,null,0);
//		bankDetails.put("5678 9012 3456 7890",bank);
	}

	public static BankDetailsRepository getInstance() {

		if (bankDetailsRepository == null) {

			bankDetailsRepository = new BankDetailsRepository();
		}
		return bankDetailsRepository;
	}

	public int checkLogin(String userId, String password) {

		if (bankDetails.containsKey(userId)) {

			if (password.equals(bankDetails.get(userId).getPassword())) {

				return 0;
			}
			return 1;
		}
		return 2;
	}

	public void addDetails(String userId, String name, String accountNumber, String password, int setaPin,
			String mobileNo, String dateOfBirth) {

		BankDetails bank = new BankDetails(userId, name, accountNumber, password, setaPin, mobileNo, dateOfBirth);
		bankDetails.put(userId, bank);
	}

	public boolean userIdIsExist(String userId) {

		if (bankDetails.containsKey(userId)) {

			return true;
		}
		return false;
	}

	public boolean checkPin(int pin, String userId) {

		if (pin == bankDetails.get(userId).getPin()) {

			return true;
		}
		return false;
	}

	public void depositMoney(int money, String userId) {

		bankDetails.get(userId).setTotalAmount(bankDetails.get(userId).getTotalAmount() + money);
	}

	public int withdrawMoney(int money, String userId) {

		if (bankDetails.get(userId).getTotalAmount() - 500 >= money) {

			bankDetails.get(userId).setTotalAmount(bankDetails.get(userId).getTotalAmount() - money);
			return 0;
		}

		return bankDetails.get(userId).getTotalAmount();
	}

	public void changePass(String pass, String userId) {

		bankDetails.get(userId).setPassword(pass);
	}

	public void changeDateOfBirth(String dateOfBirth, String userId) {

		bankDetails.get(userId).setDateOfBirth(dateOfBirth);

	}

	public void changePin(int pin, String userId) {

		bankDetails.get(userId).setPin(pin);
	}

	public void changeMobNumber(String mobileNo, String userId) {

		bankDetails.get(userId).setMobileNo(mobileNo);
	}

	public int checkBalance(int pin, String userId) {

		if (bankDetails.get(userId).getPin() == pin) {

			return bankDetails.get(userId).getTotalAmount();
		}
		return 0;
	}

	public boolean removeUser(String userId) {

		if (bankDetails.containsKey(userId)) {
			bankDetails.remove(userId);
			return true;
		}
		return false;
	}

	public List<BankDetails> getDetails() {

		List<BankDetails> userDetails = new LinkedList<>();
		for (Entry<String, BankDetails> entry : bankDetails.entrySet()) {

			userDetails.add(entry.getValue());
		}
		return userDetails;
	}

	public List<BankDetails> moneyTransfer(String userId, int pin,String accountNumber, int money) {

		List<BankDetails> details = new LinkedList<>();
		for(Map.Entry<String, BankDetails> entry : bankDetails.entrySet()) {
			
			if(entry.getValue().getAccountNumber().equals(accountNumber)) {
				
				details.add(entry.getValue());
			}
		}
		if(details.size() == 0) {
			
			return null;
		}
		if(bankDetails.get(userId).getTotalAmount()- 500 < money) {
			return null;
		}
		details.add(bankDetails.get(userId));
//		if(details.size()<2) {
//			
//			return null;
//		}
		details.get(0).setTotalAmount(details.get(0).getTotalAmount() + money);
		details.get(1).setTotalAmount(details.get(1).getTotalAmount() - money);;
		return details;
	}
}
