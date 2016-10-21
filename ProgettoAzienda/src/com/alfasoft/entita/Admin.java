package com.alfasoft.entita;

import javax.persistence.Entity;

@Entity
public class Admin extends Utente{
	private String livelloAccesso;
	
	public Admin() {
		super();
	}
	
	public Admin(String livelloAccesso) {
		super();
		this.livelloAccesso = livelloAccesso;
	}

	public String getLivelloAccesso() {
		return livelloAccesso;
	}

	public void setLivelloAccesso(String livelloAccesso) {
		this.livelloAccesso = livelloAccesso;
	}
	
	
}
