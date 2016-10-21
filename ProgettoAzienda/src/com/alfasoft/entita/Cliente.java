package com.alfasoft.entita;

import javax.persistence.Entity;

@Entity
public class Cliente extends Utente{
	private String PI;
	
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
