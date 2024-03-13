package InstallmentGUIHEHE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstallmentGUI extends JFrame {
    JTextField itemNameField, itemPriceField;
    JLabel totalAmountToPay;
    JComboBox paymentMethods;
    String installment;
    JButton calculateButton;
    JList list;
    JListModel listModel;

    String[] methods = new String[]{
            "Full Payment", "Installments"
    };
    public InstallmentGUI(){
        init();
    }
    private void init(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        listModel = new JListModel();
        list = new JList(listModel);
        list.setCellRenderer(new CellRenderer());

        addComponent(new JLabel("Item Name:"),0,0,1,1,0,0,GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        addComponent(itemNameField = new JTextField(10),1,0,1,1,1,1, GridBagConstraints.HORIZONTAL);
        addComponent(new JLabel("Item Price:"),0,1,1,1,0,0,GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        addComponent(itemPriceField = new JTextField(10),1,1,1,1,1,1, GridBagConstraints.HORIZONTAL);
        addComponent(new JLabel("Item name:"),0,2,1,1,0,0,GridBagConstraints.NONE, GridBagConstraints.LINE_END);
        addComponent(paymentMethods = new JComboBox<>(methods),1,2,1,1,1,1, GridBagConstraints.HORIZONTAL);
        addComponent(calculateButton = new JButton("Calculate"), 0,3,2,1,1,1);
        addComponent(new JScrollPane(list),0,4,2,1,1,1,GridBagConstraints.BOTH,GridBagConstraints.CENTER);
        addComponent(totalAmountToPay = new JLabel("Total Amount Due: $0.00"),1,15,1,1,1,1,GridBagConstraints.NONE,GridBagConstraints.EAST);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void calculateTotal(){
        try {
            double itemPrice = Double.parseDouble(itemPriceField.getText());
            double totalAmountDue = 0;

            String selectedValue = (String) paymentMethods.getSelectedItem();

            if("Full Payment".equals(selectedValue)){
                    totalAmountDue = itemPrice;
            } else if("Installments".equals(selectedValue)){

                installment = JOptionPane.showInputDialog(null, "Payment Period:");

                int period = Integer.parseInt(installment);
                totalAmountDue = itemPrice + (itemPrice * 0.5 * period);
            }else {
                JOptionPane.showMessageDialog(null, "Select payment method.");
            }
            totalAmountToPay.setText("Total Amount Due: $" + String.format("%.2f", totalAmountDue));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid number.");
        }
        addItemToList();
    }

    public void addItemToList(){
        String itemName = itemNameField.getText().trim();
        String itemPrice = itemPriceField.getText().trim();
        String paymentMethod = paymentMethods.getSelectedItem().toString();

        Items items = new Items(itemName, itemPrice, paymentMethod);

        if(!itemName.isEmpty() && !itemPrice.isEmpty() && !paymentMethod.isEmpty()){
            listModel.addItem(items);
            list.updateUI();
            itemNameField.setText("");
            itemPriceField.setText("");
        }
    }
    private void addComponent(Component component, int x, int y, int width, int height, int weightX,
                              int weightY){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(3,5,3,5);

        this.add(component, c);
    }
    private void addComponent(Component component, int x, int y, int width, int height, int weightX,
                              int weightY, int fill){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.insets = new Insets(3,5,3,5);

        this.add(component, c);
    }
    private void addComponent(Component component, int x, int y, int width, int height, int weightX,
                              int weightY, int fill, int anchor){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = new Insets(3,5,3,5);

        this.add(component, c);
    }

    public static void main(String[] args) {
        new InstallmentGUI();
    }
}
