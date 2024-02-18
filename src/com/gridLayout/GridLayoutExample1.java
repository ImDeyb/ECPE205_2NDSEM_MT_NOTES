package com.gridLayout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample1 extends JFrame
{
    public GridLayoutExample1()
    {
        init();
    }

    private void init()
    {
        setTitle("GridLayout Example #1"); //set frame title
        setLayout(new GridLayout(4,4)); // Set frame layout, rows, and columns.


        // Add components to the frame

        add(new JButton("BUTTON 1"));
        add(new JButton("BUTTON 2"));
        add(new JButton("BUTTON 3"));
        add(new JButton("BUTTON 4"));
        add(new JButton("BUTTON 5"));
        add(new JButton("BUTTON 6"));
        add(new JButton("BUTTON 7"));
        add(new JButton("BUTTON 8"));

        pack(); // Pack the frame to fit preferred sizes of components
        setVisible(true);  // Set frame visibility
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set default close operation
    }

    public static void main(String[] args) {
        new GridLayoutExample1();
    }
}
