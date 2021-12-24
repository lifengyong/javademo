package com.neu.websocket.demo.common.client;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Map;

public class Client extends WebSocketClient {

  public Client(URI serverUri, Draft draft) {
    super(serverUri, draft);
  }

  public Client(URI serverURI) {
    super(serverURI);
  }

  public Client(URI serverUri, Map<String, String> httpHeaders) {
    super(serverUri, httpHeaders);
  }

  @Override
  public void onOpen(ServerHandshake handshakedata) {
    send("{\"msg\":\"formclient\"}");
    System.out.println("opened connection");
  }

  @Override
  public void onMessage(String message) {
    System.out.println("received: " + message);
  }

  @Override
  public void onMessage(ByteBuffer byteBuffer) {
    System.out.println("received: bytebuffer" );
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
    System.out.println(
        "Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: "
            + reason);
  }

  @Override
  public void onError(Exception ex) {
    ex.printStackTrace();
  }

  public static void main(String[] args) throws URISyntaxException {
    Client c = new Client(new URI("ws://localhost:10001/ws-demo/websocket/abc"));
    c.connect();
  }

}