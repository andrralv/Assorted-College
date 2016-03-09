package project2;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Paneles extends JPanel {
    // root class  
}

class addAccountPanel extends JPanel {
    private JLabel nameLabel; // etiqueta del nombre
    private JLabel lastnLabel; // etiqueta primer apellido;
    private JLabel maidennLabel; // etiqueta apellido materno
    
    public JTextField nameField; // campo nombre;
    public JTextField lastnField;// campo apellido
    public JTextField maidennField; // campo apellido materno
    
    private JButton addButton; // boton de cuenta nueva
    private JTextField newAccountMsg; // despliega mensaje cuenta nueva
    
    // el constructor agrega los objetos
    public addAccountPanel() {
        super();
        nameLabel = new JLabel("Nombre: ");
        nameField = new JTextField(12);
    
        lastnLabel = new JLabel("Apellido: ");
        lastnField = new JTextField(12);
        
        maidennLabel = new JLabel("2do Apellido: ");
        maidennField = new JTextField(12);
        
        addButton = new JButton("Agregar Cliente");
        newAccountMsg = new JTextField("Cree un cliente nuevo.");
        newAccountMsg.setEditable(false);
        
        add(nameLabel);
        add(nameField);
        
        add(lastnLabel);
        add(lastnField);
        
        add(maidennLabel);
        add(maidennField);
        
        add(addButton);
        add(newAccountMsg);
        
        GridLayout layout = new GridLayout(4, 2);
        setLayout(layout);
        setVisible(true);
        
        ListenerBoton1 listenerBoton = new ListenerBoton1();
        addButton.addActionListener(listenerBoton);
        
    }
    public class ListenerBoton1 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Se ha creado un nuevo cliente.");
        if (event.getSource() == addButton) {
            String name = (String)nameField.getText();
            String lastname = (String)lastnField.getText();
            String maidenname = (String)maidennField.getText();
            int numCuenta = (int)(Math.random() * (10000000 - 19999999) + 10000000);
            ComProject2.first[Cliente.counter].setName(name);
            ComProject2.first[Cliente.counter].setLastN(lastname);
            ComProject2.first[Cliente.counter].setMaidenN(maidenname);
            ComProject2.first[Cliente.counter].setNumCuenta(String.valueOf(numCuenta));
            System.out.println(numCuenta);
            newAccountMsg.setText(String.valueOf("Num Cliente: " + numCuenta));
            DisplayAccountPanel.accountNum.setText(String.valueOf(numCuenta));
            DisplayAccountPanel.accountMoneyAmount.setText("0");
            TransactionsPanel.depositoField.setEditable(true);
            TransactionsPanel.retiroField.setEditable(true);
            }
        }
    }
}

class AccountPanel extends JPanel {
    public String arrayOptions[] = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    public JComboBox displayAccounts; // selecciona la cuenta por index
    public JLabel displayAccountLabel; // etiqueta de seleccion 
        
    // el constructor agrega los objetos
    public AccountPanel() {
        super();
        JComboBox displayAccounts = new JComboBox(arrayOptions);
        displayAccountLabel = new JLabel("Seleccione la cuenta");
        
        displayAccounts.setMaximumRowCount(arrayOptions.length);
        add(displayAccountLabel);
        add(displayAccounts);
        
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setVisible(true);
       
        displayAccounts.addItemListener(
            new ItemListener() {
                    public void itemStateChanged(ItemEvent event) throws NullPointerException {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            int index = displayAccounts.getSelectedIndex();
                            // desplegar num cuenta 
                            String numeroDesplegar = ComProject2.first[index].getNumCuenta();
                            String saldoDesplegar = String.valueOf(ComProject2.first[index].getMoney());
                            if (numeroDesplegar != null) {
                                DisplayAccountPanel.accountNum.setText(numeroDesplegar);
                                DisplayAccountPanel.accountMoneyAmount.setText(saldoDesplegar);
                            } else {
                                DisplayAccountPanel.accountNum.setText("Cliente no existe");
                                DisplayAccountPanel.accountMoneyAmount.setText("0");
                            }
                    }
                }
            }
        );
    }
}

class DisplayAccountPanel extends JPanel {
    private JLabel numCuenta; // etiqueta de numero de cuenta
    public static JTextField accountNum; // campo de numero de cuenta
    private JLabel accountMoney; // etiqueta del saldo
    public static JTextField accountMoneyAmount; // muestra el dinero 
    
    // el constructor agrega los objetos
    DisplayAccountPanel() {
        super();
        numCuenta = new JLabel("Num Cliente: ");
        accountNum = new JTextField(8);
        accountNum.setEditable(false);
        accountMoney = new JLabel("Saldo: ");
        accountMoneyAmount = new JTextField(12);
        accountMoneyAmount.setEditable(false);
        
        add(numCuenta);
        add(accountNum);
        add(accountMoney);
        add(accountMoneyAmount);
        
        GridLayout layout = new GridLayout(3, 1);
        setLayout(layout);
        setVisible(true);
    }
}

class TransactionsPanel extends JPanel {
    private JLabel depositoLabel; // etiqueta deposito
    static public JTextField depositoField; // campo de deposito;
    private JButton depositoBoton; // boton deposito
    
    private JLabel retiroLabel; // etiqueta retiro
    static public JTextField retiroField; // campo de retiro
    private JButton retiroBoton; // boton retiro
    
    TransactionsPanel() {
        depositoLabel = new JLabel("Deposito: ");
        depositoField = new JTextField(12);
        depositoBoton = new JButton("Ejecutar");
        
        retiroLabel = new JLabel("Retiro: ");
        retiroField = new JTextField(12);
        retiroBoton = new JButton("Ejecutar");
        
        add(depositoLabel);
        add(depositoField);
        add(depositoBoton);
        
        add(retiroLabel);
        add(retiroField);
        add(retiroBoton);
        
        depositoField.setEditable(false);
        retiroField.setEditable(false);
        
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setVisible(true);
        
        ListenerBoton1 listenerBoton = new ListenerBoton1();
        depositoBoton.addActionListener(listenerBoton);
        
        ListenerBoton1 listenerBoton2 = new ListenerBoton1();
       retiroBoton.addActionListener(listenerBoton2);
        

    }
    public class ListenerBoton1 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == depositoBoton) {
                String deposito = (String)depositoField.getText();

                ComProject2.first[Cliente.counter].addSaldo(deposito);
                DisplayAccountPanel.accountMoneyAmount.setText(String.valueOf(ComProject2.first[Cliente.counter].getMoney()));
                JOptionPane.showMessageDialog(null, "Transaccion Exitosa.");
                
            } else if (event.getSource() == retiroBoton) {
                String retiro = (String)retiroField.getText();

                ComProject2.first[Cliente.counter].substractSaldo(retiro);
                DisplayAccountPanel.accountMoneyAmount.setText(String.valueOf(ComProject2.first[Cliente.counter].getMoney()));
                JOptionPane.showMessageDialog(null, "Transaccion Exitosa.");
            }
        }
    }    
}