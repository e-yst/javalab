import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryClickMe extends JFrame {

    private JButton btnCounter, btnReset;
    private JLabel lblCount;
    private int clicks = 0;

    public TryClickMe() throws HeadlessException {
        createView();
        setTitle("Try Click Me!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        lblCount = new JLabel("");
        lblCount.setPreferredSize(new Dimension(200, 30));
        panel.add(lblCount);
        updateCounter();

        btnCounter = new JButton("Click me");
        btnCounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                updateCounter();
            }
        });
        panel.add(btnCounter);

        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks = 0;
                updateCounter();
            }
        });
        panel.add(btnReset);
    }

    private void updateCounter() {
        lblCount.setText("Clicked " + clicks + " times.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TryClickMe().setVisible(true);
            }
        });
    }
}
