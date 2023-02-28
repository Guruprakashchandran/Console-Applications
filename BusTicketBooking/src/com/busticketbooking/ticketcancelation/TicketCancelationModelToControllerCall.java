package com.busticketbooking.ticketcancelation;

public interface TicketCancelationModelToControllerCall {

	void cancelationFailed(String emailId);

	void cancelationSuccess(String emailId);

}
