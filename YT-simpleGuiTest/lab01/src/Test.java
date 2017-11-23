import java.awt.*;
import javax.swing.*;

public class Test {
    private JFrame f;
    private JPanel p;
    private JButton btn;
    private JLabel lbl;

    public Test () {
        gui();
    }

    public void gui() {
        f = new JFrame("My test frame");
        f.setSize(new Dimension(600, 400));
        f.setVisible(true);
//        f.setSize(600, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.YELLOW);

        btn = new JButton("lab01.Test");
        lbl = new JLabel("lab01.Test is test label");

        p.add(btn);
        p.add(lbl);

        f.add(p);
    }

    public static void main(String[] args) {
        new Test();
    }
}
