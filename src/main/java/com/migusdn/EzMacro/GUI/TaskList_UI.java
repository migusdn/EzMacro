package com.migusdn.EzMacro.GUI;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.migusdn.EzMacro.App.Window;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class TaskList_UI implements GUI{

    public static DefaultListModel test;
    private JPanel panel1;
    private JPanel actionList;
    private JPanel options;
    private JList List;

    public void validate(){
        JFrame frame = Window.getFrame();
        test = (DefaultListModel)List.getModel();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setSize(1024,512);
        frame.setVisible(true);
        frame.revalidate();
    }

}
