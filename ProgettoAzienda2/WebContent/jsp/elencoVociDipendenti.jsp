<%@page import="com.alfasoft.entita.Voce"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.dao.DipendenteDao"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="Container"> <!--  start of container -->
  		<div id="header">
			<h1>Header</h1>
		</div>
		<div class="menu">
  			<jsp:include page="block/menuDipendente.jsp"></jsp:include>
		</div>
    	<div id="content">
    		<center>
	   			<h1>ELENCO VOCI DIPENDENTI</h1>
	   			<table>
	    			<thead>
		    			<tr>
			   				<th>Nome</th>
			   				<th>Cognome</th>
			   				<th>Telefono</th>
			   			</tr>
		   			</thead>
		   			<tbody>
		   			<%
		   				HttpSession sessione = request.getSession();
		   	    		int idUtente = (int) sessione.getAttribute("IdUtente");
		   	    		System.out.println("ID_SESSIONE_UTENTE - elencoVoci "+idUtente);
		   	    		
		   	    		GestioneServizi gs = new GestioneServizi();
		   	    		DipendenteDao dd = new DipendenteDao();
		   				
		   	    		Dipendente d = gs.getIdRubricaDipendente(idUtente);
						
		   	    		System.out.println("ID_RUBRICA_DIPENDENTE - elencoVoci "+d.getRubrica().getId_rubrica());
		   				List<Voce> voci = dd._getTutteVoci(d.getRubrica().getId_rubrica());
						for(Voce v : voci) {
					%>
							<tr>
				   				<td><%=v.getNome() %></td>
				   				<td><%=v.getCognome() %></td>
				   				<td><%=v.getTelefono() %></td>
			   				</tr>
					<%		
						}
					%>
		   			</tbody>
	   			</table>
   			</center>
  		</div>
    	<div id="footer">
 			<h1>Footer</h1>
  		</div>
  	</div> <!--  end of container -->
</body>
</html>