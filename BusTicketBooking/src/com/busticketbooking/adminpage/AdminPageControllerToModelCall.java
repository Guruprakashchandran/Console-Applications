package com.busticketbooking.adminpage;

public interface AdminPageControllerToModelCall {

	void showPassengerDetails();

	void deleteBus(String busId);

	void addBus(String busId, String busName, String[] sourcePlaces, String[] destinationPlaces, String[] arrivalTime,
			String[] dispatchingTime, int semiSleeperCount, int sleeperCount, String arrivalDate,
			String dispatchingDate);

	void showBus();

}
