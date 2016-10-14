package com.rubrica.entita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="Rubrica") 
public class Rubrica {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id_rubrica;
	@Column(name="nome")
	private String nome;
	
	@OneToMany
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Voce> voci = new HashSet<Voce>();
	
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
	public Set<Voce> getVoci() {
		return voci;
	}

	public void setVoci(Set<Voce> voci) {
		this.voci = voci;
	}
	
	public void addVoce(Voce v) {
		this.voci.add(v);
	}
}
