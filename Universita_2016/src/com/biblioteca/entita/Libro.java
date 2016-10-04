package com.biblioteca.entita;

public class Libro {
	
	private String autore;
	private String titolo;
	private int copieTotali;
	private int copieDisponibili;
	
	//COSTRUTTORE
	public Libro() {

	}
	
	public Libro(String autore, String titolo) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.copieTotali=0;
		this.copieDisponibili=0;
	}

	//INCAPSULAMENTO
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}
	
	

}
