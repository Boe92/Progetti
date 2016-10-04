package com.biblioteca.output;

import com.biblioteca.action.GestioneBiblioteca;
import com.biblioteca.entita.Biblioteca;

public class TestBiblioteca {

	public static void main(String[] args) {
		GestioneBiblioteca gb = new GestioneBiblioteca();
		
		Biblioteca b = new Biblioteca("Biblioteca piu bella del mondo");
		gb.registraUtente(b, "Marco", "Boemi");
		
		gb.registraLibro(b, "Autore", "Titolo", 3);
		
		System.out.println("prestaLibro 1: "+gb.prestaLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		System.out.println("prestaLibro 2: "+gb.prestaLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		System.out.println("prestaLibro 3: "+gb.prestaLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		//System.out.println(gb.prestaLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		
		System.out.println("restituisciLibro 1: "+gb.restituisciLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		System.out.println("restituisciLibro 2: "+gb.restituisciLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		System.out.println("restituisciLibro 3: "+gb.restituisciLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
		System.out.println("restituisciLibro 4: "+gb.restituisciLibro(b, "Titolo", "Autore", "Marco", "Boemi"));
	}

}
