package com.bean;

public class Transfer {
	private String id;
	private String currentCity;
	private String preferredCity;
	private String reason;
	public Transfer(String id, String currentCity, String preferredCity, String reason) {
		this.id = id;
		this.currentCity = currentCity;
		this.preferredCity = preferredCity;
		this.reason = reason;
	}
	public Transfer() {
		super();
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getPreferredCity() {
		return preferredCity;
	}
	public void setPreferredCity(String preferredCity) {
		this.preferredCity = preferredCity;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
