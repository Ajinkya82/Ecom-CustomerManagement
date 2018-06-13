package com.bean;

import java.util.Date;

public class Customer {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Date date;
	private String gender;
	private String permanantAddress;
	private String presentAddress;
	private String email;
	private long number;
	private String Id;
	public Customer(String firstName, String middleName, String lastName, Date date, String gender,
			String permanantAddress, String presentAddress, String email, long number, String id) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.date = date;
		this.gender = gender;
		this.permanantAddress = permanantAddress;
		this.presentAddress = presentAddress;
		this.email = email;
		this.number = number;
	}
	
	public Customer() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPermanantAddress() {
		return permanantAddress;
	}
	public void setPermanantAddress(String permanantAddress) {
		this.permanantAddress = permanantAddress;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	
}
