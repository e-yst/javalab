import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TryBorderLayout extends JFrame {
    private JButton buttonSubmit, buttonClear;
    private JTextField fieldMsg;
    private JTextArea textArea;
    private JLabel labelCounter;
    private int lineCounter = 0;

    public TryBorderLayout() throws HeadlessException {
        createView();
        setTitle("Text Area with BorderLayout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // North
        JPanel panelNorth = new JPanel(new BorderLayout());
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(new JLabel("Enter a message: "), BorderLayout.WEST);

        fieldMsg = new JTextField();
        panelNorth.add(fieldMsg);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(e -> {
            textArea.append(fieldMsg.getText() + "\n");
            lineCounter++;
            updateCounter();
        });
        panelNorth.add(buttonSubmit, BorderLayout.EAST);
        //


        // Center
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        //


        // South
        JPanel panelSouth = new JPanel(new BorderLayout());
        panel.add(panelSouth, BorderLayout.SOUTH);

        buttonClear = new JButton("Clear Text");
        buttonClear.addActionListener(e -> {
            textArea.setText("");
            lineCounter = 0;
            updateCounter();
        });
        panelSouth.add(buttonClear, BorderLayout.CENTER);

        labelCounter = new JLabel("");
        updateCounter();
        panelSouth.add(labelCounter, BorderLayout.WEST);


        //

    }

    private void updateCounter() {
        labelCounter.setText("Counter: " + lineCounter);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TryBorderLayout().setVisible(true));
    }
}
