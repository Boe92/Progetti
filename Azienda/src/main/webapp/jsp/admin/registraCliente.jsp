<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
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
							<a href="#">Nuovo Cliente</a>
						</li>
					</ul>
				</div>
				<div class=" row">
					<form class="form-vertical" action="${pageContext.request.contextPath}/jsp/admin/doRegistraCliente.jsp" method="post">
		                <fieldset>
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		                        <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome">
		                    </div>
		                    <div class="clearfix"></div><br>
	
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="text" id="username" name="username" class="form-control" placeholder="Username">
		                    </div>
		                    <div class="clearfix"></div><br>
		                    
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
		                    </div>
		                    <div class="clearfix"></div><br>
		                    
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="text" id="partitaIva" name="partitaIva" class="form-control" placeholder="Partita Iva">
		                    </div>
		                    <div class="clearfix"></div><br>
		                    
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="text" id="rubrica" name="rubrica" class="form-control" placeholder="Rubrica">
		                    </div>
		                    <div class="clearfix"></div><br>
		
		                    <p class="center col-sm-5">
		                        <button type="submit" class="btn btn-primary">Registra</button>
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
		var username = $("#username").val();
		var password = $("#password").val();
		var partitaIva = $("#partitaIva").val();
		var rubrica = $("#rubrica").val();
		
		if(nome == "" || username == "" || password == "" || partitaIva == "" || rubrica == ""){
			$("#testo").show();
			return false;
		}
		
	});
});
</script>
</html>