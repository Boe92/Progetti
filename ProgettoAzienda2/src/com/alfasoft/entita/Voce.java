package com.alfasoft.entita;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voce {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_voce;
	private String nome;
	private String cognome;
	private String telefono;
	
	@ManyToOne
	private Rubrica rubrica;
	
	public Voce() {}
	
	public Voce(int id_voce, String nome, String cognome, String telefono) {
		this.id_voce = id_voce;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	
	public int getId_voce() {
		return id_voce;
	}
	public void setId_voce(int id_voce) {
		this.id_voce = id_voce;
	}
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	
	
}
