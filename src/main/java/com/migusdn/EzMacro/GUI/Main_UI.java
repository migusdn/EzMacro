package com.migusdn.EzMacro.GUI;

import com.migusdn.EzMacro.App.Window;
import com.migusdn.EzMacro.Macro.Task;
import com.migusdn.EzMacro.Util.GuiUtility;
import com.migusdn.EzMacro.Util.JsonUtility;
import com.migusdn.EzMacro.Util.ValidationUtility;
import com.sun.codemodel.internal.JOp;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;

public class Main_UI implements GUI{
    private JPanel panel1;
    private JButton newMacroButton;
    private JButton importMacroButton;
    private JFileChooser chooser;
    public Main_UI() {
        chooser = new JFileChooser();
        newMacroButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String target_url=JOptionPane.showInputDialog("Target Url");
                while(!ValidationUtility.urlCheck(target_url)) {
                    JOptionPane.showMessageDialog(null,"Please enter a valid url.");
                    target_url = JOptionPane.showInputDialog("Target Url");
                }
                JFrame frame = Window.getFrame();
                frame.setTitle("New Macro");
                TaskList_UI taskListUi =  new TaskList_UI();
                GuiUtility.change(taskListUi);
                taskListUi.setTarget_url(target_url);
            }
        });
        importMacroButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        ".side files","side"
                );
                chooser.setFileFilter(filter);
                int ret = chooser.showOpenDialog(null);
                if(ret!=JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(null,"파일을 선택해주세요.","경고",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String filePath = chooser.getSelectedFile().getPath();
                Task importTask = JsonUtility.ImportFile(filePath);
                TaskList_UI task =  new TaskList_UI();
                GuiUtility.change(task);
                task.setTarget_url(importTask.getTarget_url());
                task.setElementList(importTask.getTaskList());

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
