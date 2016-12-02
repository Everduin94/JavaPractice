package com.udemySwingCourse.Swing2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               // new gui.MainFrame();
            }
        });
    }

}
