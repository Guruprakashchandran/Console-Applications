package com.busticketbooking.ticketcancelation;

public interface TicketCancelationControllerToViewCall {

	void cancelationFailed(String emailId);

	void cancelationSuccess(String emailId);

}
