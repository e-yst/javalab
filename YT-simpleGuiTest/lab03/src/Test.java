import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {

    public Test() {
        frame();
    }

    public void frame() {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JButton btn1 = new JButton("Action Listener");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Action Listening is working!");
            }
        });

        p.add(btn1);
        f.add(p);
    }


    public static void main(String[] args) {
        new Test();
    }
}
