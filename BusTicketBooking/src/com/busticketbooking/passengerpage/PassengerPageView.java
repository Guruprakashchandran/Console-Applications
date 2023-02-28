package com.busticketbooking.passengerpage;

import java.util.List;
import java.util.Scanner;

import com.bustickerbooking.bookingdetails.Booking;
import com.busticketbooking.logingorregister.LoginOrRegisterView;
import com.busticketbooking.ticketbooking.TicketBookingView;
import com.busticketbooking.ticketcancelation.TicketCancelationView;

public class PassengerPageView implements PassengerPageControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private PassengerPageViewToControllerCall passengerPageViewToControllerCall;

	public PassengerPageView() {

		passengerPageViewToControllerCall = new PassengerPageController(this);
	}

	public void passengerPage(String emailId) {

		try {

			System.out.println("\n*********Passenger Page**********");
			System.out.println("\n1) Ticket Booking\n2) Ticket Cancelation\n3) View Booking Detail\n4) Back\n5) Exit");
			System.out.print("\nEnter the Input : ");
			int input = scan.nextInt();
			switch (input) {

			case 1:
				new TicketBookingView().bookingPage(emailId);
				break;
			case 2:
				new TicketCancelationView().bookingCancelation(emailId);
				break;
			case 3:
				passengerPageViewToControllerCall.getPassengerDetails(emailId);
				break;
			case 4:
				new LoginOrRegisterView().mainPage();
				break;
			case 5:
				System.out.println("Exitted!!!");
				break;
			default:
				System.out.println("Wrong Input!!!");
				passengerPage(emailId);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Wrong Input!!!");
			passengerPage(emailId);
		}
	}

	@Override
	public void showPassengerDetails(List<Booking> bookingDetails, String emailId) {

		if (bookingDetails.size() != 0) {

			System.out.printf("\n%s%11s%15s%13s%9s%14s%15s%19s%20s%16s%9s%9s\n", "Bus Id", "Bus Name", "Passenger ID", "Booking ID",
					"Source", "Destination", "Arrival Time", "Destination Time", "SemiSleeper Seats", "Sleeper Seats",
					"Amount", "Date");
			for (int i = 0; i < bookingDetails.size(); ++i) {

				System.out.printf("\n%6s%11s%15d%13d%9s%14s%15s%19s%20d%16d%9d%11s", bookingDetails.get(i).getBusId(),
						bookingDetails.get(i).getBusName(), bookingDetails.get(i).getPassengerId(),
						bookingDetails.get(i).getBookingId(), bookingDetails.get(i).getSource(),
						bookingDetails.get(i).getDestination(), bookingDetails.get(i).getArrivalTime(),
						bookingDetails.get(i).getDispatchingTime(), bookingDetails.get(i).getSemiSleeper().length,
						bookingDetails.get(i).getSleeper().length, bookingDetails.get(i).getAmount(),
						bookingDetails.get(i).getDate());
			}
		} else {

			System.out.println("No Booking Available");
		}
		passengerPage(emailId);
	}
}
