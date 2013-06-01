
package com.hmkcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/servlet"})
public class MyServlet extends HttpServlet {

 
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
		try{
        	PrintWriter out = response.getWriter();
			out.println("<h2>Hello @WebServlet</h2>");
        } catch (IOException ioe) {
			
        }
    }

    
}
