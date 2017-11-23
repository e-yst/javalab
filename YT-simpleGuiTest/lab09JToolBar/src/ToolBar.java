import javax.swing.*;
import java.awt.*;

public class ToolBar extends JFrame {

    private JToolBar tb;
    private JButton exit;

    public ToolBar() throws HeadlessException {
        setSize(400, 400);
        setTitle("ToolBar test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tb = new JToolBar();
        exit = new JButton("Exit");

        tb.add(exit);
        tb.setFloatable(false);
        add(tb, BorderLayout.NORTH);

        exit.addActionListener(e -> this.dispose());
    }

    public static void main(String[] args) {
        ToolBar t = new ToolBar();
        t.setVisible(true);
    }
}
