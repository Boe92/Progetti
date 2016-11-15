<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
<script>
$(document).ready(function() {
	$('#valida').click(function(event) {   
		var username = $("#username").val();
		var password = $("#password").val();
		
		if(username == "" || password == ""){
			$("#testo").show();
			return false;
		}
		
	});
});
</script>
</head>
<body>
	<div id="Container"> <!--  start of container -->
  		
  		<div id="header">
			<h1>Header</h1>
		</div>
		
	</div>
	<center>
   		<h2> LOGIN </h2>
   		<% 
   			if (request.getAttribute("errore")!=null) {
   				out.print("<p color=\"red\">Username o Password errati</p>");
   			}
   		
   		%>
   		<div id="testo" style="color:red; display: none;"> *Campi obbligatori </div>
  		<form action="doLogin.jsp" method="post">
			<input type="text" id="username" name="username">
			<input type="password" name="password">
	
			<input type="submit" id="valida" value="Login">
		</form>
	</center>

</body>
</html>