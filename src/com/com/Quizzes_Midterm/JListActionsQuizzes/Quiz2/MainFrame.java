package com.Quizzes_Midterm.JListActionsQuizzes.Quiz2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    JTextField taskNameField, taskAssignedToField;
    JButton addButton, transferTodoDoing, transferBackDoingTodo,
            transferDoingDone, transferDoneDoing,
            clear1, clear2, clear3;
    JList todoList, doingList, doneList;
    TodoListModel todoListModel;
    DoingListModel doingListModel;
    DoneListModel doneListModel;

    JScrollPane todoScrollPane, doingScrollPane, doneScrollPane;

    public MainFrame() {
        init();
    }
    private void init(){
        setTitle("Task Manager by Dave Chavez     ENCE 2A     QUIZ#2(JListActions)     Feb.21, 2023");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        todoListModel = new TodoListModel();
        doingListModel = new DoingListModel();
        doneListModel = new DoneListModel();

        todoList = new JList(todoListModel);
        doingList = new JList(doingListModel);
        doneList = new JList(doneListModel);


        todoScrollPane = new JScrollPane(todoList);
        doingScrollPane = new JScrollPane(doingList);
        doneScrollPane = new JScrollPane(doneList);


        addComponent(new JLabel("Task Name:"),0,0,1,1,0,0,GridBagConstraints.NONE,GridBagConstraints.LINE_START);
        addComponent(taskNameField = new JTextField(15),1,0,4,1,0,0,GridBagConstraints.HORIZONTAL);
        addComponent(new JLabel("Assigned To:"),0,1,1,1,0,0,GridBagConstraints.NONE,GridBagConstraints.LINE_START);
        addComponent(taskAssignedToField = new JTextField(15),1,1,4,1,0,0,GridBagConstraints.HORIZONTAL);
        addComponent(addButton = new JButton("Add"),0,2,5,1,0,0,GridBagConstraints.NONE, GridBagConstraints.CENTER);

        addComponent(panel(),0,3,5,1,1,1,GridBagConstraints.BOTH, GridBagConstraints.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
                todoList.setCellRenderer( new CellRenderer());
            }
        });

        transferTodoDoing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!todoList.isSelectionEmpty()) {
                    transferTaskTodoDoing();
                    doingList.setCellRenderer( new CellRenderer());
                } else {
                    JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        transferBackDoingTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!doingList.isSelectionEmpty()) {
                    transferTaskDoingTodo();
                    todoList.setCellRenderer( new CellRenderer());
                } else {
                    JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        transferDoingDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!doingList.isSelectionEmpty()) {
                    transferTaskDoingDone();
                    doneList.setCellRenderer( new CellRenderer());
                } else {
                    JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        transferDoneDoing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!doneList.isSelectionEmpty()) {
                    transferTaskDoneDoing();
                    doingList.setCellRenderer( new CellRenderer());
                } else {
                    JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

                clear1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int [] selectedIndices = todoList.getSelectedIndices();
                        if(!todoList.isSelectionEmpty()) {
                            for (int i = selectedIndices.length - 1; i >= 0; i--) {
                                todoListModel.removeElementAt(selectedIndices[i]);
                            }
                            todoList.updateUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);

                        }

                    }
        });

                clear2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int [] selectedIndices = doingList.getSelectedIndices();

                        if(!doingList.isSelectionEmpty()){
                        for(int i = selectedIndices.length - 1; i>= 0; i--) {
                            doingListModel.removeElementAt(selectedIndices[i]);
                        }
                            doingList.updateUI();
                        } else{
                            JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);
                        }

            }
        });

        clear3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int [] selectedIndices = doneList.getSelectedIndices();

                if(!doneList.isSelectionEmpty()){

                for(int i = selectedIndices.length - 1; i>= 0; i--) {
                    doneListModel.removeElementAt(selectedIndices[i]);
                }
                    doneList.updateUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Nothing is selected.", "Error!", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1000,500));
    }

    private JPanel panel(){
        JPanel componentPanel = new JPanel(new GridBagLayout());

        todoScrollPane.setBorder(componentBorder("To do"));
        addConstraints(componentPanel, todoScrollPane,0,0,1,5,0,1,GridBagConstraints.VERTICAL);
        addConstraints(componentPanel, transferTodoDoing = new JButton(">"),1,3,1,1,1,1,GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addConstraints(componentPanel, transferBackDoingTodo = new JButton("<"),1,4,1,1,1,1,GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addConstraints(componentPanel, clear1 = new JButton("Clear"),0,6,1,1,1,1, GridBagConstraints.HORIZONTAL);

        doingScrollPane.setBorder(componentBorder("Doing"));
        addConstraints(componentPanel, doingScrollPane,2,0,1,5,0,1,GridBagConstraints.VERTICAL);
        addConstraints(componentPanel, transferDoingDone = new JButton(">"),3,3,1,1,0,0,GridBagConstraints.NONE);
        addConstraints(componentPanel, transferDoneDoing = new JButton("<"),3,4,1,1,0,0,GridBagConstraints.NONE);
        addConstraints(componentPanel, clear2 = new JButton("Clear"),2,6,1,1,1,1, GridBagConstraints.HORIZONTAL);

        doneScrollPane.setBorder(componentBorder("Done"));
        addConstraints(componentPanel, doneScrollPane,4,0,1,5,0,1,GridBagConstraints.VERTICAL);
        addConstraints(componentPanel, clear3 = new JButton("Clear"),4,6,1,1,1,1,GridBagConstraints.HORIZONTAL);


        return componentPanel;
    }

    private void addTask(){
        String taskname = taskNameField.getText().trim();
        String taskAssignedTo = taskAssignedToField.getText().trim();

        Task task = new Task(taskname, taskAssignedTo);

        if(!taskname.isEmpty() && !taskAssignedTo.isEmpty()){
                todoListModel.addElement(task);
                taskNameField.setText("");
                taskAssignedToField.setText("");
                todoList.updateUI();
        }
        else{
            JOptionPane.showMessageDialog(null, "Task name is empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        taskNameField.requestFocus();
        todoList.clearSelection();
    }

    private void transferTaskTodoDoing(){
        int[] indices = todoList.getSelectedIndices();

        ArrayList<Task> tasksToTransfer = new ArrayList<>();

        if(indices.length >= 1){
            for(int i = indices.length - 1; i >= 0; i--){
                Task task = (Task) todoListModel.getElementAt(indices[i]);
                tasksToTransfer.add(task);
                todoListModel.removeElementAt(indices[i]);
            }
            for(int i = indices.length - 1; i >= 0; i--)
            {
                Task task = tasksToTransfer.get(i);
                doingListModel.addElement(task);
            }
        }
        todoList.updateUI();
        todoList.clearSelection();
        doingList.updateUI();
    }

    private void transferTaskDoingTodo(){
        int[] indices = doingList.getSelectedIndices();

        ArrayList<Task> tasksToTransfer = new ArrayList<>();

        if(indices.length >= 1){
            for(int i = indices.length - 1; i >= 0; i--){
                Task task = (Task) doingListModel.getElementAt(indices[i]);
                tasksToTransfer.add(task);
                doingListModel.removeElementAt(indices[i]);
            }
            for(int i = indices.length - 1; i >= 0; i--)
            {
                Task task = tasksToTransfer.get(i);
                todoListModel.addElement(task);
            }
        }
        todoList.updateUI();
        doingList.clearSelection();
        doingList.updateUI();
    }

    private void transferTaskDoingDone(){
        int[] indices = doingList.getSelectedIndices();

        ArrayList<Task> tasksToTransfer = new ArrayList<>();

        if(indices.length >= 1){
            for(int i = indices.length - 1; i >= 0; i--){
                Task task = (Task) doingListModel.getElementAt(indices[i]);
                tasksToTransfer.add(task);
                doingListModel.removeElementAt(indices[i]);
            }
            for(int i = indices.length - 1; i >= 0; i--)
            {
                Task task = tasksToTransfer.get(i);
                doneListModel.addElement(task);
            }
        }
        doingList.updateUI();
        doingList.clearSelection();
        doneList.updateUI();
    }
    private void transferTaskDoneDoing(){
        int[] indices = doneList.getSelectedIndices();

        ArrayList<Task> tasksToTransfer = new ArrayList<>();

        if(indices.length >= 1){
            for(int i = indices.length - 1; i >= 0; i--){
                Task task = (Task) doneListModel.getElementAt(indices[i]);
                tasksToTransfer.add(task);
                doneListModel.removeElementAt(indices[i]);
            }
            for(int i = indices.length - 1; i >= 0; i--)
            {
                Task task = tasksToTransfer.get(i);
                doingListModel.addElement(task);
            }
        }
        doneList.updateUI();
        doneList.clearSelection();
        doingList.updateUI();
    }

    private TitledBorder componentBorder(String title){
        TitledBorder titledBorder = new TitledBorder(title);
        titledBorder.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        return titledBorder;
    }

    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
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
    public void addConstraints(JPanel panel, Component component, int x, int y, int gridWidth, int gridHeight,
                               int weightX, int weightY, int fill)
    {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        panel.add(component, c);
    }
    public void addConstraints(JPanel panel, Component component, int x, int y, int gridWidth, int gridHeight,
                               int weightX, int weightY, int fill, int anchor)
    {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        panel.add(component, c);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
