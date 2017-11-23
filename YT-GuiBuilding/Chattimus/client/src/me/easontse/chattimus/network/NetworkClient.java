package me.easontse.chattimus.network;

import java.io.IOException;
import java.net.Socket;

public class NetworkClient {

    private Socket socket;
    private String ipAddr;
    private int serverPort;

    public NetworkClient(String ipAddr, int serverPort) {
        this.ipAddr = ipAddr;
        this.serverPort = serverPort;
    }

    public void connectToServer() {
        try {
            socket = new Socket(ipAddr, serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        new Thread(() -> {
           while (true) {

           }
        }).start();
    }
}
