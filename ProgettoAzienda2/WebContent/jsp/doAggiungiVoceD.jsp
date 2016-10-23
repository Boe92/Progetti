<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    	
    	HttpSession sessione = request.getSession();
    	int idUtente = (int) sessione.getAttribute("IdUtente");
    	
    	String nome = request.getParameter("nome");
    	String cognome = request.getParameter("cognome");
    	String telefono = request.getParameter("telefono");
    	
    	Dipendente d = gs.getIdRubricaDipendente(idUtente);
    	
    	System.out.print("getIdRubricaDipendente"+d.getRubrica().getId_rubrica());
    	boolean res = gs.aggiungiVoce(nome, cognome, telefono, d.getRubrica().getId_rubrica());
    	
    	if (res) {
    %>
    		<jsp:forward page="elencoVociDipendenti.jsp"></jsp:forward>
    <%		
    	}else {
    %>
    		<jsp:forward page="aggiungiVoceDipendente.jsp"></jsp:forward>
    <%
    	}
    %>