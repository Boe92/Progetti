package com.universita.entita;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.entita.*;
import com.universita.interfacce.ValidaDato;

public class Studente extends Utente implements ValidaDato{
	
	private String matricola;
	private String media;
	
	private Universita u;
	
	//COSTRUTTORE
	public Studente(String nome, String cognome) {
		super(nome, cognome);
	}
	

	public Studente(Universita uni, String nome, String cognome, String matricola, String media) {
		super(nome, cognome);
		this.u=uni;
		this.matricola=matricola;
		this.media=media;
		
	}
	
	//INCAPSULAMENTO
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
	

	@Override
	public boolean isValid() {

		boolean res = true;
		
		if((getNome()!=null || !getNome().isEmpty()) && (getCognome()!=null || !getCognome().isEmpty())) {
			res = true;		
		}
		
		return res;
	}
	
}
