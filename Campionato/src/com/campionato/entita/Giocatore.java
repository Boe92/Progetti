package com.campionato.entita;

public class Giocatore {
	private String nome;
	private String cognome;
	private String ruolo;
	private String CF;
	
	private Double stipendio;
	
	private int eta;
	private int ammonizione;
	private int espulsione;
	private int reti;
	private int assist;
	
	public Giocatore(){}
	
	public Giocatore(String nome, String cognome, String CF){
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
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Double getStipendio() {
		return stipendio;
	}
	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getAmmonizione() {
		return ammonizione;
	}
	public void setAmmonizione() {
		this.ammonizione += 1;
	}
	public int getEspulsione() {
		return espulsione;
	}
	public void setEspulsione() {
		this.espulsione += 1;
	}
	public int getReti() {
		return reti;
	}
	public void setReti() {
		this.reti += 1;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	

}
