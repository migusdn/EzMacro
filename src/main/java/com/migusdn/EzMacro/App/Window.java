package com.migusdn.EzMacro.App;

import com.migusdn.EzMacro.GUI.Main_UI;
import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;

public class Window implements Runnable{
    //singleton frame
    private static JFrame frame = new JFrame("EzMacro");

    public static JFrame getFrame(){ return frame;}
    @Override
    public void run(){
        new Main_UI().validate();
        frame.setVisible(true);
//        JFrame MainFrame = new JFrame("App");
//        MainFrame.setContentPane(panel1);
//        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        MainFrame.pack();
//        MainFrame.setVisible(true);
    }
    public void test(String text){
        new JOptionPane().showMessageDialog(null,text);
    }
}
