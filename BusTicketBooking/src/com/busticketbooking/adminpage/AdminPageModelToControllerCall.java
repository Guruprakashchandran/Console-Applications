package com.busticketbooking.adminpage;

import java.util.List;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.passengerdetails.Passenger;

public interface AdminPageModelToControllerCall {

	void deleteSuccess();

	void deleteFailed();

	void addFailed();

	void addSuccess();

	void passengerDetails(List<Passenger> passengerDetails);

	void busDetails(List<Bus> busDetails);

}
