package com.campionato.output;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.campionato.action.GestioneCampionato;
import com.campionato.entita.Campionato;
import com.campionato.entita.Giocatore;
import com.campionato.entita.Squadra;

public class TestCampionato {

	public static void main(String[] args) {
		GestioneCampionato g = new GestioneCampionato();
		
		Campionato c = new Campionato("Serie A");
		
		Giocatore giocatore1 = g.registraGiocatore(c, "Marco", "Boemi", "BMOMRC92B10L219E");
		Giocatore giocatore2 = g.registraGiocatore(c, "Giuseppe", "Boemi", "BMOGSP92B10L219E");
		Giocatore giocatore3 = g.registraGiocatore(c, "Luca", "Boemi", "BMORTY92B10L219E");
		Giocatore giocatore4 = g.registraGiocatore(c, "Piero", "Boemi", "BMOXDS90B10L219E");
		Giocatore giocatore5 = g.registraGiocatore(c, "Andrea", "Boemi", "BMOZAQ92B10L219E");
		Giocatore giocatore6 = g.registraGiocatore(c, "Alessandro", "Boemi", "BMOMKI92B10L219E");
		Giocatore giocatore7 = g.registraGiocatore(c, "Mario", "Boemi", "BMOBBB92B10L219E");
		Giocatore giocatore8 = g.registraGiocatore(c, "Maurizio", "Boemi", "BMOYUI92B10L219E");
		Giocatore giocatore9 = g.registraGiocatore(c, "Alex", "Boemi", "BMOPLM92B10L219E");
		Giocatore giocatore10 = g.registraGiocatore(c, "Alberto", "Boemi", "BMOEWE92B10L219E");
		Giocatore giocatore11 = g.registraGiocatore(c, "Alberto", "Boemi", "BMOKJH92B10L219E");
		Giocatore giocatore12 = g.registraGiocatore(c, "Alberto", "Boemi", "BMOMNB78B10L219E");
		
		Squadra team = g.registraSquadra(c, "Juventus");
		Squadra team2 = g.registraSquadra(c, "Inter");
		Squadra team3 = g.registraSquadra(c, "Roma");
		Squadra team4 = g.registraSquadra(c, "Milan");
		
		g.assegnaGiocatoreSquadra(c, giocatore1, team);
		g.assegnaGiocatoreSquadra(c, giocatore2, team);
		g.assegnaGiocatoreSquadra(c, giocatore3, team);
		g.assegnaGiocatoreSquadra(c, giocatore4, team2);
		g.assegnaGiocatoreSquadra(c, giocatore5, team2);
		g.assegnaGiocatoreSquadra(c, giocatore6, team2);
		g.assegnaGiocatoreSquadra(c, giocatore7, team3);
		g.assegnaGiocatoreSquadra(c, giocatore8, team3);
		g.assegnaGiocatoreSquadra(c, giocatore9, team3);
		g.assegnaGiocatoreSquadra(c, giocatore10, team4);
		g.assegnaGiocatoreSquadra(c, giocatore11, team4);
		g.assegnaGiocatoreSquadra(c, giocatore12, team4);
		
		//ricavo data odierna
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = sdf.format(new Date()); 
		
		List<Giocatore> listaGoalGiocatori = new ArrayList<Giocatore>();
		
		listaGoalGiocatori.add(giocatore1);
		listaGoalGiocatori.add(giocatore1);
		listaGoalGiocatori.add(giocatore6);
		//listaGoalGiocatori.add(giocatore6);
		
		List<Giocatore> listaGiocatoriAmmoniti = new ArrayList<Giocatore>();
		
		listaGiocatoriAmmoniti.add(giocatore1);
		listaGiocatoriAmmoniti.add(giocatore6);
		
		List<Giocatore> listaGiocatoriEspulsi = new ArrayList<Giocatore>();
		listaGiocatoriEspulsi.add(giocatore6);
		
		g.registraPartita(c, team, team2, 3, 2, dataStr, listaGiocatoriAmmoniti, listaGiocatoriEspulsi, listaGoalGiocatori);
		//g.registraPartita(c, team3, team4, 2, 3, dataStr, listaGiocatoriAmmoniti, listaGiocatoriEspulsi, listaGoalGiocatori);
		g.getCapoCannoniere(c);
		
		g.getSquadraCampione(c);
	}

}
