<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		ClienteDao cd = new ClienteDao();
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		Cliente cliente = cd._select(idUtente);
	%>
	<form class="form-horizontal">
		<fieldset>
			<div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		        <input type="text" id="nome" name="nome" class="form-control" value="<%= cliente.getNome() %>">
		    </div>
		    <div class="clearfix"></div><br>
		
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="text" id="username" name="username" class="form-control" value="<%= cliente.getUsername() %>">
		    </div>
		    <div class="clearfix"></div><br>
		    
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="password" id="password" name="password" class="form-control" value="<%= cliente.getPassword() %>">
		    </div>
		    <div class="clearfix"></div><br>
		    
		    <div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="text" id="pi" name="pi" class="form-control" value="<%= cliente.getPI() %>">
		        </div>
			<div class="clearfix"></div><br>
			
			<div class="input-group input-group-sm">
		        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		        <input type="text" id="ruolo" name="ruolo" class="form-control" value="<%= cliente.getRuolo() %>">
		        </div>
			<div class="clearfix"></div>
		
			<input type="hidden" id="idUtente" name="idUtente" class="form-control" value="<%= cliente.getId_utente() %>">
		</fieldset>
	</form>
   