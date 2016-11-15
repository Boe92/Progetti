package com.alfasoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alfasoft.dao.ClienteDao;
import com.alfasoft.entita.Cliente;
import com.alfasoft.entita.Utente;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


@WebServlet(description = "questo viene chiamata tramite ajax", urlPatterns = { "/modificaForm" })
public class ModificaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDao cd = new ClienteDao();
		Utente u = new Cliente();
		
		PrintWriter stampa = response.getWriter();
		
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();
		
		
		String nome = request.getParameter("nome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String partitaIva = request.getParameter("pi");
		
		String r = request.getParameter("ruolo");
		char ruolo = r.charAt(0);
		
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		
		u.setId_utente(idUtente);
		u.setNome(nome);
		u.setCognome("");
		u.setUsername(username);
		u.setPassword(password);
		((Cliente)u).setPI(partitaIva);
		u.setRuolo(ruolo);
		
		cd._update(u);
		
		Cliente c = cd._select(idUtente);
		System.out.println(c.getId_utente()+" / "+c.getNome()+" / "+c.getUsername()+" / "+c.getPassword()+" / "+c.getPI());
		
		JsonElement cliente = gson.toJsonTree(c);
		
		jobj.addProperty("success",false);
		if(c != null){
			jobj.addProperty("success",true);
		}
		
		jobj.add("cliente", cliente);
		
		stampa.println(jobj.toString());
		stampa.close();
	}

}
