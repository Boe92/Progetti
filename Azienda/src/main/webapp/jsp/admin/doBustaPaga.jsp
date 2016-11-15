<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    
    	String importo = request.getParameter("importo");
    	
    	//conversione data
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    	Date data = sdf.parse(request.getParameter("data"));
    	
    	//idUtente
    	int idUtente = Integer.parseInt(request.getParameter("selezioneDip"));
    	boolean res = gs.registraBustaPaga(importo, data, idUtente);
    	
    	if (res) {
			response.sendRedirect("elencoBustePaga.jsp");
		}else {
			response.sendRedirect("registraBustaPaga.jsp");
		}
    %>