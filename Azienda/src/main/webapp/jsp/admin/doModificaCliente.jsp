<%@page import="java.io.PrintWriter"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.alfasoft.dao.ClienteDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		System.out.println("doModifica");
		ClienteDao cd = new ClienteDao();
		Utente u = new Cliente();
		
		PrintWriter stampa = response.getWriter();
		
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();
		
		
		String nome = request.getParameter("nome");
		System.out.println("nome" + nome);
		String username = request.getParameter("username");
		System.out.println("username" + username);
		String password = request.getParameter("password");
		System.out.println("password" + password);
		String partitaIva = request.getParameter("pi");
		System.out.println("partitaIva" + partitaIva);
		
		String r = request.getParameter("ruolo");
		char ruolo = r.charAt(0);
		System.out.println("ruolo" + ruolo);
		
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		System.out.println(idUtente);
		
		u.setId_utente(idUtente);
		u.setNome(nome);
		u.setUsername(username);
		u.setPassword(password);
		((Cliente)u).setPI(partitaIva);
		u.setRuolo(ruolo);
		
		cd._update(u);
		
		Cliente c = cd._select(idUtente);
		
		JsonElement cliente = gson.toJsonTree(c);
		
		if(c != null){
			jobj.addProperty("success",true);
		}else{
			jobj.addProperty("success",false);
		}
		
		jobj.add("cliente", cliente);
		
		stampa.println(jobj.toString());
		System.out.println(jobj.toString());
		stampa.close();
	%>