package me.easontse.chattimus;

import me.easontse.chattimus.network.NetworkServer;

import javax.swing.*;
import java.awt.*;

public class ChattimusServer extends JFrame {

    public static final String TITLE = "Chattimus Server";
    private static ChattimusServer instance;

    private NetworkServer server;

    private JTextPane console;
    private JList listUsers;

    public ChattimusServer() throws HeadlessException {
        createView();

        server = new NetworkServer(10500);
        server.startServer();

        setTitle(TITLE);
        setSize(500, 400);
        setResizable(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BorderLayout());

        console = new JTextPane();
        console.setEditable(false);
        JScrollPane consoleSP = new JScrollPane(console);
        consoleSP.setBorder(BorderFactory.createTitledBorder("Console Output"));
        panel.add(consoleSP, BorderLayout.CENTER);

        listUsers = new JList();
        JScrollPane listUsersSP = new JScrollPane(listUsers);
        listUsersSP.setBorder(BorderFactory.createTitledBorder("Connected Users"));
        listUsersSP.setPreferredSize(new Dimension(200, 0));
        panel.add(listUsersSP, BorderLayout.EAST);
    }

    public static ChattimusServer getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            instance = new ChattimusServer();
            instance.setVisible(true);
        });
    }
}
