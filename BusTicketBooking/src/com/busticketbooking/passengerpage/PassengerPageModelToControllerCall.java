package com.busticketbooking.passengerpage;

import java.util.List;

import com.bustickerbooking.bookingdetails.Booking;

public interface PassengerPageModelToControllerCall {

	void showPassengerDetails(List<Booking> bookingDetails, String emailId);

}
