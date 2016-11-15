<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	<%
		GestioneServizi gs = new GestioneServizi();
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		System.out.println("recupero id elimina: " + idUtente);
		
		gs.eliminaDipendente(idUtente);
		
		response.sendRedirect("elencoDipendenti.jsp");
	%>