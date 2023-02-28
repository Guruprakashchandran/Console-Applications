package com.bankingapplication.transaction;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TransactionRepository {

	private static TransactionRepository transactionRepository;
	private Map<String,Transactions> transactionDetails = new LinkedHashMap<>();
	private TransactionRepository() {
	}

	public static TransactionRepository getInstance() {

		if (transactionRepository == null) {

			transactionRepository = new TransactionRepository();
		}
		return transactionRepository;
	}
	public void addTransaction(String senderId,String receiverId,String senderName,String receiverName,String accountNumber,int money,String message) {
		
		Transactions transaction = new Transactions(senderId,receiverId,senderName,receiverName,accountNumber,money,message);
		transactionDetails.put(receiverId, transaction);
	}

	public List<Transactions> getUserTransactions(String userId) {
		
		List<Transactions> transactionsDetails = new LinkedList<>();
		for(Map.Entry<String, Transactions> entry: transactionDetails.entrySet()) {
			
			if(entry.getValue().getReceiverId().equals(userId) && entry.getValue().isSended() == false) {
	
				transactionsDetails.add(entry.getValue());
				entry.getValue().setSended(true);
			}
		}
		return transactionsDetails;
	}
	
public List<Transactions> getAllUserTransactions() {
		
		List<Transactions> transactionsDetails = new LinkedList<>();
		for(Map.Entry<String, Transactions> entry: transactionDetails.entrySet()) {
			
			transactionsDetails.add(entry.getValue());
		}
		return transactionsDetails;
	}
}
