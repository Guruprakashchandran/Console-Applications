package com.busticketbooking.ticketcancelation;

public class TicketCancelationController implements TicketCancelationViewToControllerCall,TicketCancelationModelToControllerCall{

	private TicketCancelationControllerToViewCall ticketCancelationControllerToViewCall;
	private TicketCancelationControllerToModelCall ticketCancelationControllerToModelCall;
	public TicketCancelationController(TicketCancelationView ticketCancelationView) {
		
		ticketCancelationControllerToViewCall = ticketCancelationView;
		ticketCancelationControllerToModelCall = new TicketCancelationModel(this);
	}
	@Override
	public void checkTicketforCancelation(String emailId, int passengerId) {
		
		ticketCancelationControllerToModelCall.checkTicketforCancelation(emailId,passengerId);
	}
	@Override
	public void cancelationFailed(String emailId) {

		ticketCancelationControllerToViewCall.cancelationFailed(emailId);
	}
	@Override
	public void cancelationSuccess(String emailId) {

		ticketCancelationControllerToViewCall.cancelationSuccess(emailId);
	}

}
