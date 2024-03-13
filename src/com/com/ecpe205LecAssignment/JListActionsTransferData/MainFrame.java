package com.ecpe205LecAssignment.JListActionsTransferData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    JTextField taskField;
    JButton addButton, transferButton;
    JList sourceList, destinationList;
    SourceListModel sourceListModel;
    DestinationListModel destinationListModel;
    JPanel jlistPanel;
    String[] values = new String[]{
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5"
    };
    public MainFrame(){
        init();
    }
    private void init(){
        setTitle("Task Manager by Dave Chavez");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(122,138,153,100)));

        sourceListModel = new SourceListModel();
        sourceList = new JList(sourceListModel);
        destinationListModel = new DestinationListModel();
        destinationList = new JList(destinationListModel);
        addComponent(new JLabel("Task Name:"), 0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        addComponent(taskField = new JTextField(10), 1, 0, 2, 1, 1, 0, GridBagConstraints.HORIZONTAL);
        addComponent(addButton = new JButton("Add"), 0, 1, 3, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(jlistPanel = new JPanel(new FlowLayout()),0,2,3,1,1,1,GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        jlistPanel.setBorder(BorderFactory.createLineBorder(new Color(122,138,153,100)));
        jlistPanel.add(new JScrollPane(sourceList));
        jlistPanel.add(transferButton = new JButton("T"));
        jlistPanel.add(new JScrollPane(destinationList));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToTask();
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferTask();
            }
        });
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    private void addToTask(){
        String taskname = taskField.getText().trim();

        Task task = new Task(taskname);

        if(!taskname.isEmpty() && !sourceListModel.equals(taskname)){
            sourceListModel.addElement(task);
            taskField.setText("");
            sourceList.updateUI();
        }
        else {
            JOptionPane.showMessageDialog(null, "Task name is empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        taskField.requestFocus();
        sourceList.clearSelection();
    }
    private void transferTask(){
        int[] indices = sourceList.getSelectedIndices();

        ArrayList <Task> tasksToTransfer = new ArrayList<>();

        if(indices.length >= 1){
            for(int i = indices.length - 1; i >= 0; i--){
                Task task = (Task) sourceListModel.getElementAt(indices[i]);
                tasksToTransfer.add(task);
                sourceListModel.removeElementAt(indices[i]);
            }
            for(Task task : tasksToTransfer){
                destinationListModel.addElement(task);
            }
        }
        sourceList.updateUI();
        sourceList.clearSelection();
        destinationList.updateUI();
    }
    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY, int fill){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
    }
    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY, int fill, int anchor){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
    }
}
