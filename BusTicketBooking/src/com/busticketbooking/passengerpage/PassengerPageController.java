package com.busticketbooking.passengerpage;

import java.util.List;

import com.bustickerbooking.bookingdetails.Booking;

public class PassengerPageController implements PassengerPageViewToControllerCall,PassengerPageModelToControllerCall{

	private PassengerPageControllerToViewCall passengerPageControllerToViewCall;
	private PassengerPageControllerToModelCall passengerPageControllerToModelCall;
	public PassengerPageController(PassengerPageView passengerPageView) {

		passengerPageControllerToViewCall = passengerPageView;
		passengerPageControllerToModelCall = new PassengerPageModel(this);
	}
	@Override
	public void getPassengerDetails(String emailId) {

		passengerPageControllerToModelCall.getPassengerDetails(emailId);
	}
	@Override
	public void showPassengerDetails(List<Booking> bookingDetails,String emailId) {

		passengerPageControllerToViewCall.showPassengerDetails(bookingDetails,emailId);
	}

}
