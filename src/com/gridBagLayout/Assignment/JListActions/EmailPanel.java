package com.gridBagLayout.Assignment.JListActions;

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
        ListModel listModel;
        public EmailPanel()
        {
            init();
        }
        private void init() {
            TitledBorder titledBorder = new TitledBorder("E-mail");
            setBorder(titledBorder);
            setLayout(new GridBagLayout());

            listModel = new ListModel();
            list = new JList(listModel);

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

            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addEmailAddress();
                }
            });

            editBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editEmailAddress();
                }
            });

            removeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeEmailAddress();
                }
            });
        }

        private void addEmailAddress() {
            String emails = emailField.getText().toLowerCase();

            if(!emails.isEmpty()) {
                if(listModel.contains(emails)) {
                    JOptionPane.showMessageDialog(null, "E-mail is already on the list!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    listModel.addEmail(emails);
                    emailField.setText("");
                    list.updateUI();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Email address field is empty!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            emailField.requestFocus();
            list.clearSelection();
        }
        private void editEmailAddress() {
            int selectedIndex = list.getSelectedIndex();
            boolean checkIndex = list.getSelectedIndices().length == 1;

            if(list.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Nothing is selected!", "Error!", JOptionPane.ERROR_MESSAGE);
            } else if(!checkIndex == true) {
                JOptionPane.showMessageDialog(null,"Cannot Edit Multiple item.", "Error", JOptionPane.ERROR_MESSAGE);
            } else{
                String newEmailAddress = JOptionPane.showInputDialog(null,"Edit e-mail address", "Edit", JOptionPane.PLAIN_MESSAGE);
                   if (newEmailAddress != null) {
                       if (!newEmailAddress.isEmpty()) {
                           if (!listModel.contains(newEmailAddress) && !newEmailAddress.isEmpty()) {
                               listModel.setElementAt(newEmailAddress, selectedIndex);
                               JOptionPane.showMessageDialog(null, "Changes saved!", "Successful!", JOptionPane.PLAIN_MESSAGE);

                           } else {
                               JOptionPane.showMessageDialog(null, "E-mail is already on the list!", "Error!", JOptionPane.ERROR_MESSAGE);
                           }
                       } else {
                           JOptionPane.showMessageDialog(null, "Empty Field", "Error!", JOptionPane.ERROR_MESSAGE);
                       }
                   } else {
                       JOptionPane.showMessageDialog(null,"Operation canceled", "Canceled", JOptionPane.ERROR_MESSAGE);
                   }
                   list.clearSelection();
                }
            }
        private void removeEmailAddress() {
            int selectedIndex = list.getSelectedIndex();
            int[] selectedIndices = list.getSelectedIndices();

            if(!list.isSelectionEmpty() && selectedIndices.length == 1)
            {
                listModel.removeElementAt(selectedIndex);
            } else if(!list.isSelectionEmpty() && selectedIndices.length > 1) {
                for(int i = selectedIndices.length - 1; i >= 0; i--){
                    listModel.removeElementAt(selectedIndices[i]);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nothing is selected!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            list.clearSelection();
            list.updateUI();
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
