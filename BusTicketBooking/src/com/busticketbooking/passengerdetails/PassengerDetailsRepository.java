package com.busticketbooking.passengerdetails;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PassengerDetailsRepository {

	private static PassengerDetailsRepository passengerDetailsRepository;
	private static Map<Integer,Passenger> passengerDetails = new LinkedHashMap<>();
	public PassengerDetailsRepository() {
	}
	public static PassengerDetailsRepository getInstance() {
		
		if(passengerDetailsRepository == null) {
			
			passengerDetailsRepository = new PassengerDetailsRepository();
		}
		return passengerDetailsRepository;
	}
	public void addBookingDetails(int passengerId, String busId, String busName, int bookingId, String emailId, String[] name, int[] age,
			String[] namesl, int[] agesl, String source, String destination, int[] seatNo, int[] seatslNo, int amount,
			String date) {

		Passenger passenger = new Passenger(passengerId,busId,busName,bookingId,emailId,name,age,namesl,agesl,source,destination,seatNo,seatslNo,amount,date);
		passengerDetails.put(passengerId, passenger);
	}
	public void deleteBookingDetails(String emailId,int passengerId) {
		
		passengerDetails.remove(passengerId);
	}
	public List<Passenger> getAllPassengerDetails() {
		
		List<Passenger> details = new LinkedList<>();
		for(Map.Entry<Integer, Passenger> entry : passengerDetails.entrySet()) {
			
			details.add(entry.getValue());
		}
		return details;
	}
}
