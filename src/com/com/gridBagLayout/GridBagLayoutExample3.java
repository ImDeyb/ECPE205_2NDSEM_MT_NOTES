package com.gridBagLayout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample3 extends JFrame {
    public GridBagLayoutExample3()
    {
        init();
    }
    private void init()
    {
        setTitle("GridBagLayout Example #3");
        Container container = getContentPane();
        getContentPane().setLayout(new GridBagLayout());


        String[] dataValues = new String[]
                {
                        "\uD83D\uDD12", "/", "*", "-",
                        "7", "8", "9", "+",
                        "4", "5", "6",
                        "1", "2", "3", "\u21B5",
                        "0", "."

                };

        GridBagConstraints c = new GridBagConstraints();

        int[][] gridConstraints = new int[][]
                {
                        {0,0,1,1,1,1},{1,0,1,1,1,1},{2,0,1,1,1,1},{3,0,1,1,1,1},
                        {0,1,1,1,1,1},{1,1,1,1,1,1},{2,1,1,1,1,1},{3,1,1,2,1,1},
                        {0,2,1,1,1,1},{1,2,1,1,1,1},{2,2,1,1,1,1},
                        {0,3,1,1,1,1},{1,3,1,1,1,1},{2,3,1,1,1,1},{3,3,1,2,1,1},
                        {0,4,2,1,1,1},{2,4,1,1,1,1}

                };

        for(int i = 0; i <dataValues.length; i++)
        {
            setGridBagConstraints(gridConstraints[i], c);
            container.add(new JButton(dataValues[i]), c);
        }
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void setGridBagConstraints(int[] gridConstraints, GridBagConstraints c) {
        c.gridx = gridConstraints[0];
        c.gridy = gridConstraints[1];
        c.gridwidth = gridConstraints[2];
        c.gridheight = gridConstraints[3];
        c.weightx = gridConstraints[4];
        c.weighty = gridConstraints[4];
        c.fill = GridBagConstraints.BOTH;
    }

    public static void main(String[] args) {
        new GridBagLayoutExample3();
    }
}
