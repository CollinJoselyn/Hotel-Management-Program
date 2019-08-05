package application;

/*
 * This class is for the room information
 */

public class Room {
	String roomNumber, numOfBeds;
	String cost;
	
	
	public Room() {
		roomNumber = "";
		numOfBeds = "";
		cost = "";
		
	}
	
	public Room(String roomNumber, String numOfBeds, String cost) {
		this.roomNumber = roomNumber;
		this.numOfBeds = numOfBeds;
		this.cost = cost;
		
	}
	
	

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getNumOfBeds() {
		return numOfBeds;
	}

	public void setNumOfBeds(String numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", numOfBeds=" + numOfBeds + ", cost=" + cost + "]";
	}

	
	

	
	
}
