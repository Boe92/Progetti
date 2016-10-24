<%@page import="com.alfasoft.dao.ClienteDao"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		GestioneServizi gs = new GestioneServizi();
		
		String nome = request.getParameter("nome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String partitaIva = request.getParameter("partitaIva");
		String rubrica = request.getParameter("rubrica");
	
		if((password!=null && !password.isEmpty()) && (nome!=null && !nome.isEmpty()) && 
			(username!=null && !username.isEmpty()) && (partitaIva!=null && !partitaIva.isEmpty()) && (rubrica!=null || !rubrica.isEmpty())) {
			
			boolean res = gs.registraCliente(nome, username, password, partitaIva, rubrica);
			if (res) {
	%>
				<jsp:forward page="elencoClienti.jsp"></jsp:forward>
	<%		
			}else {
	%>
				<jsp:forward page="registraCliente.jsp"></jsp:forward>
	<% 		
			}
		}
	%>
