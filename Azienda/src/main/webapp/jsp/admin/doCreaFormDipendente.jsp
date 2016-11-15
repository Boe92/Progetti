<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.dao.DipendenteDao"%>
<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		DipendenteDao dd = new DipendenteDao();
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		Dipendente dipendente = dd._select(idUtente);
	%>
	<form class="form-horizontal">
		<fieldset>
			<div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		        <input type="text" id="nome" name="nome" class="form-control" value="<%= dipendente.getNome() %>">
		    </div>
		    <div class="clearfix"></div><br>
		    
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		        <input type="text" id="cognome" name="cognome" class="form-control" value="<%= dipendente.getCognome() %>">
		    </div>
		    <div class="clearfix"></div><br>
		
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="text" id="username" name="username" class="form-control" value="<%= dipendente.getUsername() %>">
		    </div>
		    <div class="clearfix"></div><br>
		    
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="password" id="password" name="password" class="form-control" value="<%= dipendente.getPassword() %>">
		    </div>
		    <div class="clearfix"></div><br>
		    
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="text" id="stipendio" name="stipendio" class="form-control" value="<%= dipendente.getStipendio() %>">
		        </div>
			<div class="clearfix"></div><br>
			
			<div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="text" id="ruolo" name="ruolo" class="form-control" value="<%= dipendente.getRuolo() %>">
		        </div>
			<div class="clearfix"></div>
		
			<input type="hidden" id="idUtente" name="idUtente" class="form-control" value="<%= dipendente.getId_utente() %>">
		</fieldset>
	</form>
   