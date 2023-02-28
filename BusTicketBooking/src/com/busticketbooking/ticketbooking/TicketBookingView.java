package com.busticketbooking.ticketbooking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.busticketbooking.busdetails.Bus;
import com.busticketbooking.passengerpage.PassengerPageView;
import com.busticketbooking.utils.UtilsClass;

public class TicketBookingView implements TicketBookingControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private TicketBookingViewToControllerCall ticketBookingViewToControllerCall;

//	public static void main(String[] args) {
//
//		new TicketBookingView().bookingPage("guru@2020.com");
//	}

	public TicketBookingView() {

		ticketBookingViewToControllerCall = new TicketBookingController(this);
	}

	public void bookingPage(String emailId) {

		UtilsClass util = new UtilsClass();
		System.out.println("\n**********Booking Page***********");
		System.out.print("\nEnter Source : ");
		String source = scan.next();
		System.out.print("Enter Destination : ");
		String destination = scan.next();
		System.out.print("Enter Date (DD/MM/YYYY): ");
		String date = scan.next();
		if (util.checkDate(date)) {

			ticketBookingViewToControllerCall.getFlightDetails(source, destination, date, emailId);
		} else {

			System.out.println("\nPlease! Enter Correct Date !!!");
			bookingPage(emailId);
		}
	}

	@Override
	public void showBusDetails(List<Bus> busDetails, String emailId, String source, String destination, String date) {

		if (busDetails.size() > 0) {

			System.out.println("\n**************BUS DETAILS********************");
			System.out.printf("\n%s%11s%9s%20s%13s%19s%14s%17s%10s\n", "Bus Id", "Bus Name", "Source", "Destination",
					"Arrival Time", "Dispatching Time", "Semi Amount", "Sleeper Amount", "date");
			for (int i = 0; i < busDetails.size(); ++i) {
				int sourceIndex, destinationIndex;
				String[] sourcePlaces = busDetails.get(i).getSourcePlaces();
				for (sourceIndex = 0; sourceIndex < sourcePlaces.length; ++sourceIndex) {

					if (source.equalsIgnoreCase(sourcePlaces[sourceIndex])) {

						break;
					}
				}
				String[] destinationPlaces = busDetails.get(i).getDestinationPlace();
				for (destinationIndex = 0; destinationIndex < destinationPlaces.length; ++destinationIndex) {

					if (destination.equalsIgnoreCase(destinationPlaces[destinationIndex])) {

						break;
					}
				}
				String[] arrivalTime = busDetails.get(i).getArrivalTime();
				String[] dispatchingTime = busDetails.get(i).getdispatchingTime();
				int semiSeatsAmount = (sourcePlaces.length - sourceIndex + destinationIndex) * 250;
				int SleeperSeatsAmount = (sourcePlaces.length - sourceIndex + destinationIndex) * 500;
				System.out.printf("\n%6s%11s%9s%20s%13s%19s%14s%17s%12s", busDetails.get(i).getBusId(),
						busDetails.get(i).getBusName(), sourcePlaces[sourceIndex], destinationPlaces[destinationIndex],
						arrivalTime[sourceIndex], dispatchingTime[destinationIndex], semiSeatsAmount,
						SleeperSeatsAmount, date);
			}
			getDetails(emailId, busDetails, source, destination, date);
		} else {

			System.out.println("\nNo one Bus available that day!!!");
			new PassengerPageView().passengerPage(emailId);
		}
	}

	private void getDetails(String emailId, List<Bus> busDetails, String source, String destination, String date) {

		try {
			UtilsClass util = new UtilsClass();
			System.out.println("\n\nIf You Want Exit Press 2");
			System.out.print("\nEnter Bus Id : ");
			String busId = scan.next();
			if (busId.equals("2")) {

				bookingPage(emailId);
			} else {

				List<Integer> availableSemiSeats = new LinkedList<>();
				int busIndex;
				for (busIndex = 0; busIndex < busDetails.size(); ++busIndex) {

					if (busDetails.get(busIndex).getBusId().equals(busId)) {

						break;
					}
				}
				String seats[] = busDetails.get(busIndex).getSemiSleeper();
				for (int j = 0; j < busDetails.get(busIndex).getSemiSleeper().length; ++j) {

					if (seats[j].equals("Not Booking")) {

						availableSemiSeats.add(j + 1);
					}
				}
				if (availableSemiSeats.size() > 0) {

					System.out.print("\nAvailable Semi - Seats - ");
					for (int j = 0; j < availableSemiSeats.size(); ++j) {

						if (availableSemiSeats.get(j) % 3 == 0) {

							System.out.print(availableSemiSeats.get(j) + "W ");
						} else {

							System.out.print(availableSemiSeats.get(j) + " ");
						}
					}
					System.out.println();
				}
				List<Integer> availableSleeperSeats = new LinkedList<>();
				seats = busDetails.get(busIndex).getSleeper();
				for (int j = 0; j < busDetails.get(busIndex).getSleeper().length; ++j) {

					if (seats[j].equals("Not Booking")) {

						availableSleeperSeats.add(j + 1);
					}
				}
				if (availableSleeperSeats.size() > 0) {

					System.out.print("\nAvailable Sleeper Seats - ");
					for (int j = 0; j < availableSleeperSeats.size(); ++j) {

						System.out.print(availableSleeperSeats.get(j) + " ");
					}
					System.out.println();
				}

				if (util.checkBusId(busId)) {

					int busIdIndex;
					for (busIdIndex = 0; busIdIndex < busDetails.size(); ++busIdIndex) {

						if (busDetails.get(busIdIndex).getBusId().equals(busId)) {

							break;
						}
					}
					if (busIdIndex == busDetails.size()) {

						System.out.println("\nWrong Bus Id!!!");
					} else {

						seatsSemiBooking(busId, emailId, busDetails, busIdIndex, source, destination, date,
								availableSemiSeats, availableSleeperSeats);
					}
				}
			}
		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
			getDetails(emailId, busDetails, source, destination, date);
		}
	}

	private void seatsSleeperBooking(String busId, String emailId, List<Bus> busDetails, int busIdIndex, String source,
			String destination, String date, List<Integer> availableSleeperSeats, String[] name, int[] age,
			int[] seatNo, int semiCount) {

		try {

			System.out.print("\nEnter Sleeper Count : ");
			int sleeperCount = scan.nextInt();
			String[] namesl;
			int[] agesl;
			int[] seatslNo;
			if (sleeperCount > 0) {

				namesl = new String[sleeperCount];
				agesl = new int[sleeperCount];
				seatslNo = new int[sleeperCount];
				for (int i = 0; i < sleeperCount;) {

					System.out.println("\nPerson Detail " + (i + 1));
					System.out.print("\nEnter name : ");
					namesl[i] = scan.next();
					System.out.print("Enter age : ");
					agesl[i] = scan.nextInt();
					System.out.print("Enter Seat No : ");
					seatslNo[i] = scan.nextInt();

					boolean isSeatExist = false;
					for (int j = 0; j < i; ++j) {

						if (seatslNo[j] == seatslNo[i]) {

							System.out.println("\nWrong Input!!!");
							isSeatExist = true;
						}
					}
					if (busDetails.get(busIdIndex).getSleeper().length < seatslNo[i] || seatslNo[i] < 1) {

						System.out.println("\nWrong Seat Number!!!");
					}else if(agesl[i] < 1) {
						
						System.out.println("\nWrong Age!!!");
					} 
					else if (isSeatExist == false) {

						i++;
					}
				}

			} else {

				namesl = new String[0];
				agesl = new int[0];
				seatslNo = new int[0];
			}
			if (semiCount > 0 || sleeperCount > 0) {

				int index = 0;
				for (int i = 0; i < busDetails.size(); ++i) {

					if (busDetails.get(i).getBusId().equals(busId)) {

						break;
					}
				}
				int sourceIndex, destinationIndex;
				String[] sourcePlaces = busDetails.get(index).getSourcePlaces();
				for (sourceIndex = 0; sourceIndex < sourcePlaces.length; ++sourceIndex) {

					if (source.equals(sourcePlaces[sourceIndex])) {

						break;
					}
				}
				String[] destinationPlaces = busDetails.get(index).getDestinationPlace();
				for (destinationIndex = 0; destinationIndex < destinationPlaces.length; ++destinationIndex) {

					if (destination.equals(destinationPlaces[destinationIndex])) {

						break;
					}
				}
				String[] arrivalTime = busDetails.get(index).getArrivalTime();
				String[] dispatchingTime = busDetails.get(index).getdispatchingTime();

				ticketBookingViewToControllerCall.addBooking(emailId, busId, semiCount, name, age, seatNo, sleeperCount,
						namesl, agesl, seatslNo, source, destination, arrivalTime[sourceIndex],
						dispatchingTime[destinationIndex], date);
			} else {

				System.out.println("\nWrong Input!!!");
				getDetails(emailId, busDetails, source, destination, date);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("\nWrong Input!!!");
			getDetails(emailId, busDetails, source, destination, date);
		}
	}

	private void seatsSemiBooking(String busId, String emailId, List<Bus> busDetails, int busIdIndex, String source,
			String destination, String date, List<Integer> availableSemiSeats, List<Integer> availableSleeperSeats) {

		try {

			System.out.print("\nEnter Semi-Sleeper Count : ");
			int semiCount = scan.nextInt();
			String[] name;
			int[] age;
			int[] seatNo;
			if (semiCount > 0) {

				name = new String[semiCount];
				age = new int[semiCount];
				seatNo = new int[semiCount];
				for (int i = 0; i < semiCount;) {

					System.out.println("\nPerson Detail " + (i + 1));
					System.out.print("\nEnter name : ");
					name[i] = scan.next();
					System.out.print("Enter age : ");
					age[i] = scan.nextInt();
					System.out.print("Enter Seat No : ");
					seatNo[i] = scan.nextInt();

					boolean isSeatExist = false;
					for (int j = 0; j < i; ++j) {

						if (seatNo[j] == seatNo[i]) {

							System.out.println("\nWrong Input!!!");
							isSeatExist = true;
						}
					}
					if (busDetails.get(busIdIndex).getSemiSleeper().length < seatNo[i] || seatNo[i] < 1) {

						System.out.println("\nWrong Seat Number!!!");
					}else if(age[i] < 1) {
						
						System.out.println("\nInValid Age!!!");
					} 
					else if (isSeatExist == false) {

						i++;
					}
				}
			} else {

				name = new String[0];
				age = new int[0];
				seatNo = new int[0];
			}
			seatsSleeperBooking(busId, emailId, busDetails, busIdIndex, source, destination, date,
					availableSleeperSeats, name, age, seatNo, semiCount);
		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
			getDetails(emailId, busDetails, source, destination, date);
		}
	}

	@Override
	public void bookingFailed(String emailId) {

		System.out.println("\nBooking Failed!!!");
		new PassengerPageView().passengerPage(emailId);
	}

	@Override
	public void bookingSuccess(String emailId, int bookingId, int passengerId, int amount) {

		System.out.println("\n=================BOOKING SUCCESSFULLY====================");
		System.out.println("\nBooking ID : " + bookingId);
		System.out.println("Passenger ID : " + passengerId);
		System.out.println("Amount : " + amount);
		new PassengerPageView().passengerPage(emailId);
	}
}