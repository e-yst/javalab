import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    JFrame f = new JFrame("Main Frame");
    JFrame f2 = new JFrame("Sub Frame");

    public Test() {
        gui();
    }

    private void gui() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(600, 400);
        f.setLocationRelativeTo(null);

        f2.setSize(300,300);
        f2.setLocationRelativeTo(null);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mb = new JMenuBar();
        JMenu open = new JMenu("Open");
        mb.add(open);
        JMenuItem frame = new JMenuItem("Open Frame");
        open.add(frame);

        f.setJMenuBar(mb);

        frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);
                f.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Test();
    }
}
