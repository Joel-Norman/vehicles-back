package com.api.vehicles.infraestructura.adapter.outputs.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ConsultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nit;
	String placa;
	String status;
	@ManyToOne
	User user;
	String inform;
	Date initDate;
	Date paymentDate;
	double price;
	double tax1;
	double tax2;
	double priceTx1;
	double priceTx2;
	String orderNumber;
	public ConsultEntity() {
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
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
