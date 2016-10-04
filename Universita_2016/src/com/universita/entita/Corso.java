package com.universita.entita;

import java.util.ArrayList;
import java.util.List;

import com.universita.interfacce.ValidaDato;

public class Corso implements ValidaDato{
	
	private String nome;
	private int ore;
	
	private List<Studente> studentiCorso = new ArrayList<Studente>();
	private List<Docente> docentiCorso = new ArrayList<Docente>();

	//COSTRUTTORE
	public Corso(String nome, int ore) {
		this.nome = nome;
		this.ore = ore;
	}


	//INCAPSULAMENTO
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}
	
	
	public List<Studente> getStudentiCorso() {
		return studentiCorso;
	}


	public void setStudentiCorso(List<Studente> studentiCorso) {
		this.studentiCorso = studentiCorso;
	}


	@Override
	public boolean isValid() {
		
		boolean res = false;
		
		if((!nome.isEmpty() && nome!=null) && ore!=0){
			res = true;			
		}
		
		return res;
	}


	public List<Docente> getDocentiCorso() {
		return docentiCorso;
	}


	public void setDocentiCorso(List<Docente> docentiCorso) {
		this.docentiCorso = docentiCorso;
	}

	

}
