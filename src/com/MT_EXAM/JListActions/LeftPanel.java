package JListActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.stream.Stream;

public class LeftPanel extends JPanel {
    JPanel buttonPanel;
    JButton okBtn, cancelBtn;
    RightPanel rightPanel;

    public LeftPanel(RightPanel rightPanel) {
        this.rightPanel = rightPanel;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        NamePanel namePanel = new NamePanel();
        EmailPanel emailPanel = new EmailPanel();

        add(namePanel, BorderLayout.NORTH);
        add(emailPanel, BorderLayout.CENTER);

        add(buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)), BorderLayout.SOUTH);
        buttonPanel.add(okBtn = new JButton("OK"));
        okBtn.setPreferredSize(new Dimension(100, 25));

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String firstname = namePanel.firstnameField.getText();
                String lastname = namePanel.lastnameField.getText();
                String title = namePanel.titleField.getText();
                String nickname = namePanel.nicknameField.getText();

                String emails = emailPanel.listModel.toString();

                String displaying = namePanel.comboBox.getSelectedItem().toString();
                String format = null;

                for (Enumeration buttons = emailPanel.buttonGroup.getElements(); buttons.hasMoreElements();) {
                    JRadioButton button = (JRadioButton) buttons.nextElement();
                    if (button.isSelected()) {
                        format = button.getText();
                    }
                }

                Person p = new Person(firstname, lastname, title, nickname, displaying, emails, format);

                if (!firstname.isEmpty() && !lastname.isEmpty() &&
                        !title.isEmpty() && !nickname.isEmpty()) {

                    //tableModel.addPerson(p);
                    rightPanel.tableModel.addPerson(p);

                    namePanel.firstnameField.setText("");
                    namePanel.lastnameField.setText("");
                    namePanel.titleField.setText("");
                    namePanel.nicknameField.setText("");

                    namePanel.firstnameField.requestFocus();

                    rightPanel.tableModel.fireTableDataChanged();
                    rightPanel.table.updateUI();


                    System.out.println("GAGANA " + rightPanel.tableModel.persons.size());

                } else {
                    JOptionPane.showMessageDialog(null, "Some field are empty.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        buttonPanel.add(cancelBtn = new JButton("CANCEL"));
        cancelBtn.setPreferredSize(new Dimension(100, 25));
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

//    private String getEmail(){
//
//    }
}
//   private void getEmail(){
//        EmailPanel emailPanel = new EmailPanel();
//
//        for(int i = 0; i< emailPanel.list.getModel().getSize();i++){
//             String emailAddresses = emailPanel.list.getModel().getElementAt(i).toString();
//        }
//    }
//}
