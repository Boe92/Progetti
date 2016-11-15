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
							<a href="#">Nuova Busta Paga</a>
						</li>
					</ul>
				</div>
				<div class=" row">
					<form class="form-vertical" action="doBustaPaga.jsp" method="post">
		                <fieldset>
		                    
		                    <div class="control-group">
                    			<label class="control-label" for="selectError">Elenco dipendenti</label>
			                    <div class="controls">
			                    
			                        <select id="selectError" name="selezioneDip" data-rel="chosen" style="width:20%">
			                        <%
										DipendenteDao dd = new DipendenteDao();
										List<Dipendente> dipendenti = dd._selectAll();
										for(Dipendente d : dipendenti) {
									%>
			                            	<option value="<%=d.getId_utente() %>"><%=d.getNome() %> <%=d.getCognome()%></option>
			          				<%
										}
			          				%>
			                        </select>
			                    </div>
                			</div>
                			<br>
		                    <div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
		                        <input type="text" id="importo" name="importo" class="form-control" placeholder="Importo">
		                    </div>
		                    <div class="clearfix"></div><br>
							
							<div class="input-group input-group-sm">
		                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar red"></i></span>
		                        <input type="text" id="datepicker" name="data" class="form-control" placeholder="Data emissione">
		                    </div>
		                    <div class="clearfix"></div><br>
		                    
		                    <p class="center col-sm-5">
		                        <button type="submit" class="btn btn-primary">Emetti</button>
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
	  	$(function() {
	    	$("#datepicker").datepicker({
	    		dateFormat: 'dd/mm/yy',
	    		minDate: 0
	    	});
	  	});
	});
</script>
</html>