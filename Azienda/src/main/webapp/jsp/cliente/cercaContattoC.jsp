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
							<a href="#">Cerca Contatto</a>
						</li>
					</ul>
				</div>
				<div class="row center">
					<form class="form-inline" method="POST">
		                <fieldset>
		                	<div class="input-group col-md-2">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
								<input type="text" id="nome" name="nome" class="form-control" placeholder="Nome">
							</div>
		                    
		                    <div class="input-group col-md-2">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
								<input type="text" id="cognome" name="cognome" class="form-control" placeholder="Cognome">
							</div>
							
							<div class="input-group col-md-2">
		                        <button type="button" id="cerca" class="btn btn-primary">Cerca</button>
		                    </div>
		                </fieldset>
		            </form>
				</div>
	
				<div class="row">
					<br />
					<table class="table table-bordered" id="tabella" style="display:none;">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Cognome</th>
								<th>Telefono</th>
							</tr>
						</thead>
						<tbody id="contatti">
							
						</tbody>
					</table>
					
				</div>
	
				<div class="row">
					<div id="nocontatti">
						<table class="table table-bordered">
						
						</table>
					</div>
				</div>

				<div class="row">
				   
				</div>
			
			</div>
		</div>

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
	jQuery(document).ready(function() {
		$("#cerca").on("click", function(){
			var nome = $("#nome").val();
			var cognome = $("#cognome").val();
			console.log(nome +" " + cognome);
			
			$.ajax({
				type: "POST", 
				url : "doCercaContattoC.jsp",
				data: {"nome":nome, "cognome":cognome} , 
				dataType : "json" ,
				
				success: function(data){
					if(data.success) {
						$("#contatti").html("");
						$("#tabella").show();
						$.each(data.voci, function( i, itemData ) {
		            		$("#contatti").append(
		            								"<tr>"+
		            									"<td>" + itemData.nome 		+ 	"</td>" +
		            									"<td>" + itemData.cognome 	+ 	"</td>" +
		            									"<td>" + itemData.telefono 	+ 	"</td>" +
		            								"</tr>"
		            							);
		            	});
					}else {
						$("#nocontatti").html("");
						$("#nocontatti").append("<tr><td>Contatto inesistente</td></tr>");
					}
				}, 
		
		 		error: function(jqXHR,txtStatus,erroreLanciato){
					console.log("qualcosa e' andato male :" +txtStatus); 
		 		}
	 		}); 
		})
	});
</script>
</html>