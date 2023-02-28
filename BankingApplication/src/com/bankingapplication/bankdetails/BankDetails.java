package com.bankingapplication.bankdetails;

public class BankDetails {

	private String userId;
	private String name;
	private String password;
	private String accountNumber;
	private int pin;
	private String dateOfBirth;
	private String mobileNo;
	private int totalAmount;

	public BankDetails(String userId, String name, String accountNumber, String password, int pin,
			String mobileNo, String dateOfBirth) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.totalAmount = (int) (Math.random() * (50000 - 500 + 1)) + 500;
	}

	public final String getUserId() {
		return userId;
	}

	public final void setUserId(String userId) {
		this.userId = userId;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
