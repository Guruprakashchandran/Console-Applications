package com.busticketbooking.ticketbooking;

import java.util.List;

import com.busticketbooking.busdetails.Bus;

public class TicketBookingController implements TicketBookingViewToControllerCall,TicketBookingModelToControllerCall{

	private TicketBookingControllerToViewCall ticketBookingControllerToViewCall;
	private TicketBookingControllerToModelCall ticketBookingControllerToModelCall;
	public TicketBookingController(TicketBookingView ticketBookingView) {
		
		ticketBookingControllerToViewCall = ticketBookingView;
		ticketBookingControllerToModelCall = new TicketBookingModel(this);
	}
	@Override
	public void getFlightDetails(String source, String destination, String date, String emailId) {
		
		ticketBookingControllerToModelCall.getFlightDetails(source,destination,date,emailId);
	}
	@Override
	public void showBusDetails(List<Bus> busDetails, String emailId,String source,String destination,String date) {
		
		ticketBookingControllerToViewCall.showBusDetails(busDetails,emailId,source,destination,date);
	}
	@Override
	public void addBooking(String emailId, String busId,int semiCount, String[] name, int[] age, int[] seatNo, int sleeperCount,
			String[] namesl, int[] agesl, int[] seatslNo,String source,String destination,String arrivalTime, String dispatchingTime,String date) {
		
		ticketBookingControllerToModelCall.addBooking(emailId,busId,semiCount,name,age,seatNo,sleeperCount,namesl,agesl,seatslNo,source,destination, arrivalTime, dispatchingTime,date);
	}
	@Override
	public void bookingFailed(String emailId) {
		
		ticketBookingControllerToViewCall.bookingFailed(emailId);
	}
	@Override
	public void bookingSuccess(String emailId,int bookingId,int passengerId,int amount) {
		
		ticketBookingControllerToViewCall.bookingSuccess(emailId,bookingId,passengerId,amount);
	}
}
