package com.Quizzes_Midterm.LayoutManagerQuizzes.Quiz1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SystemPanel extends JPanel {
    public SystemPanel()
    {
        init();
    }
    private void init()
    {
        TitledBorder border = new TitledBorder("System Database");
        setBorder(border);
        setLayout(new GridBagLayout());

        this.add(new JRadioButton("None"),0,0,1,1,1,1, GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        this.add(new JRadioButton("Database:"),0,1,1,1,1,1, GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        this.add(new JButton("System Database..."),0,2,1,1,1,1, GridBagConstraints.NONE, GridBagConstraints.CENTER);
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
        c.insets = new Insets(2,5,2,2);
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
        c.insets = new Insets(5,5,2,2);
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
