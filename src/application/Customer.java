package application;

/*
 This class is for controling the customer information
 */

public class Customer {
	
	String name, address, email, checkInDate, checkOutDate;
	String phoneNumber, custID, number, bill, status;
	
	public Customer() {
		name = "";
		address = "";
		email = "";
		phoneNumber = "";
		custID = "";
		checkInDate = "";
		checkOutDate = "";
		number = "";
		bill = "";
		status = "";
	}
	
	public Customer(String name, String address, String email, String phoneNumber, 
			String custID, String checkInDate, String checkOutDate, String number, 
			String bill, String status) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.custID = custID;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.number = number;
		this.bill = bill;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", email=" + email + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", phoneNumber=" + phoneNumber + ", custID=" + custID + ", number="
				+ number + ", bill=" + bill + ", status=" + status + "]";
	}
	
	
	
}

	