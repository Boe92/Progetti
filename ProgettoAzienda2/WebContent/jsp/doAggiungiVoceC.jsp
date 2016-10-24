<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    	
    	HttpSession sessione = request.getSession();
    	int idUtente = (Integer)sessione.getAttribute("IdUtente");
    	//Object obj = sessione.getAttribute("IdUtente");
    	//String temp =  obj.toString();
    	//int idUtente = Integer.parseInt(temp); //(int)sessione.getAttribute("IdUtente");
    	
    	String nome = request.getParameter("nome");
    	String cognome = request.getParameter("cognome");
    	String telefono = request.getParameter("telefono");
    	
    	Cliente c = gs.getIdRubricaCliente(idUtente);
    	
    	boolean res = gs.aggiungiVoce(nome, cognome, telefono, c.getRubrica().getId_rubrica());
    	
    	if (res) {
    %>
    		<jsp:forward page="elencoVociClienti.jsp"></jsp:forward>
    <%		
    	}else {
    %>
    		<jsp:forward page="aggiungiVoceCliente.jsp"></jsp:forward>
    <%
    	}
    %>