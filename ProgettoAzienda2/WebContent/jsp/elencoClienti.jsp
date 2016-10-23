<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
		   				<th>Username</th>
		   				<th>Password</th>
		   				<th>Partita Iva</th>
		   			</tr>
	   			</thead>
	   			<tbody>
	   			<%
					ClienteDao cd = new ClienteDao();
					List<Cliente> clienti = cd._selectAll();
					for(Cliente c : clienti) {
				%>
						<tr>
			   				<td><%=c.getNome() %></td>
			   				<td><%=c.getUsername() %></td>
			   				<td><%=c.getPassword() %></td>
			   				<td><%=c.getPI() %></td>
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