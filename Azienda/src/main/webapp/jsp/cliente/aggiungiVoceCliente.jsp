<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<a href="#">Aggiungi Contatto</a>
						</li>
					</ul>
				</div>
				<div class=" row">
					<form class="form-vertical" action="doAggiungiVoceC.jsp" method="post">
		                <fieldset>
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		                        <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome">
		                    </div>
		                    <div class="clearfix"></div><br>
	
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="text" id="cognome" name="cognome" class="form-control" placeholder="Cognome">
		                    </div>
		                    <div class="clearfix"></div><br>
		                    
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="text" id="telefono" name="telefono" class="form-control" placeholder="Telefono">
		                    </div>
		                    <div class="clearfix"></div><br>
		                    
		                    
		                    <p class="center col-sm-5">
		                        <button type="submit" class="btn btn-primary">Aggiungi</button>
		                    </p>
		                </fieldset>
		            </form>
				</div>
	
				<div class="row">
					
				</div>
	
				<div class="row">
					
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
$(document).ready(function() {
	$('#valida').click(function(event) {   
		var nome = $("#nome").val();
		var cognome = $("#cognome").val();
		var telefono = $("#telefono").val();
		
		
		if(nome == "" || cognome == "" || telefono == ""){
			$("#testo").show();
			return false;
		}
		
	});
});
</script>
</html>