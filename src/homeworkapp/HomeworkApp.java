/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworkapp;

import javax.swing.*;

/**
 *
 * @author Michał, Janek, Wojtek
 */
public class HomeworkApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                SimpleGUI g = new SimpleGUI();
                g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                g.setVisible(true);
                g.setResizable(false);
            }
        });

    }

}
