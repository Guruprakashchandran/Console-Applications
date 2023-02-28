package com.busticketbooking.adminpage;

import java.util.List;
import java.util.Scanner;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.logingorregister.LoginOrRegisterView;
import com.busticketbooking.passengerdetails.Passenger;
import com.busticketbooking.utils.UtilsClass;

public class AdminPageView implements AdminPageControllerToViewCall {

	private AdminPageViewToControllerCall adminPageViewToControllerCall;
	private Scanner scan = new Scanner(System.in);

	public AdminPageView() {

		adminPageViewToControllerCall = new AdminPageController(this);
	}

	public void adminMainPage() {

		try {
			System.out.println("\n*******************ADMIN PAGE********************");
			System.out
					.println("\n1) Add Bus\n2) Remove Bus\n3) Show Buses\n4) Show Passenger Details\n5) Back\n6) Exit");
			System.out.print("\nEnter Input : ");
			int input = scan.nextInt();
			switch (input) {

			case 1:
				addBus();
				break;
			case 2:
				deleteBus();
				break;
			case 3:
				adminPageViewToControllerCall.showBus();
				break;
			case 4:
				adminPageViewToControllerCall.showPassengerDetails();
				break;
			case 5:
				new LoginOrRegisterView().mainPage();
				break;
			case 6:
				System.out.println("\nExitted!!!");
				break;
			default:
			}
		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
			adminMainPage();
		}
	}

	private void deleteBus() {

		System.out.println("If You Want Exit Press 2");
		System.out.print("Enter Bus Id - ");
		String busId = scan.next();
		if (busId.equals("2")) {

			adminMainPage();
		} else {

			UtilsClass util = new UtilsClass();
			if (util.checkBusId(busId)) {

				adminPageViewToControllerCall.deleteBus(busId);
			} else {

				System.out.println("\nInvalid Bus Id!!!");
				deleteBus();
			}
		}
	}

	private void addBus() {

		System.out.println("\nIf You Want Exit Press 2");
		System.out.print("\nEnter Bus Id - ");
		String busId = scan.next();
		if (busId.equals("2")) {

			adminMainPage();
		} else {

			System.out.print("Enter Bus Name - ");
			String busName = scan.next();
			System.out.print("Enter No of Source Places : ");
			int countOfSourcePlace = scan.nextInt();
			String[] sourcePlaces = new String[countOfSourcePlace];
			String[] arrivalTime = new String[countOfSourcePlace];
			for (int i = 0; i < countOfSourcePlace; ++i) {

				System.out.print("Enter Source Place : ");
				sourcePlaces[i] = scan.next();
				System.out.print("Enter Arrival Time : ");
				arrivalTime[i] = scan.next();
			}
			int countOfDestinationPlace = scan.nextInt();
			String[] destinationPlaces = new String[countOfDestinationPlace];
			String[] dispatchingTime = new String[countOfDestinationPlace];
			for (int i = 0; i < countOfDestinationPlace; ++i) {

				System.out.print("Enter Destination Place : ");
				destinationPlaces[i] = scan.next();
				System.out.print("Enter Dispatching Time : ");
				dispatchingTime[i] = scan.next();
			}
			System.out.print("Enter Semi-Sleeper Count : ");
			int semiSleeperCount = scan.nextInt();
			System.out.print("Enter Sleeper Count : ");
			int sleeperCount = scan.nextInt();
			System.out.print("Enter Arrival Date : ");
			String arrivalDate = scan.next();
			System.out.print("Enter Dispatching Date : ");
			String dispatchingDate = scan.next();
			adminPageViewToControllerCall.addBus(busId, busName, sourcePlaces, destinationPlaces, arrivalTime,
					dispatchingTime, semiSleeperCount, sleeperCount, arrivalDate, dispatchingDate);
		}
	}

	@Override
	public void deleteSuccess() {

		System.out.println("\nBus Details Deleted Successfully!!!");
		adminMainPage();
	}

	@Override
	public void deleteFailed() {

		System.out.println("\nBus Details Deletion Failed!!!");
		adminMainPage();
	}

	@Override
	public void addFailed() {

		System.out.println("\nBus Details Added Failed!!!");
		adminMainPage();
	}

	@Override
	public void addSuccess() {

		System.out.println("\nBus Details Added Successfully!!!");
		adminMainPage();
	}

	@Override
	public void busDetails(List<Bus> busDetails) {

		if (busDetails.size() > 0) {

			System.out.printf("\n%s%11s%9s%20s%13s%19s%14s%17s%10s%14s\n", "Bus Id", "Bus Name", "Source", "Destination",
					"Arrival Time", "Dispatching Time", "Semi Amount", "Sleeper Amount", "Arrival Date","Dispatching Date");
			for(int i = 0;i<busDetails.size();++i) {
				
				String[] sourcePlaces = busDetails.get(i).getSourcePlaces();
				String[] destinationPlaces = busDetails.get(i).getDestinationPlace();
				String[] arrivalTime = busDetails.get(i).getArrivalTime();
				String[] dispatchingTime = busDetails.get(i).getdispatchingTime();
				int semiSeatsAmount = (sourcePlaces.length - 0 + destinationPlaces.length-1) * 250;
				int SleeperSeatsAmount = (sourcePlaces.length - 0 + destinationPlaces.length-1) * 500;
				System.out.printf("\n%6s%11s%9s%20s%13s%19s%14s%17s%16s%16s", busDetails.get(i).getBusId(),
						busDetails.get(i).getBusName(), sourcePlaces[0], destinationPlaces[destinationPlaces.length-1],
						arrivalTime[0], dispatchingTime[dispatchingTime.length-1], semiSeatsAmount,
						SleeperSeatsAmount, busDetails.get(i).getArrivalDate(),busDetails.get(i).getDispatchingDate());
			}
			System.out.println();
		} else {

			System.out.println("\nNo Bus Details Available!!!");
		}
		adminMainPage();
	}

	@Override
	public void passengerDetails(List<Passenger> passengerDetails) {

		if (passengerDetails.size() > 0) {

			System.out.printf("\n%s%15s%13s%9s%15s%15s%15s%21s%16s%10s%10s", "Passenger ID", "Email", "Booking ID",
					"Bus ID", "Bus Name", "Source", "Destination", "Semi-Sleeper Count", "Sleeper Count", "Date",
					"count");
			for (int i = 0; i < passengerDetails.size(); ++i) {

				System.out.printf("\n%11d%15s%13d%9s%15s%15s%15s%21d%16d%10s%10d",
						passengerDetails.get(i).getPassengerId(), passengerDetails.get(i).getEmail(),
						passengerDetails.get(i).getBookingId(), passengerDetails.get(i).getBusId(),
						passengerDetails.get(i).getBusName(), passengerDetails.get(i).getSource(),
						passengerDetails.get(i).getDestination(), passengerDetails.get(i).getSemiSleeperSeat().length,
						passengerDetails.get(i).getSleeperSeat().length, passengerDetails.get(i).getDate(),
						passengerDetails.get(i).getAmount());
			}
		} else {

			System.out.println("\nNo Passenger Details Available!!!");
		}
		adminMainPage();
	}
}
