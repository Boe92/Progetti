<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.12.3.min.js"></script>
<script>
$(document).ready(function() {
	$('#valida').click(function(event) {   
		var nome = $("#nome").val();
		var cognome = $("#cognome").val();
		var telefono = $("#telefono").val();
		
		
		if(nome == "" || cognome == "" || telefono == ""){
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
  			<jsp:include page="block/menuDipendente.jsp"></jsp:include>
		</div>
    	<div id="content">
   			<h1>NUOVA VOCE DIPENDENTE</h1>
   			
   			<div id="testo" style="color:red; display: none;"> </div>
   			
   			<form action="doAggiungiVoceD.jsp" method="post">
   				Nome <input type="text" id="nome" name="nome"> <br>
   				Cognome <input type="text" id="cognome" name="cognome"> <br>
   				Telefono <input type="text" id="telefono" name="telefono"> <br>
   				
   				<input type="submit" id="valida" value="Inserisci">
   			</form>
  		</div>
    	<div id="footer">
 			<h1>Footer</h1>
  		</div>
  	</div> <!--  end of container -->
</body>
</html>