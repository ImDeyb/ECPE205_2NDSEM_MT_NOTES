package com.gridBagLayout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample1 extends JFrame
{
    public GridBagLayoutExample1()
    {
        setTitle("GridBagLayout Example #1");
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        // Adding a JLabel
        JLabel nameLabel = new JLabel("Name:");
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(5, 5, 5, 5); // padding
        add(nameLabel, c);

        // Adding a JTextField
        JTextField nameTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
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
        add(ageTextField, c);

        // Adding a JButton
        JButton submitButton = new JButton("Submit");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2; // make the button span two columns
        c.anchor = GridBagConstraints.CENTER;
        add(submitButton, c);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new GridBagLayoutExample1();
    }
}
