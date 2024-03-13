package com.Quizzes_Midterm.LayoutManagerQuizzes.Quiz1;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JButton okBtn;
    DatabasePanel databasePanel = new DatabasePanel();
    SystemPanel systemPanel = new SystemPanel();
    public MainFrame()
    {
        init();
    }
    private void init()
    {
        setTitle("Dave Chavez ENCE 2A Quiz#1");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        this.add(new JLabel("Data Source Name:"),0,0,1,1,1,1,GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        this.add(new JTextField(20),1,0,3,1,1,1,GridBagConstraints.BOTH);
        this.add(new JLabel("Description:"),0,1,1,1,1,1,GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        this.add(new JTextField(20),1,1,3,1,1,1,GridBagConstraints.BOTH);

        this.add(okBtn = new JButton("OK"),4,0,1,1,1,1,GridBagConstraints.HORIZONTAL);
        okBtn.setEnabled(false);
        this.add(new JButton("Cancel"),4,1,1,1,1,1,GridBagConstraints.HORIZONTAL);

        this.add(databasePanel,0,3,4,2,1,1,GridBagConstraints.BOTH);

        this.add(new JButton("Help"),4,3,1,1,1,1,GridBagConstraints.HORIZONTAL);
        this.add(new JButton("Advanced..."),4,4,1,1,1,GridBagConstraints.HORIZONTAL);

        this.add(systemPanel, 0,5,4,2,1,1,GridBagConstraints.BOTH);
        this.add(new JButton("Options>>"),4,6,1,1,1,1,GridBagConstraints.HORIZONTAL, GridBagConstraints.PAGE_END);

        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void add(Component component,
                    int x, int y, int gridWidth, int gridHeight, int weightX, int weightY){

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(2,2,2,2);
        c.gridx  =x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.NONE;
        this.add(component, c);

    }
    public void add(Component component,
                    int x, int y, int gridWidth, int gridHeight, int weightX, int weightY, int fill){

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx  =x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        this.add(component, c);

    }

    public void add(Component component,
                    int x, int y, int gridWidth, int gridHeight, int weightX, int weightY, int fill, int anchor){

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2,2,2,2);
        c.gridx  =x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        this.add(component, c);

    }

}
