package com.migusdn.EzMacro.GUI;

import com.migusdn.EzMacro.App.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TaskList_UI implements GUI{
    public static DefaultListModel listModel;
    private static ButtonGroup jRadioButtonGroup;
    private static boolean flag = false;
    private JPanel panel1;
    private JPanel actionList;
    private JPanel options;
    private JList List;
    private JRadioButton doubleClickRadioButton;
    private JRadioButton sendKeyRadioButton;
    private JRadioButton sendStringRadioButton;
    private JRadioButton clickRadioButton;
    private JTextField target;
    private JButton addButton;
    private JButton resetButton;
    private JButton runButton;
    private JButton deleteButton;
    private JLabel Target_URL;

    public TaskList_UI() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        target.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if(!flag) {
                    flag = true;
                    target.setText("");
                }
            }
        });

        //AddButton
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(flag);
                if(flag&&!target.getText().equals("")) {
                    listModel.addElement(target.getText());
                    target.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "input valid value.");

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(List.getSelectedIndex());
                listModel.remove(List.getSelectedIndex());
            }
        });
    }

    @Override
    public void validate(){
        JFrame frame = Window.getFrame();
        //listModel init
        listModel = (DefaultListModel)List.getModel();

        //Radio ButtonGroup
        jRadioButtonGroup = new ButtonGroup();
        doubleClickRadioButton.setActionCommand("doubleclick");
        jRadioButtonGroup.add(doubleClickRadioButton);
        sendKeyRadioButton.setActionCommand("sendkey");
        jRadioButtonGroup.add(sendKeyRadioButton);
        sendStringRadioButton.setActionCommand("sendstring");
        jRadioButtonGroup.add(sendStringRadioButton);
        clickRadioButton.setActionCommand("click");
        jRadioButtonGroup.add(clickRadioButton);

        frame.setContentPane(panel1);
        frame.pack();
        //frame size
        frame.setSize(1024,512);
        frame.setVisible(true);
        frame.revalidate();
    }
    public void setTarget_url(String target_url){
        this.Target_URL.setText(target_url);
    }
}
