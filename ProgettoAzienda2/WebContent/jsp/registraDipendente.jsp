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
		var cognome = $("#cognome").val();
		var username = $("#username").val();
		var password = $("#password").val();
		var stipendio = $("#stipendio").val();
		var rubrica = $("#rubrica").val();
		
		if(nome == "" || cognome == "" || username == "" || password == "" || stipendio == "" || rubrica == ""){
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
		<div class="menu">
  			<jsp:include page="block/menuAdmin.jsp"></jsp:include>
		</div>
    	<div id="content">
    		<h2> Registra Dipendente </h2>
    		
    		<div id="testo" style="color:red; display: none;"> *Campi obbligatori </div>
   			
   			<form action="doRegistraDipendente.jsp" method="post">
   				Nome<input type="text" name="nome"> <br>
   				Cognome<input type="text" name="cognome"> <br>
   				Username<input type="text" name="username"> <br>
   				Password<input type="password" name="password"> <br>
   				Stipendio<input type="text" name="stipendio"> <br>
   				Rubrica<input type="text" name="rubrica"> <br>
   				
   				<input type="submit" id="valida" value="Registra">
   			</form>
  		</div>
    	<div id="footer">
 			<h1>Footer</h1>
  		</div>
  	</div> <!--  end of container -->
</body>
</html>