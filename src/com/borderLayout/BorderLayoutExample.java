package com.borderLayout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame
{
    public BorderLayoutExample()
    {
        init();
    }

    private void init()
    {
        setTitle("BorderLayout Example"); //set frame title
        setLayout(new BorderLayout()); // Set frame layout manager

        // Add components to the frame
        add(new JButton("NORTH"), BorderLayout.NORTH);
        add(new JButton("CENTER"), BorderLayout.CENTER);
        add(new JButton("EAST"), BorderLayout.EAST);
        add(new JButton("WEST"), BorderLayout.WEST);
        add(new JButton("SOUTH"), BorderLayout.SOUTH);

        pack(); // Pack the frame to fit preferred sizes of components
        setVisible(true);  // Set frame visibility
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set default close operation
    }

    public static void main(String[] args)
    {
        new BorderLayoutExample();
    }
}
