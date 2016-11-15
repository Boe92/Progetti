package com.alfasoft.entita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dipendente extends Utente{
	private String stipendio;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Rubrica rubrica;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="dipendente")
	private Set<BustaPaga> bustapaga = new HashSet<BustaPaga>();
	
	
	
	
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



	public Set<BustaPaga> getBustapaga() {
		return bustapaga;
	}



	public void setBustapaga(Set<BustaPaga> bustapaga) {
		this.bustapaga = bustapaga;
	}


}
