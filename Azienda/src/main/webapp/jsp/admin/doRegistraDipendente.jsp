<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		GestioneServizi gs = new GestioneServizi();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String stipendio = request.getParameter("stipendio");
		String rubrica = request.getParameter("rubrica");
		
		if((password!=null && !password.isEmpty()) && (nome!=null && !nome.isEmpty()) && (username!=null && !username.isEmpty()) && 
			(stipendio!=null && !stipendio.isEmpty()) && (cognome!=null && !cognome.isEmpty()) && (rubrica!=null && !rubrica.isEmpty())) {
			
			boolean res = gs.registraDipendente(nome, cognome, username, password, stipendio, rubrica);
			if (res) {
				response.sendRedirect("elencoDipendenti.jsp");
			}else {
				response.sendRedirect("registraDipendente.jsp");
			}
		}
	%>
