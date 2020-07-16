package com.migusdn.EzMacro.App;

import com.migusdn.EzMacro.GUI.Main_UI;
import com.migusdn.EzMacro.GUI.TaskList_UI;

import javax.swing.*;

public class Window implements Runnable{
    //singleton frame
    private static JFrame frame = new JFrame("EzMacro");

    public static JFrame getFrame(){ return frame;}
    @Override
    public void run(){
        new Main_UI().validate();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void test(String text){
        if(frame.getTitle().equals("New Macro")) {
//            new JOptionPane().showMessageDialog(null, text);
            TaskList_UI.listModel.addElement(text);
        }
    }
}
