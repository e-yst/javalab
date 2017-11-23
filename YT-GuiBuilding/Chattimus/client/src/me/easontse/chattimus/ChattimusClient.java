package me.easontse.chattimus;

import me.easontse.chattimus.network.NetworkClient;

import javax.swing.*;
import java.awt.*;

public class ChattimusClient extends JFrame {
    public static final String TITLE = "Chattimus Client";
    public static ChattimusClient instance;

    // List of users connected
    private JList listUsers;

    // Chat text
    private JTextPane textChat;

    // User input
    private JTextField fieldInput;
    private JButton buttonSend;

    // Network client object (networking module)
    private NetworkClient client;

    public ChattimusClient() throws HeadlessException {
        createView();
        client = new NetworkClient("127.0.0.1", 10500);
        client.connectToServer();

        setTitle(TITLE);
        setSize(600, 500);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        listUsers = new JList();
        JScrollPane listUsersSP = new JScrollPane(listUsers);
        listUsersSP.setPreferredSize(new Dimension(200, 0));
        panel.add(listUsersSP, BorderLayout.EAST);

        JPanel panelChat = new JPanel(new BorderLayout());
        panel.add(panelChat, BorderLayout.CENTER);

        textChat = new JTextPane();
        textChat.setEditable(false);
        JScrollPane textChatSP = new JScrollPane(textChat);
        panelChat.add(textChatSP, BorderLayout.CENTER);

        JPanel panelInput = new JPanel(new BorderLayout());
        panel.add(panelInput, BorderLayout.SOUTH);
        fieldInput = new JTextField();
        panelInput.add(fieldInput, BorderLayout.CENTER);
        buttonSend = new JButton("Send");
        buttonSend.addActionListener(e -> {
            //TODO send chat msg to server
        });
        panelInput.add(buttonSend, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            instance = new ChattimusClient();
            instance.setVisible(true);
        });
    }
}
