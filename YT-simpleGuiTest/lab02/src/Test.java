package lab02;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridBagLayout());
        JButton btn1 = new JButton("Button 1");
        JButton btn2 = new JButton("Button 2");

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        p.add(btn1, c);
        c.gridx = 0;
        c.gridy = 2;
        p.add(btn2);

        f.add(p, BorderLayout.WEST);
    }
}
