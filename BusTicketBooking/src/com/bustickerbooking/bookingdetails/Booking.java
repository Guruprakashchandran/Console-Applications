package com.bustickerbooking.bookingdetails;

public class Booking {

	private int bookingId;
	private String busName;
	private String busId;
	private int passengerId;
	private String emailId;
	private String source;
	private String destination;
	private String arrivalTime;
	private String dispatchingTime;
	private int semiSleeper[];
	private int sleeper[];
	private int amount;
	private String date;

	public Booking(int bookingId, String busName, String busId, int passengerId, String emailId, String source,
			String destination, String arrivalTime, String dispatchingTime, int[] semiSleeper, int[] sleeper,
			int amount, String date) {
		super();
		this.date = date;
		this.bookingId = bookingId;
		this.busName = busName;
		this.busId = busId;
		this.passengerId = passengerId;
		this.emailId = emailId;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.dispatchingTime = dispatchingTime;
		this.semiSleeper = new int[semiSleeper.length];
		for (int i = 0; i < semiSleeper.length; ++i) {

			this.semiSleeper[i] = semiSleeper[i];
		}
		this.sleeper = new int[sleeper.length];
		for (int i = 0; i < sleeper.length; ++i) {

			this.sleeper[i] = sleeper[i];
		}
		this.amount = amount;
	}

	public final String getDate() {
		return date;
	}

	public final void setDate(String date) {
		this.date = date;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDispatchingTime() {
		return dispatchingTime;
	}

	public void setDispatchingTime(String dispatchingTime) {
		this.dispatchingTime = dispatchingTime;
	}

	public final int getBookingId() {
		return bookingId;
	}

	public final void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public final String getBusName() {
		return busName;
	}

	public final void setBusName(String busName) {
		this.busName = busName;
	}

	public final String getBusId() {
		return busId;
	}

	public final void setBusId(String busId) {
		this.busId = busId;
	}

	public final int getPassengerId() {
		return passengerId;
	}

	public final void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public final String getSource() {
		return source;
	}

	public final void setSource(String source) {
		this.source = source;
	}

	public final String getDestination() {
		return destination;
	}

	public final void setDestination(String destination) {
		this.destination = destination;
	}

	public final int[] getSemiSleeper() {
		return semiSleeper;
	}

	public final void setSemiSleeper(int[] semiSleeper) {
		this.semiSleeper = semiSleeper;
	}

	public final int[] getSleeper() {
		return sleeper;
	}

	public final void setSleeper(int[] sleeper) {
		this.sleeper = sleeper;
	}

	public final int getAmount() {
		return amount;
	}

	public final void setAmount(int amount) {
		this.amount = amount;
	}
}
