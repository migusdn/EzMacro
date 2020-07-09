package com.migusdn.EzMacro.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_UI implements Runnable {
    private JPanel panel1;
    private JButton newMacroButton;
    private JButton importMacroButton;
    public Main_UI() {
        newMacroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    @Override
    public void run(){
        JFrame MainFrame = new JFrame("App");
        MainFrame.setContentPane(new Main_UI().panel1);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.pack();
        MainFrame.setVisible(true);

    }
}
