package me.easontse.chattimus.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {

    private ServerSocket socket;
    private boolean running = false;
    private int port;

    public NetworkServer(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        new Thread(() -> {
            while (running) {
                try {
                    System.out.println("Server is listening at " + port);
                    Socket client = socket.accept();
                    System.out.println("A Client has connected: " + client);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        running = true;
    }

    private void stopServer() {

    }
}
