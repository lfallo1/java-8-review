package com.lancefallon.collectionsreview;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TheatreSet {
	private final String theatreName;
	private NavigableSet<Seat> seats = new TreeSet<>(); //since seat implements comparable, we can define this is a sorted set

	public TheatreSet(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(String.format("%c%02d", (char) row, seatNum));
				seats.add(seat);
			}
		}

		System.out.println("# of seats: " + seats.size());
		seats.add(new Seat("A01")); // won't be added in set if Seat implements
									// equals as having same seat#, since sets cannot have dups
		System.out.println("# of seats: " + seats.size());
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
		for (Seat seat : seats) {
			if (seat.getSeatNumber().equals(seatNumber)) {
				return seat;
			}
		}
		return null;
	}

	// for testing
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	public NavigableSet<Seat> getAllSeats(){
		return seats;
	}

	private class Seat implements Comparable<Seat> {
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

		private TheatreSet getOuterType() {
			return TheatreSet.this;
		}

		@Override
		public int compareTo(Seat seat) {
			return this.getSeatNumber().compareTo(seat.getSeatNumber());
		}

	}

}
