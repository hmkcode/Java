package com.hmkcode;

import java.io.IOException;
import java.util.LinkedList;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/websocket/{client-id}")
public class MyServerEndpoint {
	
	private static final LinkedList<Session> clients = new LinkedList<Session>();
			
	@OnOpen
	public void onOpen(Session session) {
		clients.add(session);
	}
    @OnMessage
    public void onMessage(String message,@PathParam("client-id") String clientId) {
    	for (Session client : clients) {
    		try {
    			client.getBasicRemote().sendObject(clientId+": "+message);			
    			 
			} catch (IOException e) {
				e.printStackTrace();
			} catch (EncodeException e) {
				e.printStackTrace();
			}
    	}
    }
    @OnClose
	public void onClose(Session peer) {
    	clients.remove(peer);
	}
}
