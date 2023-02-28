package com.busticketbooking.userdetails;

public class User {

	private String emailId;
	private String mobileNo;
	private String name;
	private String password;

	public User(String emailId, String mobileNo, String name, String password) {
		super();
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
	}


	public final String getEmailId() {
		return emailId;
	}

	public final void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public final String getMobileNo() {
		return mobileNo;
	}

	public final void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}
}
