package com.alfasoft.entita;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Dipendente extends Utente{
	private String stipendio;
	
	@OneToOne
	private Rubrica rubrica;
	
	
	public Dipendente() {
		super();
	}
	
	
	
	public Dipendente(String stipendio) {
		super();
		this.stipendio = stipendio;
	}



	public String getStipendio() {
		return stipendio;
	}

	public void setStipendio(String stipendio) {
		this.stipendio = stipendio;
	}



	public Rubrica getRubrica() {
		return rubrica;
	}



	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	
}
