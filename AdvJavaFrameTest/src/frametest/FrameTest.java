/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frametest;

import javax.swing.JFrame;

/**
 *
 * @author borson
 */
public class FrameTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frametest.MyFrame frame = new frametest.MyFrame("MyAPP");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(new frametest.MyPanel());

        System.out.println("main exited ....");
    }

}
