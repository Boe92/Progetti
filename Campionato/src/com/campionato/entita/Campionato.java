package com.campionato.entita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Campionato {
	
	private String nome;
	private List<Squadra> listaSquadra;
	private HashMap<String,Giocatore> listaGiocatori;
	private HashMap<String,Squadra> listaGiocatoreSquadra;
	private HashMap<String,Partita> listaPartita;
	
	public Campionato(String nome){
		this.nome = nome;
		listaGiocatori = new HashMap<String,Giocatore>();
		listaSquadra = new ArrayList<Squadra>();
		listaGiocatoreSquadra = new HashMap<String,Squadra>();
		listaPartita = new HashMap<String,Partita>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashMap<String, Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}

	public void setListaGiocatori(HashMap<String, Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}

	public List<Squadra> getListaSquadra() {
		return listaSquadra;
	}

	public void setListaSquadra(List<Squadra> listaSquadra) {
		this.listaSquadra = listaSquadra;
	}

	public HashMap<String, Squadra> getListaGiocatoreSquadra() {
		return listaGiocatoreSquadra;
	}

	public void setListaGiocatoreSquadra(
			HashMap<String, Squadra> listaGiocatoreSquadra) {
		this.listaGiocatoreSquadra = listaGiocatoreSquadra;
	}

	public HashMap<String, Partita> getListaPartita() {
		return listaPartita;
	}

	public void setListaPartita(HashMap<String, Partita> listaPartita) {
		this.listaPartita = listaPartita;
	}
	
}
