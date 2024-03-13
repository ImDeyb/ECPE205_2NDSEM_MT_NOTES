package com.gridBagLayout.Assignment.JListActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JPanel buttonPanel;
    JButton okBtn, cancelBtn;
    public MainFrame() {
        init();
    }
    private void init() {
        setTitle("Contact Editor UI W/ JLIST Actions by Dave Chavez");
        getContentPane().setLayout(new BorderLayout());

        NamePanel namePanel = new NamePanel();
        EmailPanel emailPanel = new EmailPanel();

        this.add(namePanel, BorderLayout.NORTH);
        this.add(emailPanel, BorderLayout.CENTER);
        add(buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)), BorderLayout.PAGE_END);
        buttonPanel.add(okBtn = new JButton("OK"));
        okBtn.setPreferredSize(new Dimension(100,25));
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(cancelBtn = new JButton("CANCEL"));
        cancelBtn.setPreferredSize(new Dimension(100,25));
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
