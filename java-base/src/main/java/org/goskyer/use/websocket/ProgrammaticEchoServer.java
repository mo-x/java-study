package org.goskyer.use.websocket;


import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by zzqno on 2017-3-1.
 * 编程式端点
 */
public class ProgrammaticEchoServer extends Endpoint {


    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        final Session mySession = session;
        mySession.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String text) {
                try {
                    mySession.getBasicRemote().sendText(" I got this("+text+")  so I am sending it back!");
                } catch (IOException e) {
                    System.out.println("something went wrong trying to send the message back" + e.getMessage());
                    
                }

            }
        });

    }
}
