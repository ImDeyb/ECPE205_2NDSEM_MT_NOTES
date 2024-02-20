package com.ecpe205LecAssignment.JListActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    JTextField nameField, courseField;
    JButton addBtn, updateBtn;
    ListModel listModel;
    JList list;

    public MainFrame() {
        init();
    }
    private void init(){
        setTitle("Student Information Manager by Dave Chavez");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        listModel = new ListModel();
        list = new JList(listModel);

        addComponent(new JLabel("Name:"),0,0,1,1,0,0,GridBagConstraints.NONE,GridBagConstraints.LINE_END);
        addComponent(nameField = new JTextField(40),1,0,1,1,1,0,GridBagConstraints.HORIZONTAL);
        addComponent(new JLabel("Course:"),0,1,1,1,0,0,GridBagConstraints.BOTH);
        addComponent(courseField = new JTextField(40),1,1,1,1,1,0,GridBagConstraints.HORIZONTAL);
        addComponent(addBtn = new JButton("Add"),0,2,2,1,0,0,GridBagConstraints.NONE, GridBagConstraints.CENTER);
        addComponent(updateBtn = new JButton("Update"),0,2,2,1,0,0,GridBagConstraints.NONE, GridBagConstraints.CENTER);
        updateBtn.setVisible(false);
        addComponent(new JScrollPane(list), 0,3,2,1,1,1,GridBagConstraints.BOTH, GridBagConstraints.CENTER);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBtn.setVisible(false);
                addBtn.setVisible(true);
                updateStudent();
            }
        });
        int index = list.getSelectedIndex();

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean indices = list.getSelectedIndices().length == 1;
                if(e.getClickCount() == 2 && !list.isSelectionEmpty()){
                    if(!indices == false) {
                        updateBtn.setVisible(true);
                        addBtn.setVisible(false);
                        editStudent();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a single item.", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    private void registerStudent(){
            String name = nameField.getText().trim();
            String course = courseField.getText().trim();

            Student student = new Student(name, course);

            if(!name.isEmpty() && !course.isEmpty()) {
                    listModel.addStudent(student);
                    nameField.setText("");
                    courseField.setText("");
                    list.updateUI();
            }
            else{
                JOptionPane.showMessageDialog(this, "Please enter your name and course.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            nameField.requestFocus();
            list.clearSelection();
    }

    private void editStudent(){
        int index = list.getSelectedIndex();
        Student selectedElement = (Student) listModel.getElementAt(index);

        nameField.setText(selectedElement.getName());
        courseField.setText(selectedElement.getCourse());
    }

    private void updateStudent(){
        nameField.requestFocus();

        int index = list.getSelectedIndex();

        String name = nameField.getText().trim();
        String course = courseField.getText().trim();

        Student student = new Student(name, course);

        listModel.update(student, index);
        nameField.setText("");
        courseField.setText("");
        list.clearSelection();
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
