package com.api.vehicles.domain;


public class Configuration {
	
	String apiKey;
	String apiUser;
	String apiPassword;
	double tax1;
	double tax2;
	double price;
	
	
	public Configuration() {
		super();
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getApiUser() {
		return apiUser;
	}
	public void setApiUser(String apiUser) {
		this.apiUser = apiUser;
	}
	public String getApiPassword() {
		return apiPassword;
	}
	public void setApiPassword(String apiPassword) {
		this.apiPassword = apiPassword;
	}
	public double getTax1() {
		return tax1;
	}
	public void setTax1(double tax1) {
		this.tax1 = tax1;
	}
	public double getTax2() {
		return tax2;
	}
	public void setTax2(double tax2) {
		this.tax2 = tax2;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
