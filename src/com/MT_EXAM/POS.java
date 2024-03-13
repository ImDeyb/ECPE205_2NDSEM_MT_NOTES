import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class POS extends JFrame implements ActionListener {

    private JLabel lblWelcome, lblItem, lblPrice, lblPayment, lblTotal, lblInstallment;
    private JTextField txtItem, txtPrice;
    private JComboBox<String> cmbPayment;
    private JButton btnSubmit, btnReset, btnExit;
    private double price;
    private int installments;

    public POS() {
        super("Installment Sales Management");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Welcome Message
        lblWelcome = new JLabel("Welcome to Installment Sales Management!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        add(lblWelcome, c);

        // Item Name
        lblItem = new JLabel("Item Name:");
        c.gridwidth = 1;
        c.gridy = 1;
        add(lblItem, c);
        txtItem = new JTextField(20);
        c.gridx = 1;
        add(txtItem, c);

        // Item Price
        lblPrice = new JLabel("Item Price:");
        c.gridy = 2;
        add(lblPrice, c);
        txtPrice = new JTextField(20);
        c.gridx = 1;
        add(txtPrice, c);

        // Payment Method
        lblPayment = new JLabel("Payment Method:");
        c.gridy = 3;
        add(lblPayment, c);
        cmbPayment = new JComboBox<>(new String[]{"Full Payment", "Installments"});
        cmbPayment.addActionListener(this);
        c.gridx = 1;
        add(cmbPayment, c);

        // Total and Installment Labels (initially hidden)
        lblTotal = new JLabel("Total Amount Due:");
        lblTotal.setVisible(false);
        c.gridy = 4;
        add(lblTotal, c);
        lblInstallment = new JLabel("Installment Amount:");
        lblInstallment.setVisible(false);
        c.gridy = 5;
        add(lblInstallment, c);

        // Buttons
        btnSubmit = new JButton("Submit Sale");
        btnSubmit.addActionListener(this);
        c.gridy = 6;
        add(btnSubmit, c);
        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);
        c.gridx = 1;
        add(btnReset, c);
        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        c.gridy = 7;
        add(btnExit, c);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmbPayment) {
            // Show/hide installment label based on payment method
            if (cmbPayment.getSelectedItem().equals("Installments")) {
                lblInstallment.setVisible(true);
            } else {
                lblInstallment.setVisible(false);
            }
        } else if (e.getSource() == btnSubmit) {
            // Submit button action
            try {
                price = Double.parseDouble(txtPrice.getText());
                if (price <= 0) {
                    throw new NumberFormatException();
                }
                calculateTotal();
                displayResults();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid price! Please enter a positive number.");
            }
        } else if (e.getSource() == btnReset) {
            // Reset button action
            resetFields();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    private void calculateTotal() {
        if (cmbPayment.getSelectedItem().equals("Installments")) {
            String input = JOptionPane.showInputDialog(this, "Enter number of installments:");
            try {
                installments = Integer.parseInt(input);
                if (installments <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number of installments! Please enter a positive number.");
                return;
            }
            double installmentAmount = price / installments;
            lblTotal.setText("Total Amount Due: $" + price);
            lblInstallment.setText("Installment Amount: $" + String.format("%.2f", installmentAmount));
            lblTotal.setVisible(true);
        } else {
            // Full payment - total amount is just the price
            lblTotal.setText("Total Amount Due: $" + price);
            lblInstallment.setVisible(false);
            lblTotal.setVisible(true);
        }
    }

    private void displayResults() {
        // Display calculated total and installment amount (if applicable)
        JOptionPane.showMessageDialog(this, "Sale details:\n" + lblTotal.getText() + "\n" + lblInstallment.getText());
    }

    private void resetFields() {
        txtItem.setText("");
        txtPrice.setText("");
        cmbPayment.setSelectedIndex(0); // Set default payment to full
        lblTotal.setVisible(false);
        lblInstallment.setVisible(false);
    }

    public static void main(String[] args) {
        new POS();
    }
}
