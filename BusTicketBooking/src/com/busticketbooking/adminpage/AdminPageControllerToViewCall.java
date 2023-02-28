package com.busticketbooking.adminpage;

import java.util.List;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.passengerdetails.Passenger;

public interface AdminPageControllerToViewCall {

	void deleteSuccess();

	void deleteFailed();

	void addFailed();

	void addSuccess();

	void busDetails(List<Bus> busDetails);

	void passengerDetails(List<Passenger> passengerDetails);

}
