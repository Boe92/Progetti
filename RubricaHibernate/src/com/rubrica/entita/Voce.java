package com.rubrica.entita;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="Voce")
public class Voce {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id_voce;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="telefono")
	private String telefono;
	
	
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
	
	
	
}
