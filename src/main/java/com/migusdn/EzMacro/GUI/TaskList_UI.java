package com.migusdn.EzMacro.GUI;

import com.migusdn.EzMacro.App.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskList_UI implements GUI{

    public static DefaultListModel listModel;
    private JPanel panel1;
    private JPanel actionList;
    private JPanel options;
    private JList List;
    private JRadioButton doubleClickRadioButton;
    private JRadioButton sendKeyRadioButton;
    private JRadioButton sendStringRadioButton;
    private JTextField textField1;
    private JButton addButton;
    private JRadioButton clickRadioButton;
    private JButton resetButton;
    private JButton runButton;

    public TaskList_UI() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void validate(){
        JFrame frame = Window.getFrame();
        listModel = (DefaultListModel)List.getModel();
        frame.setContentPane(panel1);
        frame.pack();
        frame.setSize(1024,512);
        frame.setVisible(true);
        frame.revalidate();
    }

}
