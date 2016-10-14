package com.progetto.entita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name="Persona") 
public class Persona {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id_persona;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="CF")
	private String CF;
	
	
	@ManyToMany(mappedBy="persona")
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Macchina> macchina = new HashSet<Macchina>();
	
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
	public Set<Macchina> getMacchina() {
		return macchina;
	}

	public void setMacchina(Set<Macchina> macchina) {
		this.macchina = macchina;
	}
	
	public void addMacchina(Macchina m){
		this.macchina.add(m);
	}
}
