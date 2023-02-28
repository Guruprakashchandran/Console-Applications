package com.bustickerbooking.bookingdetails;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.busticketbooking.utils.UtilsClass;

public class BookingDetailsRepository {

	private static BookingDetailsRepository bookingDetailsRepository;
	private Map<Integer,Booking> bookingDetails = new LinkedHashMap<>();
	private BookingDetailsRepository() {}
	public static BookingDetailsRepository getInstance() {
		
		if(bookingDetailsRepository == null) {
			
			bookingDetailsRepository = new BookingDetailsRepository();
		}
		return bookingDetailsRepository;
	}
	public List<Booking> getDetails(String emailId){
		
		List<Booking> details = new LinkedList<>();
		UtilsClass util = new UtilsClass();
		for(Map.Entry<Integer, Booking> entry : bookingDetails.entrySet()) {
			
			if(entry.getValue().getEmailId().equals(emailId)) {
				
				String date = entry.getValue().getDate();
				
				if(util.checkDate(date)) {
					
					details.add(entry.getValue());
				}
			} 
		}
		return details;
	}
	public void addBookingDetails(int bookingId, String busName, String busId, int passengerId, String emailId, String source,
			String destination, String arrivalTime, String dispatchingTime, int[] seatNo, int[] seatslNo, int amount,
			String date) {
		
		Booking book = new Booking(bookingId,busName,busId,passengerId,emailId,source,destination,arrivalTime,dispatchingTime,seatNo,seatslNo,amount,date);
		bookingDetails.put(passengerId, book);
	}
	public void deleteBookingDetails(String emailId,int passengerId) {
		
		bookingDetails.remove(passengerId);
	}
}
