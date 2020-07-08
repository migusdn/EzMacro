package com.migusdn.EzMacro.App;

import com.migusdn.EzMacro.GUI.Main_UI;

import javax.swing.*;

public class GUI_Thread implements Runnable {
    public void run(){
        JFrame MainFrame = new JFrame("App");
        MainFrame.setContentPane(new Main_UI().getPanel1());
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.pack();
        MainFrame.setVisible(true);
        for(int i=0; i<10; i++) {
            System.out.println("Thread is run!");

        }
    }
}
