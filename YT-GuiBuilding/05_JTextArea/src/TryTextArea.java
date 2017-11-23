import javax.swing.*;
import java.awt.*;

public class TryTextArea extends JFrame {

    private JTextArea textArea;
    private JButton buttonClear;
    private JTextField fieldMessage;
    private JButton buttonSumbit;


    public TryTextArea() throws HeadlessException {
        createView();
        setTitle("Text Area Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // initialize all GUI components
    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel label = new JLabel("Enter some text: ");
        panel.add(label);

        fieldMessage = new JTextField(12);
        panel.add(fieldMessage);

        buttonSumbit = new JButton("Submit");
        buttonSumbit.addActionListener(e -> {
            String message = fieldMessage.getText();
            textArea.append(message + "\n");
            fieldMessage.setText("");
        });
        panel.add(buttonSumbit);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 90));
        panel.add(scrollPane);

        buttonClear = new JButton("Clear Text Area");
        buttonClear.addActionListener(e -> textArea.setText(""));
        panel.add(buttonClear);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TryTextArea().setVisible(true));
    }
}
