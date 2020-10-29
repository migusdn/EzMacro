package com.migusdn.EzMacro.GUI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.migusdn.EzMacro.App.Window;
import com.migusdn.EzMacro.Enum.Command;
import com.migusdn.EzMacro.Macro.Task;
import com.migusdn.EzMacro.Macro.TaskElement;
import com.migusdn.EzMacro.Util.SeleniumUtility;
import com.migusdn.EzMacro.Util.ValidationUtility;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

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
    @Setter
    private JLabel Target_URL;
    private JButton changeButton;
    private JRadioButton changeFrameRadioButton;
    private JComboBox comboBox1;
    private ArrayList<TaskElement> elementList = new ArrayList<TaskElement>();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public void setElementList(ArrayList<TaskElement> TElement){
        this.elementList = TElement;
        for(int i=0; i<elementList.size();i++){
            listModel.addElement(elementList.get(i));
        }
    }
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
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(flag);
                if(flag&&!target.getText().equals("")) {
                    TaskElement taskElement = new TaskElement();
                    taskElement.setCommand(Command.valueOf(jRadioButtonGroup.getSelection().getActionCommand()));
                    taskElement.setTarget(target.getText());
                    elementList.add(taskElement);
                    listModel.addElement(objectMapper.writeValueAsString(taskElement));
                    target.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "input valid value.");

            }
        });
        //Reset Button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeAllElements();
                elementList.clear();
            }
        });

        //Delete Button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(List.getSelectedIndex());
                elementList.remove(List.getSelectedIndex());
                listModel.remove(List.getSelectedIndex());
            }
        });
        //Run Button
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = new Task(Target_URL.getText(), elementList);
                new SeleniumUtility(task).run();
            }
        });
        //ChangeUrl
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String target_url=JOptionPane.showInputDialog("Target Url");
                while(!ValidationUtility.urlCheck(target_url)) {
                    if(target_url== null) { return; }
                    JOptionPane.showMessageDialog(null,"Please enter a valid url.");
                    target_url = JOptionPane.showInputDialog("Target Url");
                }
                Target_URL.setText(target_url);
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
        doubleClickRadioButton.setActionCommand("doubleClick");
        jRadioButtonGroup.add(doubleClickRadioButton);
        sendKeyRadioButton.setActionCommand("sendKey");
        jRadioButtonGroup.add(sendKeyRadioButton);
        sendStringRadioButton.setActionCommand("sendString");
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
