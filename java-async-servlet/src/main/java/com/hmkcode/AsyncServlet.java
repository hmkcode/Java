package com.hmkcode;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="asyncServlet",value = {"/async"},asyncSupported = true)
public class AsyncServlet extends HttpServlet 
{
	

   
private static final long serialVersionUID = 1L;

	String param ="";

  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	   
	  
	   // 1.0 start async
	   final AsyncContext ctx = req.startAsync();
	   param = ctx.getRequest().getParameter("seq");
	  
	   // 2.0 set the timeout 
	   ctx.setTimeout(0);
	   
	   // 3.0 add listener
	   ctx.addListener(new AsyncListener() {
		
		   	@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				System.out.println("onTimeout...");				
			}
			
			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
				System.out.println("onStartAsync...");				
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				System.out.println("onError...");			
			}
			
			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
				System.out.println("onComplete...");
			}
	   });
	   
	   // 4.0 run a thread
	   ctx.start(new Runnable() {
			@Override
			public void run() {
				 try {
					
					  // hold until receive exit
					  while(!param.equals("exit")){}
					  
					  ctx.getResponse().getWriter().write(ctx.getRequest().getParameter("seq"));
					  
				} catch (IOException e) {
					e.printStackTrace();
				}
				 
			 ctx.complete();
			}
			
			
	   });
   }
}
