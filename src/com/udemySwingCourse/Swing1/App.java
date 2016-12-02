package com.udemySwingCourse.Swing1;

import javax.swing.*;

/**
 * Created by everduin on 12/2/2016.
 */
public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() { //Anonymous Class
            @Override
            public void run() {

            }
        });

        JFrame frame = new JFrame("Hello");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
