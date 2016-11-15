<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	HttpSession sessione = request.getSession();
    	sessione.invalidate();
    %>
    
    <jsp:forward page="login.jsp"></jsp:forward>