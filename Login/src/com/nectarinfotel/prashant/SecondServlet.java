package com.nectarinfotel.prashant;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("EMAIL");  
    @SuppressWarnings("unused")
	String p=request.getParameter("PASS");  
    out.print("Welcome "+n);  
          
    out.close();  
    }  
  
}  