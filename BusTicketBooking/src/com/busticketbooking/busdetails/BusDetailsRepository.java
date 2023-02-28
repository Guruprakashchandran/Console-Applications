package com.busticketbooking.busdetails;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bustickerbooking.bookingdetails.Booking;
import com.bustickerbooking.bookingdetails.BookingDetailsRepository;
import com.busticketbooking.passengerdetails.PassengerDetailsRepository;
import com.busticketbooking.utils.UtilsClass;

public class BusDetailsRepository {

	private static BusDetailsRepository busDetailsRepository;
	private Map<String, Bus> busDetails = new LinkedHashMap<>();
	private static int bookingId = 0;
	private static int passengerId = 0;
	private BusDetailsRepository() {

		String sourcePlace[] = { "tenkasi","rajapalayam","srivilliputtur","madurai" };
		String destinationPlace[] = { "trichy","chennai" };
		String arrivalTime[] = { "08:00PM","10.00PM","10.15PM","12:30AM" };
		String dispatchingTime[] = { "04:30AM","08:00AM" };
		Bus bus = new Bus("0001", "redbus", sourcePlace, destinationPlace, arrivalTime, dispatchingTime, 15, 5,
				"12/04/2023", "13/04/2023");
		busDetails.put("0001", bus);
	}

	public static BusDetailsRepository getInstance() {

		if (busDetailsRepository == null) {

			busDetailsRepository = new BusDetailsRepository();
		}
		return busDetailsRepository;
	}

	public List<Bus> getDetails(String emainId) {

		List<Bus> details = new LinkedList<>();
		for (Map.Entry<String, Bus> entry : busDetails.entrySet()) {

			details.add(entry.getValue());
		}
		return details;
	}
	public List<Bus> getBusDetails(String source,String destination,String date,String emailId) {
		
		List<Bus> details = new LinkedList<>();
		UtilsClass util = new UtilsClass();
		for (Map.Entry<String, Bus> entry : busDetails.entrySet()) {
			
			int count = 0;
			String sourcePlaces[] = entry.getValue().getSourcePlaces();
			for(int i=0;i<sourcePlaces.length;++i) {
				
				if(source.equalsIgnoreCase(sourcePlaces[i])) {
					
					count++;
				}
			}
			if(count == 1) {
				
				String destinationPlaces[] = entry.getValue().getDestinationPlace();
				for(int i = 0;i<destinationPlaces.length;++i) {
					
					if(destination.equalsIgnoreCase(destinationPlaces[i])) {
						
						count++;
					}
				}
			}
			if(count == 2 && util.checkDate(date)) {
				
				count++;
			}
			if(count == 3) {
				
				details.add(entry.getValue());
				System.out.println(details.get(0).getBusId());
			}
		}
		return details;
	}

	public int addBooking(String emailId, String busId,int semiCount, String[] name, int[] age, int[] seatNo, int sleeperCount,
			String[] namesl, int[] agesl, int[] seatslNo, String source, String destination, String arrivalTime, String dispatchingTime, String date) {
		
		
		if(seatNo != null) {
			String semiSleeper[] = busDetails.get(busId).getSemiSleeper();
			for(int i = 0;i<seatNo.length;++i) {
				
				if(semiSleeper[seatNo[i]-1].equals("Booking")) {
					
					return 0;
				}
				else if(semiSleeper[seatNo[i]-1].equals("Not Booking")) {
					
					semiSleeper[seatNo[i]-1] = "Booking";
				}
			}
		}
		if(seatslNo != null) {
			String[] sleeper = busDetails.get(busId).getSleeper();
			for(int i = 0;i<seatslNo.length;++i) {
				
				if(sleeper[seatslNo[i]-1].equals("Booking")) {
					
					return 0;
				}
				else if(sleeper[seatslNo[i]-1].equals("Not Booking")) {
					
					sleeper[seatslNo[i]-1] = "Booking";
				}
			}
		}
		String[] sourcePlaces = busDetails.get(busId).getSourcePlaces();
		int sourceIndex = 0,destinationIndex = 0;
		while(!sourcePlaces[sourceIndex].equalsIgnoreCase(source)) {
			
			sourceIndex++;
		}
		String[] destinationPlaces = busDetails.get(busId).getDestinationPlace();
		while(!destinationPlaces[destinationIndex].equalsIgnoreCase(destination)) {
			
			destinationIndex++;
		}
		int sleeperSeatsAmount = (sourcePlaces.length - sourceIndex + destinationIndex) * 500 * sleeperCount;
		int semiSleeperSeatsAmount = (sourcePlaces.length - sourceIndex + destinationIndex) * 250 * semiCount;
		int amount = sleeperSeatsAmount + semiSleeperSeatsAmount;
		PassengerDetailsRepository.getInstance().addBookingDetails(++passengerId,busId,busDetails.get(busId).getBusName(),++bookingId,emailId,name,age,namesl,agesl,source,destination,seatNo,seatslNo,amount,date);
		BookingDetailsRepository.getInstance().addBookingDetails(bookingId,busDetails.get(busId).getBusName(),busId,passengerId,emailId,source,destination,arrivalTime,dispatchingTime,seatNo,seatslNo,amount,date);
		return amount;
	}

	public boolean checkTicketforCancelation(String emailId, int passengerId) {
		
		if(this.passengerId>=passengerId) {
			
			List<Booking> detail = BookingDetailsRepository.getInstance().getDetails(emailId);
			for(int i = 0;i<detail.size();++i) {
				
				String busId = detail.get(i).getBusId();
				if(detail.get(i).getPassengerId() == passengerId) {
					
					int[] semiSeats = detail.get(i).getSemiSleeper();
					String[] seats = busDetails.get(busId).getSemiSleeper();
					for(int j = 0;j < semiSeats.length;++j) {
						
						 seats[semiSeats[i]-1]= "Not Booking";
					}
					
					int[] sleeperSeats = detail.get(i).getSleeper();
					seats = busDetails.get(busId).getSleeper();
					for(int j = 0;j < sleeperSeats.length;++j) {
						
						seats[sleeperSeats[i]-1]= "Not Booking";
					}
				}
			}
			PassengerDetailsRepository.getInstance().deleteBookingDetails(emailId, passengerId);
			BookingDetailsRepository.getInstance().deleteBookingDetails(emailId, passengerId);
			return true;
		}	
		return false;
	}

	public boolean addBus(String busId, String busName, String[] sourcePlaces, String[] destinationPlaces,
			String[] arrivalTime, String[] dispatchingTime, int semiSleeperCount, int sleeperCount,
			String arrivalDate, String dispatchingDate) {
		
		if(busDetails.containsKey(busId)) {
			
			return false;
		}
		Bus bus = new Bus(busId,busName,sourcePlaces,destinationPlaces,arrivalTime,dispatchingTime,semiSleeperCount,sleeperCount,arrivalDate,dispatchingDate);
		busDetails.put(busId, bus);
		return true;
	}
	public boolean deleteBus(String busId) {
		
		if(busDetails.containsKey(busId)) {
			
			busDetails.remove(busId);
			return true;
		}
		return false;
	}

	public List<Bus> getAllBusDetails() {
		
		List<Bus> details = new LinkedList<>();
		for(Map.Entry<String, Bus> entry : busDetails.entrySet()) {
			
			details.add(entry.getValue());
		}
		return details;
	}
}
