package com.busticketbooking.passengerpage;

import java.util.List;

import com.bustickerbooking.bookingdetails.Booking;
import com.bustickerbooking.bookingdetails.BookingDetailsRepository;

public class PassengerPageModel implements PassengerPageControllerToModelCall{

	private PassengerPageModelToControllerCall passengerPageModelToControllerCall;
	public PassengerPageModel(PassengerPageController passengerPageController) {
		
		passengerPageModelToControllerCall = passengerPageController;
	}
	@Override
	public void getPassengerDetails(String emailId) {
		
		List<Booking> bookingDetails = BookingDetailsRepository.getInstance().getDetails(emailId);
		passengerPageModelToControllerCall.showPassengerDetails(bookingDetails,emailId);
	}
}
