package com.migusdn.EzMacro.GUI;

import com.migusdn.EzMacro.App.Window;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class TaskList_UI implements GUI{


    private JPanel panel1;
    private JList list1;

    public TaskList_UI() {
    }
    public void validate(){
        JFrame frame = Window.getFrame();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.revalidate();
    }
}
