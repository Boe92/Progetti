<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.alfasoft.entita.BustaPaga"%>
<%@page import="com.alfasoft.dao.BustaPagaDao"%>
<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.entita.Voce"%>
<%@page import="java.util.List"%>
<%@page import="com.alfasoft.entita.Dipendente"%>
<%@page import="com.alfasoft.dao.DipendenteDao"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
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
							<a href="#">Buste Paga</a>
						</li>
					</ul>
				</div>
				
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" >
								<h2><i class="glyphicon glyphicon-user"></i> Lista Buste Paga</h2>

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
							   				<th>Importo</th>
							   				<th>Data emissione</th>
							   				
							   			</tr>
						   			</thead>
						   			<tbody>
						   			<%
						   				HttpSession sessione = request.getSession();
						   	    		Utente u = (Utente) sessione.getAttribute("Utente");
						   	    		
						   	    		GestioneServizi gs = new GestioneServizi();
						   	    		BustaPagaDao bp = new BustaPagaDao();
										
						   	    		List<BustaPaga> buste = bp._selectAll(u.getId_utente());
						   				if(buste!=null) {
											for(BustaPaga b : buste) {
									%>
											<tr>
								   				<td><%=b.getImporto() %></td>
								   				<td>
								   					<%
							   							SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
							   							String date = sdf.format(b.getData_emissione());
							   						%>
							   						<%= date %>
								   				</td>
							   				</tr>
									<%		
											}
						   				}
									%>
						   			</tbody>
	   							</table>
							</div>
						</div>
					</div>
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
</html>