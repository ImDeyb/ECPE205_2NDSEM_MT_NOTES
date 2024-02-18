package com.gridBagLayout.Assignment.AssignmentNo1;

import javax.swing.*;
    import javax.swing.border.TitledBorder;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class EmailPanel extends JPanel {
        JTextField emailField;
        JButton addBtn, editBtn, removeBtn, defBtn;
        JRadioButton htmlRbtn, plainTxtRBtn, customRbtn;
        JPanel buttonGroup;
        JList list;

        String[] dataValues = new String[] {
                "Item 1", "Item 2", "Item 3",
                "Item 4", "Item 5"
        };
        public EmailPanel()
        {
            init();
        }
        private void init() {
            TitledBorder titledBorder = new TitledBorder("E-mail");
            setBorder(titledBorder);
            setLayout(new GridBagLayout());

            list = new JList(dataValues);

            add(new JLabel("E-mail Address:"), 0,0,1,1,0,0,GridBagConstraints.NONE,GridBagConstraints.LINE_START);
            add(emailField = new JTextField(15),1,0,3,1,1,1,GridBagConstraints.BOTH);
            add(addBtn = new JButton("Add"),4,0,1,1,1,0,GridBagConstraints.HORIZONTAL);
            add(new JScrollPane(list),0,1,4,3,1,1, GridBagConstraints.BOTH);
            add(editBtn = new JButton("Edit"),4,1,1,1,1,1,GridBagConstraints.HORIZONTAL);
            add(removeBtn = new JButton("Remove"),4,2,1,1,1,1,GridBagConstraints.HORIZONTAL);
            add(defBtn = new JButton("As Default"),4,3,1,1,1,1,GridBagConstraints.HORIZONTAL);
            add(new JLabel("Mail Format:"), 0, 4, 1, 1, 0, 1, GridBagConstraints.NONE,GridBagConstraints.LINE_START);
            add(buttonGroup = new JPanel(new FlowLayout(FlowLayout.LEFT)), 0, 5, 3, 1, 0, 0, GridBagConstraints.HORIZONTAL);
            buttonGroup.add(htmlRbtn = new JRadioButton("HTML"));
            buttonGroup.add(plainTxtRBtn = new JRadioButton("Plain Text"));
            buttonGroup.add(customRbtn = new JRadioButton("Custom"));
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
