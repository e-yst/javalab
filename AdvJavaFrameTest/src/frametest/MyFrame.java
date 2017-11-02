/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frametest;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {

    Point begin, current;
    boolean dragging;

    public MyPanel() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                dragging = true;
                begin = new Point(mouseEvent.getX(), mouseEvent.getY());
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                dragging = false;
                current = new Point(mouseEvent.getX(), mouseEvent.getY());
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                current = new Point(mouseEvent.getX(), mouseEvent.getY());
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (begin != null && current != null) {
            //set stroke to dashed line if dragging mode
            int width = Math.abs((int) current.getX() - (int) begin.getX());
            int height = Math.abs((int) current.getY() - (int) begin.getY());
            int x = (int) Math.min(begin.getX(), current.getX());
            int y = (int) Math.min(begin.getY(), current.getY());
            if (dragging) {
                float dash1[] = {10.0f};
                BasicStroke dashed =
                        new BasicStroke(1.0f,
                                BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_MITER,
                                10.0f, dash1, 0.0f);
                ((Graphics2D) g).setStroke(dashed);
            } else {
                ((Graphics2D) g).setStroke(new BasicStroke(2));
            }
            g.drawRect(x, y, width, height);
        }
    }
}

/**
 * @author borson
 */
public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);
//		add(new JLabel("HELLO"));
//		this.getContentPane()
//		add(new JLabel("HI"));
//		add(new MyPanel());
    }
}
