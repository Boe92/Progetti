package com.biblioteca.entita;


public class Prestito {
	
	private Libro libro;
	private Utente utente;
	
	
	
	//COSTRUTTORE
	public Prestito(Libro libro, Utente utente) {
		this.libro = libro;
		this.utente = utente;
		
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

	

}
