package com.busticketbooking.ticketcancelation;

import java.util.Scanner;

import com.busticketbooking.passengerpage.PassengerPageView;

public class TicketCancelationView implements TicketCancelationControllerToViewCall{

	private Scanner scan = new Scanner(System.in);
	private TicketCancelationViewToControllerCall ticketCancelationViewToControllerCall;
	public TicketCancelationView() {
		
		ticketCancelationViewToControllerCall = new TicketCancelationController(this);
	}
	
	public void bookingCancelation(String emailId) {
		
		try {
		System.out.println("\n==============TICKET CANCELATION================");
		System.out.print("\nEnter Passenger Id : ");
		int passengerId = scan.nextInt();
		ticketCancelationViewToControllerCall.checkTicketforCancelation(emailId,passengerId);
		}
		catch(Exception e) {
			
			System.out.println("\nWrong Input Format!!!");
			new PassengerPageView().passengerPage(emailId);
		}
	}

	@Override
	public void cancelationFailed(String emailId) {
		
		System.out.println("\nTicket Cancelled Failed!!!");
		new PassengerPageView().passengerPage(emailId);
	}

	@Override
	public void cancelationSuccess(String emailId) {
		
		System.out.println("\nTicket Cancelled Successfully!!");
		new PassengerPageView().passengerPage(emailId);
	}
}
