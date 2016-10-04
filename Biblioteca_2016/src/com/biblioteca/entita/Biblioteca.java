package com.biblioteca.entita;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private String nome;
	private List<Libro> listaLibri =new ArrayList<Libro>();
	private List<Utente> listaUtenti = new ArrayList<Utente>();
	private List<Prestito> listaPrestiti = new ArrayList<>();
	
	
	
	//COSTRUTTORE
	public Biblioteca() {

	}
	
	public Biblioteca(String nome) {
		this.nome = nome;
	}

	//INCAPSULAMENTO
	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}
	
	public List<Utente> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	//inserimento libro alla listaLIbri
	public void aggiungiLibro(Libro l)
	{
		listaLibri.add(l);
	}
	
	//inserimento utente alla listaUtenti
	public void aggiungiUtente(Utente u)
	{
		listaUtenti.add(u);
	}

	public List<Prestito> getListaPrestiti() {
		return listaPrestiti;
	}

	public void setListaPrestiti(List<Prestito> listaPrestiti) {
		this.listaPrestiti = listaPrestiti;
	}
	
	
}
