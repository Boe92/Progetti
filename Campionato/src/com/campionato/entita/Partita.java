package com.campionato.entita;


public class Partita {
	private String data;
	
	private String squadraCasa;
	private String squadraOspite;
	
	private int goalFattiOspite;
	private int goalFattiCasa;
	
	private char risultato;
	
	public Partita() {}
	
//	public Partita(String data,String casa, String ospite, int goalOspite, int goalCasa, char ris) {
//		this.data = data;
//		this.squadraCasa = casa;
//		this.squadraOspite = ospite;
//		this.goalFattiOspite = goalOspite;
//		this.goalFattiCasa = goalCasa;
//		this.risultato = ris;
//	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSquadraCasa() {
		return squadraCasa;
	}
	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}
	public String getSquadraOspite() {
		return squadraOspite;
	}
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}
	public int getGoalFattiOspite() {
		return goalFattiOspite;
	}
	public void setGoalFattiOspite(int goalFattiOspite) {
		this.goalFattiOspite = goalFattiOspite;
	}
	public int getGoalFattiCasa() {
		return goalFattiCasa;
	}
	public void setGoalFattiCasa(int goalFattiCasa) {
		this.goalFattiCasa = goalFattiCasa;
	}
	public char getRisultato() {
		return risultato;
	}
	public void setRisultato(char risultato) {
		this.risultato = risultato;
	}
	
}
