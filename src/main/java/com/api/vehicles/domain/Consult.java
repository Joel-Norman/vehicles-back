package com.api.vehicles.domain;

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
	
	
	public Consult(Long id, String nit, String placa, String status, String inform, String mes, String fecha,
			String diaSemana, String hora) {
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
	}
	public Long getId() {
		return id;
	}
	public String getNit() {
		return nit;
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
