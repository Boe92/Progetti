package com.autenticazione.boemi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//recupero password
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals("123")) {
			RequestDispatcher rd2 = request.getRequestDispatcher("loginSuccess.jsp"); 
			String user = request.getParameter("user");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			rd2.forward(request, response);
		}else {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("login.html"); 
			PrintWriter pw = response.getWriter();
			
			pw.print("Password errata!");
			rd.include(request, response);
		}
	}

}
