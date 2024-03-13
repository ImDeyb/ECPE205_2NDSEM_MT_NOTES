package com.flowLayout;

import com.gridBagLayout.Assignment.AssignmentNo1.MainFrame;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {
    // Declaration of variables
    JLabel name;
    JTextField nameField;
    JButton saveButton;
    public FlowLayoutExample() {
        init();
    }

    public void init() {
        setTitle("FlowLayout Example"); //set frame title
        setLayout(new FlowLayout()); // Set frame layout

        // Add components to the frame
        add(name = new JLabel("Name:"));
        add(nameField = new JTextField(20)); // "Columns" is similar to width
        add(saveButton = new JButton("Save!"));

        pack(); // Pack the frame to fit preferred sizes of components
        setVisible(true);  // Set frame visibility
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set default close operation
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }

    public static class Main {
        public static void main(String[] args) {
            new MainFrame();
        }
    }
}

