package com.api.vehicles.domain;

public class ProcessPayment {
	private String redirect;
    private String key;
    private String amount;
    private String currency;
    private String billToFirstName;
    private String billToLastName;
    private String billToAddress;
    private String billToAddress2;
    private String billToCity;
    private String billToState;
    private String billToZipPostCode;
    private String billToCountry;
    private String billToTelephone;
    private String billToEmail;
    
    private String orderNumber;
    private String capture;
    private String subscription;
    private String platform;
	public ProcessPayment() {
		super();
	}
	public String getRedirect() {
		return redirect;
	}
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBillToFirstName() {
		return billToFirstName;
	}
	public void setBillToFirstName(String billToFirstName) {
		this.billToFirstName = billToFirstName;
	}
	public String getBillToLastName() {
		return billToLastName;
	}
	public void setBillToLastName(String billToLastName) {
		this.billToLastName = billToLastName;
	}
	public String getBillToAddress() {
		return billToAddress;
	}
	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}
	public String getBillToAddress2() {
		return billToAddress2;
	}
	public void setBillToAddress2(String billToAddress2) {
		this.billToAddress2 = billToAddress2;
	}
	public String getBillToCity() {
		return billToCity;
	}
	public void setBillToCity(String billToCity) {
		this.billToCity = billToCity;
	}
	public String getBillToState() {
		return billToState;
	}
	public void setBillToState(String billToState) {
		this.billToState = billToState;
	}
	public String getBillToZipPostCode() {
		return billToZipPostCode;
	}
	public void setBillToZipPostCode(String billToZipPostCode) {
		this.billToZipPostCode = billToZipPostCode;
	}
	public String getBillToCountry() {
		return billToCountry;
	}
	public void setBillToCountry(String billToCountry) {
		this.billToCountry = billToCountry;
	}
	public String getBillToTelephone() {
		return billToTelephone;
	}
	public void setBillToTelephone(String billToTelephone) {
		this.billToTelephone = billToTelephone;
	}
	public String getBillToEmail() {
		return billToEmail;
	}
	public void setBillToEmail(String billToEmail) {
		this.billToEmail = billToEmail;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCapture() {
		return capture;
	}
	public void setCapture(String capture) {
		this.capture = capture;
	}
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
    
    
}
