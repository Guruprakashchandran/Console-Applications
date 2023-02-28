package com.busticketbooking.adminpage;

import java.util.List;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.busdetails.BusDetailsRepository;
import com.busticketbooking.passengerdetails.Passenger;
import com.busticketbooking.passengerdetails.PassengerDetailsRepository;

public class AdminPageModel implements AdminPageControllerToModelCall {

	private AdminPageModelToControllerCall adminPageModelToControllerCall;

	public AdminPageModel(AdminPageController adminPageController) {

		adminPageModelToControllerCall = adminPageController;
	}

	@Override
	public void showPassengerDetails() {

		List<Passenger> passengerDetails = PassengerDetailsRepository.getInstance().getAllPassengerDetails();
		adminPageModelToControllerCall.passengerDetails(passengerDetails);
	}

	@Override
	public void showBus() {

		List<Bus> busDetails = BusDetailsRepository.getInstance().getAllBusDetails();
		adminPageModelToControllerCall.busDetails(busDetails);
	}

	@Override
	public void deleteBus(String busId) {

		if(BusDetailsRepository.getInstance().deleteBus(busId)) {
			
			adminPageModelToControllerCall.deleteSuccess();
		}
		else {
			
			adminPageModelToControllerCall.deleteFailed();
		}
	}

	@Override
	public void addBus(String busId, String busName, String[] sourcePlaces, String[] destinationPlaces,
			String[] arrivalTime, String[] dispatchingTime, int semiSleeperCount, int sleeperCount,
			String arrivalDate, String dispatchingDate) {
		
		if(BusDetailsRepository.getInstance().addBus(busId,busName,sourcePlaces,destinationPlaces,arrivalTime,dispatchingTime,semiSleeperCount,sleeperCount,arrivalDate,dispatchingDate)) {
			
			adminPageModelToControllerCall.addSuccess();
		}
		else {
			
			adminPageModelToControllerCall.addFailed();
		}
	}

}
