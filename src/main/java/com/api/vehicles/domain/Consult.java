package com.api.vehicles.domain;

import java.util.Date;

public class Consult {
	final Long id;
    final String nit;
    final String placa;
    final String status;
    final String inform;
    final String mes;        // Nuevo campo: mes
    final String fecha;      // Nuevo campo: fecha
    final String diaSemana;  // Nuevo campo: día de la semana
    final String hora; 
    boolean pagado;
	Date date;
	
	public Consult(Long id, String nit, String placa, String status, String inform, String mes, String fecha,
			String diaSemana, String hora,boolean pagado,Date date) {
		super();
		this.id = id;
		this.nit = nit;
		this.placa = placa;
		this.status = status;
		this.inform = inform;
		this.mes = mes;
		this.fecha = fecha;
		this.diaSemana = diaSemana;
		this.hora = hora;
		this.pagado = pagado;
		this.date=date;
	}
	public Long getId() {
		return id;
	}
	public String getNit() {
		return nit;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public String getPlaca() {
		return placa;
	}
	public String getStatus() {
		return status;
	}
	public String getInform() {
		return inform;
	}
	public String getMes() {
		return mes;
	}
	public String getFecha() {
		return fecha;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public String getHora() {
		return hora;
	}
	
    
    
}
