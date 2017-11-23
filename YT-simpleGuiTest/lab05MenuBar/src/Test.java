import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        mb.add(file);
        JMenu edit = new JMenu("Edit");
        mb.add(edit);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);

        f.setJMenuBar(mb);
    }
}
