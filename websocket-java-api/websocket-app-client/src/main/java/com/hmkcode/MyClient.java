package com.hmkcode;

import java.io.IOException;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class MyClient {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint: " + session.getBasicRemote());
        try {
            session.getBasicRemote().sendText("Hello");
        } catch (IOException ex) {
        }
    }
    
    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
    }
    
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
