package com.gridBagLayout.Assignment.AssignmentNo1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class NamePanel extends JPanel {
    public NamePanel() {
        init();
    }
    String[] dataValues = new String[] {
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5"
    };

    private void init() {
        TitledBorder titledBorder = new TitledBorder("Name");
        setBorder(titledBorder);
        setLayout(new GridBagLayout());

        add(new JLabel("First Name:"),0,0,1,1,1,0, GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        add(new JTextField(15),1,0,1,1,0,0,GridBagConstraints.BOTH);
        add(new JLabel("Last Name:"),2,0,1,1,0,0, GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        add(new JTextField(15),3,0,1,1,0,0);
        add(new JLabel("Title:"),0,1,1,1,0,0, GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        add(new JTextField(15),1,1,1,1,0,0);
        add(new JLabel("Nickname:"),2,1,1,1,0,0, GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        add(new JTextField(15),3,1,1,1,0,0);
        add(new JLabel("Display Format:"),0, 2,1,1,1,0,GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        add(new JComboBox<>(dataValues),1,2,4,1,0,0, GridBagConstraints.HORIZONTAL);
    }
    public void add(Component component,
                    int x, int y, int gridWidth, int gridHeight, int weightX, int weightY) {

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.NONE;
        this.add(component, c);

    }

    public void add(Component component,
                    int x, int y, int gridWidth, int gridHeight, int weightX, int weightY, int fill) {

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        this.add(component, c);

    }
    public void add(Component component,
                    int x, int y, int gridWidth, int gridHeight, int weightX, int weightY, int fill, int anchor) {

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.gridx = x;
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
