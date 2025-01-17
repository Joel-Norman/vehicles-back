package com.api.vehicles.domain;

import java.util.Date;

import com.api.vehicles.infraestructura.adapter.outputs.entities.User;


public class ListConsult {
	Long id;
	String nit;
	String placa;
	String status;
	String inform;
	Date initDate;
	Date paymentDate;
	double tax1;
	double tax2;
	double price;
	double priceTx1;
	double priceTx2;
	public ListConsult() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public Date getInitDate() {
		return initDate;
	}
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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
	public double getPriceTx1() {
		return priceTx1;
	}
	public void setPriceTx1(double priceTx1) {
		this.priceTx1 = priceTx1;
	}
	public double getPriceTx2() {
		return priceTx2;
	}
	public void setPriceTx2(double priceTx2) {
		this.priceTx2 = priceTx2;
	}
	
	
}
