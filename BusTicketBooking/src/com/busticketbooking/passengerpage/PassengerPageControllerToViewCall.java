package com.busticketbooking.passengerpage;

import java.util.List;

import com.bustickerbooking.bookingdetails.Booking;

public interface PassengerPageControllerToViewCall {

	void showPassengerDetails(List<Booking> bookingDetails, String emailId);

}
