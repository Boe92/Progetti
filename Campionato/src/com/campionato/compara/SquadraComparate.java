package com.campionato.compara;

import java.util.Comparator;

import com.campionato.entita.Squadra;

public class SquadraComparate implements Comparator<Squadra>{

	@Override
	public int compare(Squadra s2, Squadra s1) {
		
		int valPunti = s1.getPunteggio()- s2.getPunteggio();
		if (valPunti==0) {
			int valDiffGoal = s1.getDifferenzaGoal() - s2.getDifferenzaGoal();
			
			return valDiffGoal;
		}else {
			return valPunti;
		}
	}
}