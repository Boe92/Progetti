<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<jsp:include page="block/header.jsp" />

<body>

    
	<div class="ch-container">
    	<div class="row">
        
    		<div class="row">
        		<div class="well col-md-5 center login-box">
		            <div class="alert alert-info">
		                Please login with your Username and Password.
		            </div>
		            <% 
   						if (request.getAttribute("errore")!=null) {
   							out.print("Username o Password errati");
   						}
   					%>
		            <form class="form-horizontal" action="${pageContext.request.contextPath}/jsp/doLogin.jsp" method="post">
		                <fieldset>
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
		                        <input type="text" id="username" name="username" class="form-control" placeholder="Username">
		                    </div>
		                    <div class="clearfix"></div><br>
		
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
		                    </div>
		                    <div class="clearfix"></div>
		
		                    <div class="input-prepend">
		                        <label class="remember" for="remember"><input type="checkbox" id="remember"> Remember me</label>
		                    </div>
		                    <div class="clearfix"></div>
		
		                    <p class="center col-sm-5">
		                        <button type="submit" class="btn btn-primary">Login</button>
		                    </p>
		                </fieldset>
		            </form>
        		</div>
			</div>
		</div>
    <hr>
	
	<!-- footer -->
	<jsp:include page="block/footer.jsp" />
	<!-- footer -->
	
	</div><!--/.fluid-container-->

	

</body>
<!-- external javascript -->
	<jsp:include page="block/includeScriptJs.jsp" />
<!-- external javascript -->
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
</html>