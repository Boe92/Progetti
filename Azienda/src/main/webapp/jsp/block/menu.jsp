<%@page import="com.alfasoft.entita.Utente"%>
<%@page import="com.alfasoft.servizi.GestioneServizi"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <%
                    	HttpSession sessione = request.getSession();
                    	Utente u = (Utente) sessione.getAttribute("Utente");
                    	
                    	GestioneServizi gs = new GestioneServizi();
                    	
                    	String ruolo = gs.trovaRuolo(u.getId_utente());
                    	if (ruolo.equals("Admin")) {
                    %>
		                    <ul class="nav nav-pills nav-stacked main-menu">
		                        <li class="nav-header">Main</li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/homeAdmin.jsp"><i class="glyphicon glyphicon-home"></i><span> Home</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/registraCliente.jsp"><i class="glyphicon glyphicon-plus"></i><span> Nuovo Cliente</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/registraDipendente.jsp"><i class="glyphicon glyphicon-plus"></i><span> Nuovo Dipendente</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/registraBustaPaga.jsp"><i class="glyphicon glyphicon-plus"></i><span> Nuova busta paga</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/elencoClienti.jsp"><i class="glyphicon glyphicon-th-list"></i><span> Elenco Clienti</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/elencoDipendenti.jsp"><i class="glyphicon glyphicon-th-list"></i><span> Elenco Dipendenti</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/admin/elencoBustePaga.jsp"><i class="glyphicon glyphicon-th-list"></i><span> Elenco buste paga</span></a>
		                        </li>
		                        
		                        <li class="nav-header hidden-md">Report</li>
		                        <li>
		                        	<a class="ajax-link" href="#"><i class="glyphicon glyphicon-download-alt"></i><span> Scarica Documenti</span></a>
		                       	</li>
		                       	<li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/logout.jsp"><i class="glyphicon glyphicon-off"></i><span> Logout</span></a>
		                        </li>
		                    </ul>
				<%
                    	} else if (ruolo.equals("Cliente")) {
                %>
                			<ul class="nav nav-pills nav-stacked main-menu">
		                        <li class="nav-header">Main</li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/cliente/homeCliente.jsp"><i class="glyphicon glyphicon-home"></i><span> Home Cliente</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/cliente/aggiungiVoceCliente.jsp"><i class="glyphicon glyphicon-plus"></i><span> Aggiungi Contatto</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/cliente/elencoVociClienti.jsp"><i class="glyphicon glyphicon-th-list"></i><span> Elenco Contatti</span></a>
		                        </li>
		                		<li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/cliente/cercaContattoC.jsp"><i class="glyphicon glyphicon-search"></i><span> Cerca Contatto</span></a>
		                        </li>
		                        
		                        <li class="nav-header hidden-md">Report</li>
		                        <li>
		                        	<a class="ajax-link" href="#"><i class="glyphicon glyphicon-download-alt"></i><span> Scarica Documenti</span></a>
		                       	</li>
		                       	<li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/logout.jsp"><i class="glyphicon glyphicon-off"></i><span> Logout</span></a>
		                        </li>
		                    </ul>
                <%    		
                    	} else {
             	%>
             				<ul class="nav nav-pills nav-stacked main-menu">
		                        <li class="nav-header">Main</li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/dipendente/homeDipendente.jsp"><i class="glyphicon glyphicon-home"></i><span> Home Dipendente</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/dipendente/aggiungiVoceDipendente.jsp"><i class="glyphicon glyphicon-plus"></i><span> Aggiungi Contatto</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/dipendente/elencoVociDipendenti.jsp"><i class="glyphicon glyphicon-th-list"></i><span> Elenco Contatti</span></a>
		                        </li>
		                        <li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/dipendente/elencoMieBuste.jsp"><i class="glyphicon glyphicon-th-list"></i><span> Mie Buste Paga</span></a>
		                        </li>
		                		<li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/dipendente/cercaContattoD.jsp"><i class="glyphicon glyphicon-search"></i><span> Cerca Contatto</span></a>
		                        </li>
		                        
		                        <li class="nav-header hidden-md">Report</li>
		                        <li>
		                        	<a class="ajax-link" href="#"><i class="glyphicon glyphicon-download-alt"></i><span> Scarica Documenti</span></a>
		                       	</li>
		                       	<li>
		                        	<a class="ajax-link" href="<%=request.getContextPath()%>/jsp/logout.jsp"><i class="glyphicon glyphicon-off"></i><span> Logout</span></a>
		                        </li>
		                    </ul>
             	<%
                    	}
				%>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->