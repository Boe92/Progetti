package com.alfasoft.entita;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Utente{
	private String PI;
	
	@OneToOne
	private Rubrica rubrica;
	
	
	public Rubrica getRubrica() {
		return rubrica;
	}



	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}



	public Cliente() {
		super();
	}
	
	
	
	public Cliente(String PI) {
		super();
		this.PI = PI;
	}


	public String getPI() {
		return PI;
	}

	public void setPI(String PI) {
		this.PI = PI;
	}
	
	
	
}
