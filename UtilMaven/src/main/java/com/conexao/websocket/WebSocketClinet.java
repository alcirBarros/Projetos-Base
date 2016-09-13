package com.conexao.websocket;

import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author alci
 */
public class WebSocketClinet {

    final static CountDownLatch messageLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://192.168.1.31:8080/WebSocketTest/echo";
            System.out.println("Connecting to " + uri);

//            Endpoint endpoint = new Endpoint() {
//
//                @Override
//                public void onOpen(Session session, EndpointConfig config) {
//                    session.addMessageHandler(new MessageHandler.Whole<String>() {
//                        @Override
//                        public void onMessage(String content) {
//                            System.out.println(content);
//                        }
//                    });
//                }
//            };
//
//            ClientEndpointConfig.Configurator configurator = new ClientEndpointConfig.Configurator() {
//                public void beforeRequest(Map<String, List<String>> headers) {
//                    headers.put("Authorization", asList("Basic " + printBase64Binary("Tomitribe:tomee".getBytes())));
//                }
//            };
//
//            ClientEndpointConfig authorizationConfiguration = ClientEndpointConfig.Builder.create()
//                    .configurator(configurator)
//                    .build();

//            container.connectToServer(endpoint, authorizationConfiguration, URI.create(uri));

              container.connectToServer(MyClientEndpoint.class, URI.create(uri));
            messageLatch.await(100, TimeUnit.SECONDS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
