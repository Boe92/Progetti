<%@page import="com.alfasoft.entita.Cliente"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.dao.ClienteDao"%>
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
							<a href="#">Elenco Clienti</a>
						</li>
					</ul>
				</div>
				
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well">
								<h2><i class="glyphicon glyphicon-user"></i> Lista Clienti</h2>

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
							   				<th>Username</th>
							   				<th>Password</th>
							   				<th>Partita Iva</th>
							   				<th>Operazioni</th>
							   			</tr>
				   					</thead>
				   					<tbody>
							   			<%
											ClienteDao cd = new ClienteDao();
											List<Cliente> clienti = cd._selectAll();
											for(Cliente c : clienti) {
										%>
										<tr id="<%=c.getId_utente() %>">
							   				<td class="name<%=c.getId_utente() %>"> <%=c.getNome() %>		</td>
							   				<td class="user<%=c.getId_utente() %>"> <%=c.getUsername() %>	</td>
							   				<td class="pwd<%=c.getId_utente() %>"> <%=c.getPassword() %>	</td>
							   				<td class="pi<%=c.getId_utente() %>"> <%=c.getPI() %>	</td>
							   				<td>
							   					<form method="post" style="display: inline;">
							   						<input type="hidden" name="idUtente" value="<%=c.getId_utente() %>" />
								   					<button onclick="cancella(this)" name="<%=c.getNome() %>" id="<%=c.getId_utente() %>" class="btn btn-danger btn-sm">
								   						<i class="glyphicon glyphicon-trash icon-white"></i>
															Cancella
								   					</button>
							   					</form>
							   					<form method="post" style="display: inline;">
							   						<input type="hidden" name="idUtente" value="<%=c.getId_utente() %>">
							   						<button onclick="modifica(this)" name="<%=c.getNome() %>" id="<%=c.getId_utente() %>" class="btn btn-primary btn-setting btn-sm">
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
					<div id="risposta"></div>
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
						<h3>Modifica cliente</h3>
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
			
			var userModificato = $("#username").val();
			
			var pwdModificato = $("#password").val();
			
			var piModificato = $("#pi").val();
			
			var idUtente = $("#idUtente").val();
			
			var ruolo = $("#ruolo").val();
			
			$.ajax({
				type: "POST", 
				url : "doModificaCliente.jsp",
				data: {"nome":nomeModificato,"username":userModificato,"password":pwdModificato,"pi":piModificato,"ruolo":ruolo,"idUtente":idUtente},
				dataType : "JSON" ,

				success: function(data,txtStatus,jqXHR){
					if(data.success){
						console.log("<p> SUCCESS </p>");
						
						$("#myModal").modal("toggle");
						
						var id = data.cliente.id_utente;
						console.log(id);
						$(".name"+id).html(data.cliente.nome);
						$(".user"+id).html(data.cliente.username);
						$(".pwd"+id).html(data.cliente.password);
						$(".pi"+id).html(data.cliente.PI);
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
		var nomeCliente  = $(param).attr("name");
		
		var res = confirm("Sei sicuro di voler eliminare il cliente "+nomeCliente+" dalla tua lista?");
		if (res) {
			$.ajax({
               	type: "POST",
               	url:  "doCancellaCliente.jsp",
               	data: {"idUtente":idUtente},
               	
               	success: function(data) {
					$("#"+idUtente).hide();
				}
			});
		}
	}
	
	function modifica(param){
		var idUtente  = $(param).attr("id");
		console.log("id: "+idUtente);
		$.ajax({
			type: "POST",
			url:  "doCreaFormCliente.jsp",
			data: {"idUtente":idUtente},
			
			success: function(data) {
				$("#appendForm").empty();
				$("#appendForm").append(data);
			}
		});	
	}
</script>
</html>