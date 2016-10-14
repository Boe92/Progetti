package com.progetto.entita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name="Macchina") 
public class Macchina {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id_macchina;
	@Column(name="modello")
	private String modello;
	@Column(name="targa")
	private String targa;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Persona> persona = new HashSet<Persona>();

	public Macchina() {}

	public Macchina(int id_macchina, String modello, String targa) {
		this.id_macchina = id_macchina;
		this.modello = modello;
		this.targa = targa;
	}
	
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}

	public int getId_macchina() {
		return id_macchina;
	}

	public void setId_macchina(int id_macchina) {
		this.id_macchina = id_macchina;
	}
	public Set<Persona> getPersona() {
		return persona;
	}

	public void setPersona(Set<Persona> persona) {
		this.persona = persona;
	}
	
	public void addPersona(Persona p){
		this.persona.add(p);
	}
}
