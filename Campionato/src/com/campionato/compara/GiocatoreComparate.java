package com.campionato.compara;

import java.util.Comparator;

import com.campionato.entita.Giocatore;

public class GiocatoreComparate implements Comparator<Giocatore>{

	@Override
	public int compare(Giocatore o1, Giocatore o2) {
		
		int valReti = o1.getReti()- o2.getReti();
		if (valReti==0) {
			int valAmmoniti = o1.getAmmonizione() - o2.getAmmonizione();
			if (valAmmoniti==0) {
				int valEspulsi = o1.getEspulsione() - o2.getEspulsione();
				return valEspulsi;
			}else {
				return valAmmoniti;
			}
		}else {
			return valReti;
		}
	}
}