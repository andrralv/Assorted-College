package project2;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class MarcoPrograma extends JFrame {
    public MarcoPrograma(){
        super("Cuentas de Clientes"); // titulo de marco
        setSize(330, 400); // tamano de marco
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addAccountPanel panel1 = new addAccountPanel();
        AccountPanel panel2 = new AccountPanel();
        DisplayAccountPanel panel3 = new DisplayAccountPanel();
        TransactionsPanel panel4 = new TransactionsPanel();
        
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        
        GridLayout grid = new GridLayout(4, 4, 1, 2);
        setLayout(grid);
        setVisible(true);
    }
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // ignora el error
        }
    }
}