package com.progetto.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.progetto.dao.PersonaDao;
import com.progetto.entita.Persona;

public class TestPersonaDao {
	
	static PersonaDao pd;
	
	@BeforeClass
	public static void testIstanzaClasseDao(){
		pd = new PersonaDao();		
	}
	@Test
	public void testInserimento(){
		Persona p = pd._insert("Marco", "Boemi", "BMOMRC92B10L219E");
		assertNotNull(p);
	}
	@Test
	public void testSelezione(){
		Persona p = pd._select(3);
		assertNotNull(p);
	}
	@Test
	public void testAggiorna(){
		boolean res = pd._update("Marco", "Boemi", "BMOMRC92B10L219E", 3);
		assertTrue(res);
	}
	@Test
	public void testCancella(){
		boolean res = pd._delete(3);
		assertTrue(res);
	}
}
