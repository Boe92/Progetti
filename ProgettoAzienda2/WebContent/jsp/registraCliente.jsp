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
		var nome = $("#nome").val();
		var username = $("#username").val();
		var password = $("#password").val();
		var partitaIva = $("#partitaIva").val();
		var rubrica = $("#rubrica").val();
		
		if(nome == "" || username == "" || password == "" || partitaIva == "" || rubrica == ""){
			$("#testo").append("*Campi obbligatori");
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
		<div class="menu">
  			<jsp:include page="block/menuAdmin.jsp"></jsp:include>
		</div>
    	<div id="content">
    		<h2> Registra Cliente </h2>
    		
    		<div id="testo" style="color:red; display: none;"> </div>
   			
   			<form action="doRegistraCliente.jsp" method="post">
   				Nome<input type="text" id="nome" name="nome"> <br>
   				Username<input type="text" id="username" name="username"> <br>
   				Password<input type="password" id="password" name="password"> <br>
   				Partita Iva<input type="text" id="partitaIva" name="partitaIva"> <br>
   				Rubrica<input type="text" id="rubrica" name="rubrica"> <br>
   				
   				<input type="submit" id="valida" value="Registra">
   			</form>
  		</div>
    	<div id="footer">
 			<h1>Footer</h1>
  		</div>
  	</div> <!--  end of container -->
</body>
</html>