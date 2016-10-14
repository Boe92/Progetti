package com.rubrica.entita;

public class Rubrica {
	private int id_rubrica;
	private String nome;
	
	public Rubrica() {}
	
	public Rubrica(int id_rubrica, String nome) {
		this.id_rubrica = id_rubrica;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId_rubrica() {
		return id_rubrica;
	}
	public void setId_rubrica(int id_rubrica) {
		this.id_rubrica = id_rubrica;
	}
	
}
