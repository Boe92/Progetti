<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@page import="com.alfasoft.dao.AdminDao"%>

    <%
    	GestioneServizi gs = new GestioneServizi();
    	
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
    	
		if ((username != null && !username.isEmpty()) && (password != null && !password.isEmpty())) {
			Utente u = gs.login(username, password);
    		if (u!=null) {
	    		HttpSession sessione = request.getSession();
	    		sessione.setAttribute("Utente", u);

	    		if(u.getRuolo()=='A') {
	    %>
	    			<jsp:forward page="admin/homeAdmin.jsp"></jsp:forward>
	    <%
	    		}else if(u.getRuolo()=='C') {
	    %>
	    			<jsp:forward page="cliente/homeCliente.jsp"></jsp:forward>
	    <%		
	    		}else if(u.getRuolo()=='D') {
	    %>
	    			<jsp:forward page="dipendente/homeDipendente.jsp"></jsp:forward>
	    <%		
	    		}
    		}else {
    				request.setAttribute("errore", 1);
    	%>
    			<jsp:forward page="login.jsp"></jsp:forward>
    	<%
    		}
		} else {
	%>
			<jsp:forward page="login.jsp"></jsp:forward>
	<%
		}
    %>