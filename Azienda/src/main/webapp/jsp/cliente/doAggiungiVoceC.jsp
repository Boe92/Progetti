<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    	
    	HttpSession sessione = request.getSession();
    	Utente u = (Utente)sessione.getAttribute("Utente");
    	
    	String nome = request.getParameter("nome");
    	String cognome = request.getParameter("cognome");
    	String telefono = request.getParameter("telefono");
    	
    	Cliente c = gs.getIdRubricaCliente(u.getId_utente());
    	
    	boolean res = gs.aggiungiVoce(nome, cognome, telefono, c.getRubrica().getId_rubrica());
    	
    	if (res) {
    		response.sendRedirect("elencoVociClienti.jsp");
    	}else {
    		response.sendRedirect("aggiungiVoceCliente.jsp");
    	}
    %>