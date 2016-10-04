package com.biblioteca.entita;

import java.util.ArrayList;
import java.util.List;

public class Utente {

	private String nome;
	private String cognome;
	private int numeroPrestiti;
	private List<Libro> listaLibriUtente =new ArrayList<Libro>();
	
	//Costruttore
	public Utente() {
	}
	
	public Utente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	//Getter e setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Libro> getListaLibriUtente() {
		return listaLibriUtente;
	}

	public void setListaLibriUtente(List<Libro> listaLibriUtente) {
		this.listaLibriUtente = listaLibriUtente;
	}
	
	//Metodo per aggiungere un libro ai prestiti di quell'utente
	public void aggiungiLibroUtente(Libro l)
	{
		listaLibriUtente.add(l);
	}
	
	//Metodo per togliere il libro restituito alla lista prestiti
	public void restituisciLibro(Libro l)
	{
		listaLibriUtente.remove(l);
	}
	
	//Metodo per la concatenazione per stampare la lista dei libri in prestito
	public String toStringPrestito()
	{
		String str="\n";
		for(Libro l: listaLibriUtente)
		{
			str=str + l.getAutore() + " " + l.getTitolo() + "\n"; 
		}
		
		return str;
	}

	public int getNumeroPrestiti() {
		return numeroPrestiti;
	}

	public void setNumeroPrestiti(int numeroPrestiti) {
		this.numeroPrestiti = numeroPrestiti;
	}
	
}
