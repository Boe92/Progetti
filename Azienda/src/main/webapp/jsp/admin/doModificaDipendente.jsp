<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.dao.DipendenteDao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		System.out.println("doModifica");
		DipendenteDao dd = new DipendenteDao();
		Utente u = new Dipendente();
		
		PrintWriter stampa = response.getWriter();
		
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();
		
		
		String nome = request.getParameter("nome");
		System.out.println("nome" + nome);
		String cognome = request.getParameter("cognome");
		System.out.println("cognome" + cognome);
		String username = request.getParameter("username");
		System.out.println("username" + username);
		String password = request.getParameter("password");
		System.out.println("password" + password);
		String stipendio = request.getParameter("stipendio");
		System.out.println("stipendio" + stipendio);
		
		String r = request.getParameter("ruolo");
		char ruolo = r.charAt(0);
		System.out.println("ruolo" + ruolo);
		
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		System.out.println(idUtente);
		
		u.setId_utente(idUtente);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setUsername(username);
		u.setPassword(password);
		((Dipendente)u).setStipendio(stipendio);
		u.setRuolo(ruolo);
		
		dd._update(u);
		
		Dipendente d = dd._select(idUtente);
		
		JsonElement dipendente = gson.toJsonTree(d);
		
		if(d != null){
			jobj.addProperty("success",true);
		}else{
			jobj.addProperty("success",false);
		}
		
		jobj.add("dipendente", dipendente);
		
		stampa.println(jobj.toString());
		
		stampa.close();
	%>