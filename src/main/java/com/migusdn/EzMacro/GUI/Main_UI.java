package com.migusdn.EzMacro.GUI;

import com.migusdn.EzMacro.App.Window;
import com.migusdn.EzMacro.Util.GUI_Utility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_UI implements GUI{
    private JPanel panel1;
    private JButton newMacroButton;
    private JButton importMacroButton;
//    private JFrame MainFrame = new JFrame("App");
    public Main_UI() {
        newMacroButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                JFrame frame = Window.getFrame();
                GUI_Utility.change(new TaskList_UI());
            }
        });
    }
    public void validate(){
        JFrame frame = Window.getFrame();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.revalidate();
    }

}
