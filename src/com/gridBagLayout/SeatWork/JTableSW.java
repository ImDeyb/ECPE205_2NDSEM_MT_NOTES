package com.gridBagLayout.SeatWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableSW extends JFrame {
    TableModel tableModel;

    public JTableSW() {
        setTitle("GridBagLayout Example #1");
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        tableModel = new TableModel();
        JTable table = new JTable(tableModel);

        // Adding a JLabel
        JLabel nameLabel = new JLabel("Name:");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(5, 5, 5, 5);
        add(nameLabel, c);

        // Adding a JTextField
        JTextField nameTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(nameTextField, c);

        // Adding a JLabel
        JLabel ageLabel = new JLabel("Age:");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;
        add(ageLabel, c);

        // Adding a JTextField
        JTextField ageTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(ageTextField, c);

        // Adding a JButton
        JButton submitButton = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 5, 5, 5);
        add(submitButton, c);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String age = ageTextField.getText();

                Person p = new Person(name, age);

                if (!name.isEmpty() && !age.isEmpty()) {
                    tableModel.addPerson(p);
                    nameTextField.setText("");
                    ageTextField.setText("");
                    nameTextField.requestFocus();

                    tableModel.fireTableDataChanged();
                } else {
                    JOptionPane.showMessageDialog(null, "Enter your name and age.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adding a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPane, c);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JTableSW();
    }
}



