<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.awt.Window.Type"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.alfasoft.dao.VoceDao"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.alfasoft.entita.Voce"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.alfasoft.dao.ClienteDao"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<%
		System.out.print("prova");
		GestioneServizi gs = new GestioneServizi();
		VoceDao vd = new VoceDao();

		JSONObject jobj = new JSONObject();
		JSONArray JSONArray = new JSONArray();
		
		HttpSession sessione = request.getSession();
		Utente u = (Utente)sessione.getAttribute("Utente");
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		Dipendente d = gs.getIdRubricaDipendente(u.getId_utente());
		
		List<Voce> voci = vd._select(d.getRubrica().getId_rubrica(), nome, cognome);
		
 		for(Voce v: voci) {
 			JSONObject tmpJObj = new JSONObject();
 			tmpJObj.put("nome", v.getNome());
 			tmpJObj.put("cognome", v.getCognome());
 			tmpJObj.put("telefono", v.getTelefono());
 			JSONArray.put(tmpJObj);
 		}
		
 		jobj.put("success",false);
   		if(voci.size() > 0){
    		jobj.put("success",true);
    	}
 		
 		jobj.put("voci", JSONArray);
  		
 		System.out.print(jobj.toString());
  		response.setContentType("application/json");
  		response.getWriter().write(jobj.toString());
  		
	%>