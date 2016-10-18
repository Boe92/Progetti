package com.autenticazione.boemi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Autentica
 */
@WebServlet("/Autentica")
public class Autentica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Autentica() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals("123")) {
			response.sendRedirect("benvenuto.html");
		}
	}

}
