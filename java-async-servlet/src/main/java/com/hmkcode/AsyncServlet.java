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

  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	   
	   final AsyncContext ctx = req.startAsync();
	   
	   ctx.setTimeout(3000);
	   
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
	   
	   
	   ctx.start(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 try {
					ctx.getResponse().getWriter().write("Async Started...");
				} catch (IOException e) {
					e.printStackTrace();
				}
				 
			 ctx.complete();
			}
	   });
   }
}
