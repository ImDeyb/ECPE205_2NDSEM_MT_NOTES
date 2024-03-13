package InstallmentGUIHEHE;

import javax.swing.*;
import java.awt.*;

public class CellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JPanel cellPanel = new JPanel(new GridLayout(2, 1));
        Items p = (Items) value;
        String name = p.getItemName();
        String price = p.getItemPrice();
        String paymentMethod = p.getPaymentMethod().toString();


        char pesoSign = '\u20B1';

        JLabel leftCellLabel = new JLabel(name);
        JLabel rightCellLabel = new JLabel(pesoSign + String.valueOf(price));
        JLabel bottomCellLabel = new JLabel("Payment Method" + " - " + paymentMethod);

        JPanel leftCellPanel = new JPanel(new BorderLayout());
        JPanel rightCellPanel = new JPanel(new BorderLayout());
        JPanel bottomCellPanel = new JPanel(new BorderLayout());

        leftCellPanel.add(leftCellLabel, BorderLayout.WEST);
        rightCellPanel.add(rightCellLabel, BorderLayout.EAST);
        bottomCellPanel.add(bottomCellLabel, BorderLayout.WEST);

        cellPanel.add(leftCellPanel);
        cellPanel.add(rightCellPanel);
        cellPanel.add(bottomCellPanel);


        return cellPanel;
    }
}
