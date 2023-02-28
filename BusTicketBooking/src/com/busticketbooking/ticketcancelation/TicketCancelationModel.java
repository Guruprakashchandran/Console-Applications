package com.busticketbooking.ticketcancelation;

import com.busticketbooking.busdetails.BusDetailsRepository;

public class TicketCancelationModel implements TicketCancelationControllerToModelCall{

	private TicketCancelationModelToControllerCall ticketCancelationModelToControllerCall;
	public TicketCancelationModel(TicketCancelationController ticketCancelationController) {

		ticketCancelationModelToControllerCall = ticketCancelationController;
	}
	@Override
	public void checkTicketforCancelation(String emailId, int passengerId) {
		
		if(BusDetailsRepository.getInstance().checkTicketforCancelation(emailId,passengerId)) {
			
			ticketCancelationModelToControllerCall.cancelationSuccess(emailId);
		}
		else {
			
			ticketCancelationModelToControllerCall.cancelationFailed(emailId);
		}
	}

}
