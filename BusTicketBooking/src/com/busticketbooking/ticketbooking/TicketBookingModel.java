package com.busticketbooking.ticketbooking;

import java.util.List;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.busdetails.BusDetailsRepository;

public class TicketBookingModel implements TicketBookingControllerToModelCall {

	private static int bookingId = 0;
	private static int passengerId = 0;
	private TicketBookingModelToControllerCall ticketBookingModelToControllerCall;

	public TicketBookingModel(TicketBookingController ticketBookingController) {

		ticketBookingModelToControllerCall = ticketBookingController;
	}

	@Override
	public void getFlightDetails(String source, String destination, String date, String emailId) {

		List<Bus> busDetails = BusDetailsRepository.getInstance().getBusDetails(source, destination, date, emailId);
		ticketBookingModelToControllerCall.showBusDetails(busDetails, emailId, source, destination, date);
	}

	@Override
	public void addBooking(String emailId, String busId, int semiCount, String[] name, int[] age, int[] seatNo,
			int sleeperCount, String[] namesl, int[] agesl, int[] seatslNo, String source, String destination,
			String arrivalTime, String dispatchingTime,String date) {

		int amount;
		amount = BusDetailsRepository.getInstance().addBooking(emailId, busId, semiCount, name, age, seatNo, sleeperCount,
				namesl, agesl, seatslNo, source, destination, arrivalTime, dispatchingTime, date);
		if (amount>0) {

			bookingId++;
			passengerId++;
			ticketBookingModelToControllerCall.bookingSuccess(emailId,bookingId,passengerId,amount);
		} else {

			ticketBookingModelToControllerCall.bookingFailed(emailId);
		}
	}
}