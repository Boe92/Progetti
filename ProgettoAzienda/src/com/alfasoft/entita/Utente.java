package com.alfasoft.entita;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING)
public class Utente {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_utente;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private char ruolo;
	
	
	public Utente() {
		super();
	}
	
	public Utente(int id_utente, String nome, String cognome, String username, String password, char ruolo) {
		super();
		this.id_utente = id_utente;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getRuolo() {
		return ruolo;
	}
	public void setRuolo(char ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
