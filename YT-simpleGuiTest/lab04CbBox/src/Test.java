import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {

    private String[] items = {"Peter", "Mary", "John", "Happy", "Joyce"};
    private JComboBox cbx = new JComboBox(items);
    private JButton btn = new JButton("Print");
    private JLabel lbl = new JLabel("Display Combo item");

    public Test() {
        frame();
    }

    private void frame() {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.add(cbx);
        p.add(btn);
        p.add(lbl);

        f.add(p);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = cbx.getSelectedItem().toString();
                lbl.setText(s);
            }
        });
    }

    public static void main(String[] args) {
        new Test();
    }
}
