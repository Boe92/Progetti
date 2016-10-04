
package com.facebook.entity;

import java.util.ArrayList;
import java.util.List;

public class Utente {
	private String cognome;
	private String nome;
	private String email;
	
	private Integer eta;
	
	private char sesso;

	private  List<Utente> listaAmici = new ArrayList<Utente>();

	//Costruttore default
	public Utente() {}
	
	
	//Costruttore
	public Utente(String nome, String cognome, int eta, char sesso, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		this.email = email;
	}

	public void inserisciAmico(Utente u){
		listaAmici.add(u);
	}
	
	//Incapsulamento
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<Utente> getListaAmici() {
		return listaAmici;
	}


	public void setListaAmici(ArrayList<Utente> listaAmici) {
		this.listaAmici = listaAmici;
	}


	
	
}
