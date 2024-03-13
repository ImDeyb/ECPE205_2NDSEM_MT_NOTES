package JListActions;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class RightPanel extends JPanel {
    JTable table;
    TableModel tableModel;
    JScrollPane scrollPane;

    public RightPanel(){
        init();
    }
    private void init(){

        setLayout(new BorderLayout());

        tableModel = new TableModel();
        table = new JTable(tableModel);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        this.add(new JScrollPane(table), BorderLayout.CENTER);
        //scrollPane.setBorder(titledBorder);

    }
}
