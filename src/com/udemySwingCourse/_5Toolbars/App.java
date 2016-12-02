package com.udemySwingCourse._5Toolbars;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
    /*Goal, place button in toolbar (5)*/
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }

}
