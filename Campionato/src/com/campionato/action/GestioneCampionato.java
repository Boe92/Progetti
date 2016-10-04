package com.campionato.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



import com.campionato.compara.GiocatoreComparate;
import com.campionato.compara.SquadraComparate;
import com.campionato.entita.Campionato;
import com.campionato.entita.Giocatore;
import com.campionato.entita.Partita;
import com.campionato.entita.Squadra;

public class GestioneCampionato {

	public Giocatore registraGiocatore(Campionato c, String nome, String cognome, String CF){
		Giocatore g = null;

		if (!c.getListaGiocatori().containsKey(CF)){
			g = new Giocatore(nome, cognome, CF);
			c.getListaGiocatori().put(CF,g);
			System.out.println("Giocatore registrato! ");
		}else {
			System.out.println("Giocatore gi� presente");
		}

		return g;
	}
	
	public Squadra registraSquadra(Campionato c, String nome){
		
		Squadra s = new Squadra(nome);
		
		List<Squadra> listaSquadra = c.getListaSquadra();
		if (listaSquadra.size() > 0) {
			for(Squadra s1 : listaSquadra){
				if (s1.getNome().equals(nome)) {
					System.out.println("Squadra gi� presente 2");
					break;
				}else {
					listaSquadra.add(s);
					System.out.println("Squadra registrata 2");
					break;
				}
			}
		}else {
			listaSquadra.add(s);
			System.out.println("Squadra registrata 1");
		}
		
		return s;
	}
	public boolean assegnaGiocatoreSquadra(Campionato c, Giocatore g, Squadra s){
		
		boolean res = false;
		String CF = g.getCF();
		
		if(c.getListaGiocatoreSquadra().containsKey(CF)) {
			System.out.println("Giocatore gi� assegnato ");
			res = false;
		}else {
			c.getListaGiocatoreSquadra().put(CF,s);
			System.out.println("Giocatore assegnato! ");
			res = true;
		}

		return res;
	}
	public Partita registraPartita(Campionato c, Squadra casa, Squadra ospite, int goalCasa, int goalOspite, String data, List<Giocatore> ammoniti, List<Giocatore> espulsioni, List<Giocatore> retiFatte){
		
		String chiaveSquadra = casa.getNome() + ospite.getNome();
		int numRetiTotali = 0;
		int goalCasaOspite = goalCasa + goalOspite;

		Partita p = new Partita();
		
		//GOAL FATTI
		for(Giocatore g1 : retiFatte) {
			//setto per ogni giocatore della listaGiocatori le sue reti da retiFatte
			c.getListaGiocatori().get(g1.getCF()).setReti();

			numRetiTotali = numRetiTotali + 1;
		}
		//AMMONIZIONI PRESE
		for(Giocatore g1 : ammoniti) {
			c.getListaGiocatori().get(g1.getCF()).setAmmonizione();
		}
		//ESPULSIONI PRESE
		for(Giocatore g1 : espulsioni) {
			c.getListaGiocatori().get(g1.getCF()).setEspulsione();
		}
		
		
		//if(goalCasaOspite!=numRetiTotali){
			System.out.print("Le reti totali non corrispondono con i goal partita");
		//}else {
			if(goalCasa==goalOspite){
				p.setRisultato('x');
				casa.setPunteggio(casa.getPunteggio() + 1);
				ospite.setPunteggio(ospite.getPunteggio() + 1);
			}else if(goalCasa>goalOspite) {
				p.setRisultato('1');
				casa.setPunteggio(casa.getPunteggio() + 3);
				//ospite.setPunteggio(ospite.getPunteggio() + 0);
			}else if(goalCasa<goalOspite) {
				p.setRisultato('2');
				//casa.setPunteggio(casa.getPunteggio() + 0);
				ospite.setPunteggio(ospite.getPunteggio() + 3);
			}
			
			//setto variabili oggetto
			p.setData(data);
			p.setSquadraCasa(casa.getNome());
			p.setSquadraOspite(ospite.getNome());
			p.setGoalFattiCasa(goalCasa);
			p.setGoalFattiOspite(goalOspite);
			
			int diffGoal = goalCasa - goalOspite;
			casa.setDifferenzaGoal(diffGoal);
			
			diffGoal = goalOspite - goalCasa ;
			ospite.setDifferenzaGoal(diffGoal);
			
			c.getListaPartita().put(chiaveSquadra, p);
		//}
		
		return p;
	}
	
	public void getCapoCannoniere(Campionato c){
		HashMap<String,Giocatore> listaMarcatori = c.getListaGiocatori();
		
		List<Giocatore> temp = new ArrayList<Giocatore>(listaMarcatori.values());
		
		Collections.sort(temp ,new GiocatoreComparate());
		for (Giocatore g : temp) {
			if(g.getReti() > 0) {
				System.out.println(g.getCF()+ " " + g.getReti()+ " " + g.getAmmonizione() +" "+ g.getEspulsione());
			}
		}
	}
	
	public void getSquadraCampione(Campionato c){
		List<Squadra> listaSquadra = c.getListaSquadra();
		
		Collections.sort(listaSquadra ,new SquadraComparate());
		for (Squadra s : listaSquadra) {
			if(s.getPunteggio() > 0) {
				System.out.println(s.getNome()+ " " + s.getPunteggio()+ " " + s.getDifferenzaGoal());
			}
		}
	}
	
}
