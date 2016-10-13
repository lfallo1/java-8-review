package com.lancefallon.collectionsreview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreArrayList {
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>(); 

	public TheatreArrayList(String theatreName, long numRows, long seatsPerRow) {
		this.theatreName = theatreName;

		long lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (long seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(String.format("%c%02d", (char) row, seatNum));
				seats.add(seat);
			}
		}
		Collections.sort(seats);
		System.out.println("# of seats: " + seats.size());
	}
	
	public List<Seat> getAllSeats(){
		seats.sort((Seat s1, Seat s2) -> -s1.compareTo(s2)); //sort the seats in descending order, based on how Seat implements is compare method
		return this.seats;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = findSeat(seatNumber);
		if (requestedSeat != null) {
			return requestedSeat.reserve();
		}
		return false;
	}

	public boolean cancelReservation(String seatNumber) {
		Seat requestedSeat = findSeat(seatNumber);
		if (requestedSeat != null) {
			return requestedSeat.cancel();
		}
		return false;
	}

	private Seat findSeat(String seatNumber) {
		Collections.sort(seats);
		Integer idx = Collections.binarySearch(seats, new Seat(seatNumber));
		return seats.get(idx);
	}

	// for testing
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}

	class Seat implements Comparable<Seat> {
		private final String seatNumber;
		private boolean reserved = false;

		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public boolean reserve() {
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Seat " + seatNumber + " reserved");
				return true;
			} else {
				return false;
			}
		}

		public boolean cancel() {
			if (this.reserved) {
				this.reserved = false;
				System.out.println("Reservation of seat " + seatNumber + " cancelled");
				return true;
			} else {
				return false;
			}
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Seat other = (Seat) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (seatNumber == null) {
				if (other.seatNumber != null)
					return false;
			} else if (!seatNumber.equals(other.seatNumber))
				return false;
			return true;
		}

		private TheatreArrayList getOuterType() {
			return TheatreArrayList.this;
		}

		@Override
		public int compareTo(Seat seat) {
			return -this.getSeatNumber().compareTo(seat.getSeatNumber());
		}

	}

}
