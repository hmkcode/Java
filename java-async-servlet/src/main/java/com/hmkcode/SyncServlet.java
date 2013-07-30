package com.hmkcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="syncServlet",value = {"/sync"})
public class SyncServlet extends HttpServlet 
{
	public static int index = 0;
	
	public SyncServlet(){
		System.out.println("SyncServlet - "+index++);
	}
   
private static final long serialVersionUID = 1L;

  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	   
	  
	  String seq = req.getParameter("seq");

	  try {
		  Thread.sleep(50 * Integer.parseInt(seq));
	  } catch (NumberFormatException e) {
		  e.printStackTrace();
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  resp.getWriter().write(seq);

	   
	  
   }
}
