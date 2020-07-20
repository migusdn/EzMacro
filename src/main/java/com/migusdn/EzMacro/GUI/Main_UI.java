package com.migusdn.EzMacro.GUI;

import com.migusdn.EzMacro.App.Window;
import com.migusdn.EzMacro.Util.GUI_Utility;

import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_UI implements GUI{
    private JPanel panel1;
    private JButton newMacroButton;
    private JButton importMacroButton;
    //url valid check
    private String regex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";

    public Main_UI() {
        newMacroButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String target_url=JOptionPane.showInputDialog("Target Url");
                while(!Pattern.matches(regex,target_url)) {
                    JOptionPane.showMessageDialog(null,"Please enter a valid url.");
                    target_url = JOptionPane.showInputDialog("Target Url");
                }
                JFrame frame = Window.getFrame();
                frame.setTitle("New Macro");
                TaskList_UI task =  new TaskList_UI();
                GUI_Utility.change(task);
                task.setTarget_url(target_url);
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
