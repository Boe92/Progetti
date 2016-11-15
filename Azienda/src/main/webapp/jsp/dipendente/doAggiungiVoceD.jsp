<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    	
    	HttpSession sessione = request.getSession();
    	Utente u = (Utente) sessione.getAttribute("Utente");
    	
    	String nome = request.getParameter("nome");
    	String cognome = request.getParameter("cognome");
    	String telefono = request.getParameter("telefono");
    	
    	System.out.println("doAggiungiVoceD " + u.getId_utente());
    	Dipendente d = gs.getIdRubricaDipendente(u.getId_utente());
    	
    	System.out.println("getIdRubricaDipendente "+d.getRubrica().getId_rubrica());
    	boolean res = gs.aggiungiVoce(nome, cognome, telefono, d.getRubrica().getId_rubrica());
    	
    	if (res) {
    		response.sendRedirect("elencoVociDipendenti.jsp");
    	}else {
    		response.sendRedirect("aggiungiVoceDipendente.jsp");
    	}
    %>