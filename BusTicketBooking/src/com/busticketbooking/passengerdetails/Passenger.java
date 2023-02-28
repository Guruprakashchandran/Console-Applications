package com.busticketbooking.passengerdetails;

public class Passenger {

	private int passengerId;
	private String busId;
	private String busName;
	private int bookingId;
	private String email;
	private String[] names;
	private int[] ages;
	private String[] namessl;
	private int[] agessl;
	private String source;
	private String destination;
	private int semiSleeperSeat[];
	private int sleeperSeat[];
	private int amount;
	private String date;

	public Passenger(int passengerId, String busId, String busName, int bookingId, String email, String[] names,
			int[] ages, String[] namessl, int[] agessl, String source, String destination, int[] semiSleeperSeat,
			int[] sleeperSeat, int amount, String date) {
		super();
		this.passengerId = passengerId;
		this.busId = busId;
		this.busName = busName;
		this.bookingId = bookingId;
		this.email = email;
		this.names = new String[names.length];
		this.ages = new int[ages.length];
		for (int i = 0; i < names.length; ++i) {

			this.names[i] = names[i];
			this.ages[i] = ages[i];
		}
		this.namessl = new String[namessl.length];
		this.agessl = new int[agessl.length];
		for (int i = 0; i < namessl.length; ++i) {

			this.namessl[i] = namessl[i];
			this.agessl[i] = agessl[i];
		}
		this.source = source;
		this.destination = destination;
		this.semiSleeperSeat = new int[semiSleeperSeat.length];// semiSleeperSeat;
		this.sleeperSeat = new int[sleeperSeat.length];// sleeperSeat;
		this.amount = amount;
		this.date = date;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public int[] getAges() {
		return ages;
	}

	public void setAges(int[] ages) {
		this.ages = ages;
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

	public final int getBookingId() {
		return bookingId;
	}

	public final void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public final int getPassengerId() {
		return passengerId;
	}

	public final void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
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

	public final int[] getSemiSleeperSeat() {
		return semiSleeperSeat;
	}

	public final void setSemiSleeperSeat(int[] semiSleeperSeat) {
		this.semiSleeperSeat = semiSleeperSeat;
	}

	public final int[] getSleeperSeat() {
		return sleeperSeat;
	}

	public final void setSleeperSeat(int[] sleeperSeat) {
		this.sleeperSeat = sleeperSeat;
	}

	public final int getAmount() {
		return amount;
	}

	public final void setAmount(int amount) {
		this.amount = amount;
	}

	public final String getDate() {
		return date;
	}

	public final void setDate(String date) {
		this.date = date;
	}
}
