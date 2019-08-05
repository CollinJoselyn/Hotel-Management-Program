package application;

/*
 * This class controls the reservation information. 
 */

public class Reservation {
	String checkInDate, checkOutDate;
	
	public Reservation() {
		checkInDate = "";
		checkOutDate = "";
	}
	
	public Reservation(String checkInDate, String checkOutDate) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "Reservation [checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	
	

}
