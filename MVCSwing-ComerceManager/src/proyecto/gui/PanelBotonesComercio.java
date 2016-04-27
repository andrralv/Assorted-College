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

    private JButton agregarComercio;
    private JButton borrarComercio;
    private ButtonGroup grupoComercios;
    // botones para panelcomercio

    public PanelBotonesComercio() {
    
        
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
                // do this
                
            } else if (e.getSource() == borrarComercio) {
                // do that
            }
        }
    }
}