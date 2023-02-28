package com.busticketbooking.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsClass {

	public boolean checkMobileNo(String mobileNumber) {
		
		Pattern p = Pattern.compile("^\\d{10}$");
		Matcher m = p.matcher(mobileNumber);
		return (m.matches());
	}
	public boolean checkEmailId(String emailId) {
		
		Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
		Matcher m = p.matcher(emailId);
		return (m.matches());
	}
	public boolean checkPassword(String password,String confirmPassword) {
		
		if(password.length() > 7 && password.equals(confirmPassword)) {
			
			return true;
		}
		return false;
	}
	public boolean checkDate(String date) {
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		String currDate = dtf.format(now);
//		System.out.println(currDate);
		String[] date1 = date.split("/");
		String[] currDate1 = currDate.split("/");
		boolean isTrue = true;
		for(int i = 2;i>=0;--i) {
			
			if(Integer.parseInt(date1[i])< Integer.parseInt(currDate1[i])) {
				
					isTrue = false;
					break;
			}
			else if(Integer.parseInt(date1[i]) > Integer.parseInt(currDate1[i])){
				
				break;
			}
		}	
		return isTrue;
	}
	public boolean checkBusId(String busId) {
		
		if(busId.length() != 4) {
			
			return false;
		}
		return true;
	}
}
