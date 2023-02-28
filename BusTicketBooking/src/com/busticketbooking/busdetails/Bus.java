package com.busticketbooking.busdetails;

import java.util.Arrays;

public class Bus {

	private String busId;
	private String busName;
	private String SourcePlaces[];
	private String destinationPlace[];
	private String arrivalTime[];
	private String dispatchingTime[];
	private String semiSleeper[];
	private String sleeper[];
	private String arrivalDate;
	private String dispatchingDate;

	public Bus(String busId, String busName, String[] SourcePlaces, String[] destinationPlace, String[] arrivalTime,
			String[] dispatchingTime, int semiSleeper, int sleeper, String arrivalDate, String dispatchingDate) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.SourcePlaces = SourcePlaces;
		this.destinationPlace = destinationPlace;
		this.arrivalTime = arrivalTime;
		this.dispatchingTime = dispatchingTime;
		this.semiSleeper = new String[semiSleeper];
		Arrays.fill(this.semiSleeper, "Not Booking");
		this.sleeper = new String[sleeper];
		Arrays.fill(this.sleeper, "Not Booking");
		this.arrivalDate = arrivalDate;
		this.dispatchingDate = dispatchingDate;
	}

	public String getDispatchingDate() {
		return dispatchingDate;
	}

	public void setDispatchingDate(String dispatchingDate) {
		this.dispatchingDate = dispatchingDate;
	}

	public final String getBusId() {
		return busId;
	}

	public final void setBusId(String busId) {
		this.busId = busId;
	}

	public final String getBusName() {
		return busName;
	}

	public final void setBusName(String busName) {
		this.busName = busName;
	}

	public final String[] getSourcePlaces() {
		return SourcePlaces;
	}

	public final void setSourcePlaces(String[] SourcePlaces) {
		this.SourcePlaces = SourcePlaces;
	}

	public final String[] getDestinationPlace() {
		return destinationPlace;
	}

	public final void setDestinationPlace(String[] destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public final String[] getArrivalTime() {
		return arrivalTime;
	}

	public final void setArrivalTime(String[] arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public final String[] getdispatchingTime() {
		return dispatchingTime;
	}

	public final void setdispatchingTime(String[] dispatchingTime) {
		this.dispatchingTime = dispatchingTime;
	}

	public final String[] getSemiSleeper() {
		return semiSleeper;
	}

	public final void setSemiSleeper(String[] semiSleeper) {
		this.semiSleeper = semiSleeper;
	}

	public final String[] getSleeper() {
		return sleeper;
	}

	public final void setSleeper(String[] sleeper) {
		this.sleeper = sleeper;
	}

	public final String getArrivalDate() {
		return arrivalDate;
	}

	public final void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
}
