package com.busticketbooking.adminpage;

import java.util.List;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.passengerdetails.Passenger;

public class AdminPageController implements AdminPageViewToControllerCall,AdminPageModelToControllerCall{

	private AdminPageControllerToViewCall adminPageControllerToViewCall;
	private AdminPageControllerToModelCall adminPageControllerToModelCall;
	public AdminPageController(AdminPageView adminPageView) {
		
		adminPageControllerToViewCall = adminPageView;
		adminPageControllerToModelCall = new AdminPageModel(this);
	}
	@Override
	public void showBus() {
		
		adminPageControllerToModelCall.showBus();
	}
	@Override
	public void showPassengerDetails() {

		adminPageControllerToModelCall.showPassengerDetails();
	}
	@Override
	public void deleteBus(String busId) {
		
		adminPageControllerToModelCall.deleteBus(busId);
	}
	@Override
	public void addBus(String busId, String busName, String[] sourcePlaces, String[] destinationPlaces,
			String[] arrivalTime, String[] dispatchingTime, int semiSleeperCount, int sleeperCount,
			String arrivalDate, String dispatchingDate) {
		
		adminPageControllerToModelCall.addBus(busId,busName,sourcePlaces,destinationPlaces,arrivalTime,dispatchingTime,semiSleeperCount,sleeperCount,arrivalDate,dispatchingDate);
	}
	@Override
	public void deleteSuccess() {
		
		adminPageControllerToViewCall.deleteSuccess();
	}
	@Override
	public void deleteFailed() {
		
		adminPageControllerToViewCall.deleteFailed();
	}
	@Override
	public void addFailed() {
		
		adminPageControllerToViewCall.addFailed();
	}
	@Override
	public void addSuccess() {
		
		adminPageControllerToViewCall.addSuccess();
	}
	@Override
	public void passengerDetails(List<Passenger> passengerDetails) {
		
		adminPageControllerToViewCall.passengerDetails(passengerDetails);
	}
	@Override
	public void busDetails(List<Bus> busDetails) {
		
		adminPageControllerToViewCall.busDetails(busDetails);
	}
}
