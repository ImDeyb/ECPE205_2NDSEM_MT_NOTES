package com.flowLayout.SeatWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame
{
    JTextArea textArea;
    JButton clearButton;
    public MainForm()
    {
        init();
    }

    private void init()
    {
        setTitle("FlowLayout SeatWork #1 by Dave Chavez ENCE2A");
        getContentPane().setLayout(new BorderLayout());

        FormPanel formPanel = new FormPanel(this);

        getContentPane().add(formPanel, BorderLayout.NORTH);
        getContentPane().add(textArea = new JTextArea(10,20), BorderLayout.CENTER);
        getContentPane().add(clearButton = new JButton("Clear List"), BorderLayout.SOUTH);

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkTextArea = textArea.getText().trim().isEmpty();
                if(!checkTextArea == false)
                {
                    JOptionPane.showMessageDialog(null, "List is empty.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    textArea.setText("");
                }
            }
        });
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
