package com.flowLayout.SeatWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    JLabel name;
    JTextField nameField;
    JButton saveButton;
    MainForm mainForm;
    public FormPanel(MainForm mainForm) {
        this.mainForm = mainForm;
        init();
    }

    public void init() {
        setLayout(new FlowLayout());

        add(name = new JLabel("Name:"));
        add(nameField = new JTextField(20));
        add(saveButton = new JButton("Save!"));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                if(!name.isEmpty())
                {
                    mainForm.textArea.append(name + "\n");
                    nameField.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter your name.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

