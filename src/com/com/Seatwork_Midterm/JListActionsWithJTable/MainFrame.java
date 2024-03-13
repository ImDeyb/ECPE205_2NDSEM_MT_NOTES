package com.Seatwork_Midterm.JListActionsWithJTable;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JPanel buttonPanel;
    JButton okBtn, cancelBtn;
    JTable table;
    public MainFrame() {
        init();
    }
    private void init() {
        setTitle("Contact Editor UI W/ JLIST Actions by Dave Chavez");
        getContentPane().setLayout(new GridLayout(1, 2));

        add(RightPanel());
        add(LeftPanel());

        pack();
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel RightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout());

        NamePanel namePanel = new NamePanel();
        EmailPanel emailPanel = new EmailPanel();

        rightPanel.add(namePanel, BorderLayout.NORTH);
        rightPanel.add(emailPanel, BorderLayout.CENTER);

        add(buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)));
        rightPanel.add(buttonPanel, BorderLayout.PAGE_END);
        buttonPanel.add(okBtn = new JButton("OK"));
        okBtn.setPreferredSize(new Dimension(100,25));
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(cancelBtn = new JButton("CANCEL"));
        cancelBtn.setPreferredSize(new Dimension(100,25));
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return rightPanel;
    }

    private JPanel LeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());

        PersonTableModel tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());

        // Apply the custom header renderer for each column explicitly
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setHeaderRenderer(new CustomHeaderRenderer());
        }

//        ColumnAdjuster adjuster = new ColumnAdjuster(table);
//        adjuster.columndj();

        leftPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        return leftPanel;
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
