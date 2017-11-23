import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryTextfieldInput extends JFrame {
    private JTextField fieldName;
    private JLabel lblMsg;
    private JButton btnSubmit;

    public TryTextfieldInput() throws HeadlessException {
        createView();
        setTitle("TryTextfieldInput");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel lbl = new JLabel("Please enter your name: ");
        panel.add(lbl);

        fieldName = new JTextField();
        fieldName.setPreferredSize(new Dimension(150, 30));
        panel.add(fieldName);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {
            String name = fieldName.getText();
            if (name.isEmpty()) {
                lblMsg.setText("Your name can't be nothing.");
            } else {
                lblMsg.setText("Hello there, " + name + ". How are you?");
            }
        });

        panel.add(btnSubmit);

        lblMsg = new JLabel("Please enter your name!");
        panel.add(lblMsg);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TryTextfieldInput().setVisible(true));
    }

}
