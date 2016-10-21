package com.alfasoft.entita;

import javax.persistence.Entity;

@Entity
public class Dipendente extends Utente{
	private double stipendio;
	
	public Dipendente() {
		super();
	}
	
	
	
	public Dipendente(double stipendio) {
		super();
		this.stipendio = stipendio;
	}



	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	
	
}
