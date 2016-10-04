package com.campionato.entita;

public class Squadra {
	private String nome;
	
	private int punteggio = 0;
	private int goalFatti;
	private int goalSubiti;
	private int differenzaGoal;
	
	
	public Squadra(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	public int getGoalFatti() {
		return goalFatti;
	}
	public void setGoalFatti(int goalFatti) {
		this.goalFatti = goalFatti;
	}
	public int getGoalSubiti() {
		return goalSubiti;
	}
	public void setGoalSubiti(int goalSubiti) {
		this.goalSubiti = goalSubiti;
	}
	public int getDifferenzaGoal() {
		return differenzaGoal;
	}
	public void setDifferenzaGoal(int differenzaGoal) {
		this.differenzaGoal = differenzaGoal;
	}
	
	
}
