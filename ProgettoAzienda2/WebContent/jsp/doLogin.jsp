<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@page import="com.alfasoft.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    	
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
    	
		if (username != null || !username.isEmpty() && password != null || !password.isEmpty()) {
			Utente u = gs.login(username, password);
    		
    		HttpSession sessione = request.getSession();
    		sessione.setAttribute("IdUtente", u.getId_utente());
    		
    		System.out.println("ID_SESSIONE_UTENTE: " + sessione.getAttribute("IdUtente"));
    		if(u.getRuolo()=='A') {
    %>
    			<jsp:forward page="homeAdmin.jsp"></jsp:forward>
    <%
    		}else if(u.getRuolo()=='C') {
    			//Cliente c = gs.recuperoCliente(u.getId_utente());
    			//sessione.setAttribute("IdRubricaCliente", c.getRubrica().getId_rubrica());
    %>
    			<jsp:forward page="homeCliente.jsp"></jsp:forward>
    <%		
    		}else if(u.getRuolo()=='D') {
    			//Dipendente d = gs.recuperoDipendente(u.getId_utente());
    			//sessione.setAttribute("IdRubricaDipendente", d.getRubrica().getId_rubrica());
    %>
    			<jsp:forward page="homeDipendente.jsp"></jsp:forward>
    <%		
    		}
		} else {
	%>
			<jsp:forward page="login.jsp"></jsp:forward>
	<%
		}
    %>