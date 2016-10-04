package com.biblioteca.entita;

import java.util.Date;

public class Prestito {
	
	private Libro libro;
	private Utente utente;
	
	private Date dataPrestito;
	private Date dataRestituzione;
	
	
	//COSTRUTTORE
	public Prestito(Libro libro, Utente utente, Date dataPrestito, Date dataRestituzione) {
		this.libro = libro;
		this.utente = utente;
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
	}
	
	
	
	//INCAPSULAMENTO
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	

}
