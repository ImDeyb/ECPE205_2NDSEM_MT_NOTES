package JListActions;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    JPanel buttonPanel;
    JButton okBtn, cancelBtn;

    String[] dataValues = new String[] {
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5"
    };
    public MainFrame() {
        init();
    }
    private void init() {
        setTitle("Contact Editor UI W/ JLIST Actions by Dave Chavez");
        getContentPane().setLayout(new BorderLayout());
        RightPanel rightPanel = new RightPanel();

        LeftPanel leftPanel = new LeftPanel(rightPanel);

        this.add(rightPanel, BorderLayout.EAST);
        this.add(leftPanel, BorderLayout.WEST);

        pack();
        setLocationRelativeTo(null);
          //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
