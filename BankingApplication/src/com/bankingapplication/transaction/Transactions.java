package com.bankingapplication.transaction;

public class Transactions {

	private String senderId;
	private String receiverId;
	private String senderName;
	private String receiverName;
	private String accountNumber;
	private int money;
	private String message;
	private boolean isSended;

	public Transactions(String senderId, String receiverId, String senderName, String receiverName,
			String accountNumber, int money,String message) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.money = money;
		this.accountNumber = accountNumber;
		this.message = message;
		this.isSended = false;
	}

	public final int getMoney() {
		return money;
	}

	public final void setMoney(int money) {
		this.money = money;
	}
	
	public final boolean isSended() {
		return isSended;
	}

	public final void setSended(boolean isSended) {
		this.isSended = isSended;
	}
	
	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
