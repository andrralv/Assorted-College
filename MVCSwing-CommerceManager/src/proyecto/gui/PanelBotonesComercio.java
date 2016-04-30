package proyecto.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author andre
 */
public class PanelBotonesComercio extends JPanel {
    // botones para panelcomercio
    private JButton agregarComercio;
    private JButton borrarComercio;
    private ButtonGroup grupoComercios;

    // recibe los espacios
    public String nombreComercio;
    public String codigoComercio;
    public String descripcionComercio;
    public String creacionComercio;
    public String direccionComercio;


    public PanelBotonesComercio(String n, String h, String d, String c, String di) {
    this.nombreComercio = n;
    this.codigoComercio = h;
    this.descripcionComercio = d;
    this.creacionComercio = c;
    this.direccionComercio = di;
        
    ManejadorBotonComercio manejador = new ManejadorBotonComercio();    
    //    
    agregarComercio = new JButton("Agregar Comercio");
    agregarComercio.addActionListener(manejador);
    borrarComercio = new JButton("Borrar Comercio");
    agregarComercio.addActionListener(manejador);
    grupoComercios = new ButtonGroup();
    grupoComercios.add(agregarComercio);
    grupoComercios.add(borrarComercio);
    add(agregarComercio);
    add(borrarComercio);
    }
    
    public class ManejadorBotonComercio implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == agregarComercio) {
                // 1. crea un objeto comercio
                // 2. lo agrega al arraylist
                // 3. tira un joptionpane que

                
            } else if (e.getSource() == borrarComercio) {
                // do that
            }
        }
    }
}