package com.gridBagLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GridBagLayoutExample2 extends JFrame
{
    public GridBagLayoutExample2()
    {
        setTitle("GridBagLayout Example #2");

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 2));

        add(GUI1Panel());
        add(GUI3Panel());
        add(GUI2Panel());
        add(GUI4Panel());

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //GridBagLayout
    public JPanel GUI1Panel()
    {
        JPanel GUI1Panel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder = new TitledBorder("Sample GUI 1");
        GUI1Panel.setBorder(titledBorder);

        //Sample GUI 1
        addConstraints(GUI1Panel, new JButton("1"),0, 0, 1, 2, 2, 1);
        addConstraints(GUI1Panel, new JButton("2"), 1, 0, 1, 1, 1, 1);
        addConstraints(GUI1Panel, new JButton("3"), 1, 1, 1, 1, 1, 1);

        return GUI1Panel;
    }

    public JPanel GUI2Panel()
    {
        JPanel GUI2Panel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder = new TitledBorder("Sample GUI 2");
        GUI2Panel.setBorder(titledBorder);

        //Sample GUI 2
        addConstraints(GUI2Panel, new JButton("1"),0,0,1,3,2,1);
        addConstraints(GUI2Panel, new JButton("2"),1,0,3,1,1,1);
        addConstraints(GUI2Panel, new JButton("3"),1,1,2,1,1,1);
        addConstraints(GUI2Panel, new JButton("4"),3,1,1,1,1,1);
        addConstraints(GUI2Panel, new JButton("5"),1,2,1,1,1,1);
        addConstraints(GUI2Panel, new JButton("6"),2,2,1,1,1,1);
        addConstraints(GUI2Panel, new JButton("7"),3,2,1,1,1,1);

        return GUI2Panel;
    }

    public JPanel GUI3Panel()
    {
        JPanel GUI3Panel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder = new TitledBorder("Sample GUI 3");
        GUI3Panel.setBorder(titledBorder);


        //Sample GUI 3
        addConstraints(GUI3Panel, new JButton("One"), 0, 0, 1, 1, 1, 1);
        addConstraints(GUI3Panel, new JButton("Two"), 1, 0, 1, 1, 1, 1);
        addConstraints(GUI3Panel, new JButton("Three"), 2, 0, 1, 1, 1, 1);
        addConstraints(GUI3Panel, new JButton("Four"), 0, 1, 2, 1, 1, 1);
        addConstraints(GUI3Panel, new JButton("Five"), 2, 1, 1, 2, 1, 1);
        addConstraints(GUI3Panel, new JButton("Six"), 0, 2, 1, 1, 1, 1);
        addConstraints(GUI3Panel, new JButton("Seven"), 1, 2, 1, 1, 1, 1);

      return GUI3Panel;
    }

    public JPanel GUI4Panel()
    {
        JPanel GUI4Panel = new JPanel(new GridBagLayout());
        TitledBorder titledBorder = new TitledBorder("Sample GUI 4");
        GUI4Panel.setBorder(titledBorder);

        //Sample GUI 4
        addConstraints(GUI4Panel, new JButton("North"),1, 0, 1, 1, 1, 1);
        addConstraints(GUI4Panel, new JButton("West"),0, 1, 1, 1, 1, 1);
        addConstraints(GUI4Panel, new JButton("Center"),1, 1, 1, 1, 1, 1);
        addConstraints(GUI4Panel, new JButton("East"),2, 1, 1, 1, 1, 1);
        addConstraints(GUI4Panel, new JButton("South"),1, 2, 1, 1, 1, 1);

        return GUI4Panel;
    }

    public void addConstraints(JPanel panel, Component component, int x, int y, int gridWidth, int gridHeight, int weightX, int weightY)
   {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.BOTH;
        panel.add(component, c);
   }
    public static void main(String[] args)
    {
        new GridBagLayoutExample2();
    }
}
