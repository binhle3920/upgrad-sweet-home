package com.upgrad.bookingservice.dto;

public class BookingDTO {
	private String fromDate;
	private String toDate;
	private String aadharNumber;
	private String numOfRooms;
	public String getAadharNumber() {
		return aadharNumber;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getNumOfRooms() {
		return numOfRooms;
	}
	public void setNumOfRooms(String numOfRooms) {
		this.numOfRooms = numOfRooms;
	}
	
}
