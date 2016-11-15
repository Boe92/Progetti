package com.alfasoft.entita;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity  
public class BustaPaga {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_bustaPaga;
	private String importo;
	private Date data_emissione;
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Dipendente dipendente;
	
	
	
	public BustaPaga(){}
	
	public BustaPaga(int id_bustaPaga, String importo, Date data_emissione) {
		this.id_bustaPaga = id_bustaPaga;
		this.importo = importo;
		this.data_emissione = data_emissione;
	}
	
	
	public int getId_bustaPaga() {
		return id_bustaPaga;
	}
	public void setId_bustaPaga(int id_bustaPaga) {
		this.id_bustaPaga = id_bustaPaga;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	public Date getData_emissione() {
		return data_emissione;
	}
	public void setData_emissione(Date data_emissione) {
		this.data_emissione = data_emissione;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	
}
