package com.busticketbooking.ticketbooking;

public interface TicketBookingControllerToModelCall {

	void getFlightDetails(String emailId, String destination, String date, String emailId2);

	void addBooking(String emailId, String busId, int semiCount, String[] name, int[] age, int[] seatNo, int sleeperCount,
			String[] namesl, int[] agesl, int[] seatslNo, String source, String destination, String arrivalTime, String dispatchingTime, String date);

}
