package com.progetto.entita;

public class Persona {
	private int id_persona;
	private String nome;
	private String cognome;
	private String CF;
	
	public Persona() {}
	
	public Persona(int id_persona, String nome, String cognome, String CF) {
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
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
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		this.CF = cF;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	
	
}
