import javax.swing.*;
import java.awt.*;

public class TryFlowLayout extends JFrame {


    public TryFlowLayout() throws HeadlessException {
        createView();
        setTitle("FlowLayout Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panel = new JPanel(new FlowLayout());
        getContentPane().add(panel);

        JLabel label1 = new JLabel("Username: ");
        panel.add(label1);

        JTextField fieldUsername = new JTextField(20);
        panel.add(fieldUsername);

        JLabel label2 = new JLabel("Password: ");
        panel.add(label2);

        JTextField fieldPassword = new JTextField(20);
        panel.add(fieldPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TryFlowLayout().setVisible(true));
    }
}
