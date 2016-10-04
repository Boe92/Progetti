package com.universita.entita;

import java.util.ArrayList;
import java.util.List;

public class Universita {
	
	private String nome;
	
	private List<Studente> listaStudenti=new ArrayList<Studente>();
	private List<Docente> listaDocenti=new ArrayList<Docente>();
	private List<Corso> listaCorsi=new ArrayList<Corso>();

	
	public String generaMatricola(String nome, String cognome) {

		List<Studente> studenti = getListaStudenti();
		
		String sub_nome = nome.substring(0, 2);
		String sub_cognome = cognome.substring(0, 2);
		
		int numIncremento = studenti.size() + 1;

		String matricola = sub_nome + sub_cognome + numIncremento;
		
		return matricola;
	}
	
	//COSTRUTTORE
	public Universita(String nome) {
		this.nome = nome;
	}
	
	public Universita() {}
	
	//INCAPSULAMENTO
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Docente> getListaDocenti() {
		return listaDocenti;
	}


	public void setListaDocenti(List<Docente> listaDocenti) {
		this.listaDocenti = listaDocenti;
	}


	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}


	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}


	public void setListaCorsi(List<Corso> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}


}
