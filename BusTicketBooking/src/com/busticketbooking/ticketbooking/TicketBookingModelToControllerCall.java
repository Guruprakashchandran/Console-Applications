package com.busticketbooking.ticketbooking;

import java.util.List;

import com.busticketbooking.busdetails.Bus;

public interface TicketBookingModelToControllerCall {

	void showBusDetails(List<Bus> busDetails, String emailId, String source, String destination, String date);

	void bookingFailed(String emailId);

	void bookingSuccess(String emailId, int bookingId, int passengerId, int amount);

}
