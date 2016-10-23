<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.dao.DipendenteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="Container"> <!--  start of container -->
  		<div id="header">
			<h1>Header</h1>
		</div>
		<div class="menu">
  			<jsp:include page="block/menuAdmin.jsp"></jsp:include>
		</div>
    	<div id="content">
    		<table>
    			<thead>
	    			<tr>
		   				<th>Nome</th>
		   				<th>Cognome</th>
		   				<th>Username</th>
		   				<th>Password</th>
		   				<th>Stipendio</th>
		   			</tr>
	   			</thead>
	   			<tbody>
	   			<%
					DipendenteDao dd = new DipendenteDao();
					List<Dipendente> dipendenti = dd._selectAll();
					for(Dipendente d : dipendenti) {
				%>
						<tr>
			   				<td><%=d.getNome() %></td>
			   				<td><%=d.getCognome() %></td>
			   				<td><%=d.getUsername() %></td>
			   				<td><%=d.getPassword() %></td>
			   				<td><%=d.getStipendio() %></td>
		   				</tr>
				<%		
					}
				%>
	   			</tbody>
   			</table>
  		</div>
    	<div id="footer">
 			<h1>Footer</h1>
  		</div>
  	</div> <!--  end of container -->
</body>
</html>