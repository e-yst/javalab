import javax.swing.*;
import java.awt.*;

public class TryGridbagLayout extends JFrame{
    public TryGridbagLayout() throws HeadlessException {
        createView();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
//        setResizable(false);
    }

    private void createView() {
        JPanel panelMain = new JPanel();
        getContentPane().add(panelMain);

        JPanel panelForm = new JPanel(new GridBagLayout());
        panelMain.add(panelForm);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;

        c.anchor = GridBagConstraints.LINE_END;
        panelForm.add(new JLabel("First Name: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Last Name: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Email: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Username: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Password: "), c);

        c.gridx = 1;
        c.gridy = 0;

        c.anchor = GridBagConstraints.LINE_START;
        panelForm.add(new JTextField(8), c);
        c.gridy++;
        panelForm.add(new JTextField(8), c);
        c.gridy++;
        panelForm.add(new JTextField(15), c);
        c.gridy++;
        panelForm.add(new JTextField(10), c);
        c.gridy++;
        panelForm.add(new JTextField(10), c);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TryGridbagLayout().setVisible(true));
    }
}
