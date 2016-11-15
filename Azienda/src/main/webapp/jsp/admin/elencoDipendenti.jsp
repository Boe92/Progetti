<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.dao.DipendenteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page=".././block/header.jsp" />
<body>

    <!-- topbar starts -->
	<jsp:include page="../block/navBar.jsp" />
    <!-- topbar ends -->
	
	<div class="ch-container">
    	<div class="row">
        
        	<!-- left menu starts -->
        	<jsp:include page="../block/menu.jsp" />
        	<!-- left menu ends -->

        	<div id="content" class="col-lg-10 col-sm-10">
            	<!-- content starts -->
            	<div>
					<ul class="breadcrumb">
						<li>
							<a href="#">Home</a>
						</li>
						<li>
							<a href="#">Elenco Dipendenti</a>
						</li>
					</ul>
				</div>
				
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well">
								<h2><i class="glyphicon glyphicon-user"></i> Lista Dipendenti</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
									<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i></a>
									<a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
			    					<thead>
						    			<tr>
							   				<th>Nome</th>
							   				<th>Cognome</th>
							   				<th>Username</th>
							   				<th>Password</th>
							   				<th>Stipendio</th>
							   				<th>Operazioni</th>
							   			</tr>
				   					</thead>
				   					<tbody>
							   			<%
											DipendenteDao dd = new DipendenteDao();
											List<Dipendente> dipendenti = dd._selectAll();
											for(Dipendente d : dipendenti) {
										%>
										<tr id="<%=d.getId_utente() %>" >
							   				<td class="name<%=d.getId_utente() %>"> <%=d.getNome() %>		</td>
							   				<td class="surname<%=d.getId_utente() %>"> <%=d.getCognome()%>		</td>
							   				<td class="user<%=d.getId_utente() %>"> <%=d.getUsername() %>	</td>
							   				<td class="pwd<%=d.getId_utente() %>"> <%=d.getPassword() %>	</td>
							   				<td class="stipendio<%=d.getId_utente() %>"><%=d.getStipendio() %></td>
							   				<td>
							   					<form method="post" style="display: inline;">
							   						<input type="hidden" name="idUtente" value="<%=d.getId_utente() %>">
								   					<button onclick="cancella(this)" name="<%=d.getNome() %>" id="<%=d.getId_utente() %>" class="btn btn-danger btn-sm">				
								   						<i class="glyphicon glyphicon-trash icon-white"></i>
															Cancella
								   					</button>
							   					</form>
							   					<form method="post" style="display: inline;">
							   						<input type="hidden" name="idUtente" value="<%=d.getId_utente() %>">
								   					<button onclick="modifica(this)" name="<%=d.getNome() %>" id="<%=d.getId_utente() %>" class="btn btn-primary btn-sm btn-setting">
								   						<i class="glyphicon glyphicon-edit icon-white"></i>
															Modifica
								   					</button>
								   				</form>
							   				</td>
						   				</tr>
										<%		
											}
										%>
				   					</tbody>
			   					</table>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
<!-- 					<div id="dialog-confirm" title="Sei sicuro?"> -->
<!--   						<p> -->
<!--   							<span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span> -->
<!--   							Sei sicuro di voler eliminare questo dipendente dalla tua lista? -->
<!--   						</p> -->
<!-- 					</div> -->
				</div>
	
				<div class="row">
					
				</div>

				<div class="row">
				   
				</div>
			
			</div>
		</div>
		
		<!-- INIZIO MODAL MEDIO -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>Modifica dipendente</h3>
					</div>
					<div id="appendForm" class="modal-body">
						

						
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-default" data-dismiss="modal">Chiudi</a>
   						<button id="salva" class="btn btn-primary">
   							<i class="glyphicon glyphicon-file icon-white"></i>
								Salva
   						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- FINE MODAL -->
		
    <hr>
	
	<!-- footer -->
	<jsp:include page="../block/footer.jsp" />
	<!-- footer -->
	
	</div><!--/.fluid-container-->

	<!-- external javascript -->
	<jsp:include page="../block/includeScriptJs.jsp" />
	<!-- external javascript -->

</body>
<script>
	$(document).ready(function() {
		$("#salva").on("click", function(){
			var nomeModificato = $("#nome").val();
			//alert(nomeModificato);
			var cognomeModificato = $("#cognome").val();
			
			var userModificato = $("#username").val();
			
			var pwdModificato = $("#password").val();
			
			var stipendioModificato = $("#stipendio").val();
			//alert(stipendioModificato);
			var idUtente = $("#idUtente").val();
			
			var ruolo = $("#ruolo").val();
			
			$.ajax({
				type: "POST", 
				url : "doModificaDipendente.jsp",
				data: {"nome":nomeModificato,"cognome":cognomeModificato,"username":userModificato,"password":pwdModificato,"stipendio":stipendioModificato,"ruolo":ruolo,"idUtente":idUtente},
				dataType : "JSON" ,

				success: function(data,txtStatus,jqXHR){
					if(data.success){
						$("#myModal").modal("toggle");
						
						var id = data.dipendente.id_utente;
						$(".name"+id).html(data.dipendente.nome);
						$(".surname"+id).html(data.dipendente.cognome);
						$(".user"+id).html(data.dipendente.username);
						$(".pwd"+id).html(data.dipendente.password);
						$(".stipendio"+id).html(data.dipendente.stipendio);
					}else{
						console.log("<p> quell'utente non esiste </p>");
						//$("#risposta").html("");
						//$("#risposta").append("<p> quell'utente non esiste </p>");
					}
				}, 
		
		 		error: function(jqXHR,txtStatus,erroreLanciato){
					console.log("qualcosa e' andato male :" +txtStatus); 
		 		}
	 		}); 
		});

	});
	
	
	function cancella(param){
		var idUtente  = $(param).attr("id");
		var nomeDipendente  = $(param).attr("name");
		
		var res = confirm("Sei sicuro di voler eliminare il cliente "+nomeDipendente+" dalla tua lista?");
 		if (res) {
 			$.ajax({
             	type: "POST",
              	url:  "doCancellaDipendente.jsp",
              	data: {"idUtente":idUtente},
           	
              	success: function(data) {
 					$("#"+idUtente).hide();
 				}
 			});
 		}
			
			
// 		$( "#dialog-confirm" ).dialog({
// 	   		resizable: false,
// 	   		autoOpen: true,
// 	   		modal: true,
// 	   		height: "auto",
// 	  		width: 400,
// 	   		buttons: {
// 	     		"Si, cancella": function() {
// 	     			$.ajax({
// 	                    	type: "POST",
// 	                    	url:  "doCancellaDipendente.jsp",
// 	                    	data: {"idUtente":idUtente},
	                   	
// 	                    	success: function(data) {
// 	     					$("#"+idUtente).hide();
// 	     				}
// 	     			});
	     			
// 	     			$( this ).dialog( "close" );
// 	     		},
// 	     		Cancel: function() {
// 	       			$( this ).dialog( "close" );
// 	     		}
// 	   		}
// 	 	});
	}
	
	function modifica(param){
		var idUtente  = $(param).attr("id");
		//alert("id: "+idUtente);
		$.ajax({
			type: "POST",
			url:  "doCreaFormDipendente.jsp",
			data: {"idUtente":idUtente},
			
			success: function(data) {
				$("#appendForm").empty();
				$("#appendForm").append(data);
			}
		});	
	}
</script>
</html>