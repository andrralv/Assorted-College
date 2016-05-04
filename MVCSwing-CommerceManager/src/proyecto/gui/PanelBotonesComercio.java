package proyecto.gui;

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

    public PanelBotonesComercio() {
  
    agregarComercio = new JButton("Agregar Comercio");
    borrarComercio = new JButton("Borrar Comercio");
    grupoComercios = new ButtonGroup();
    grupoComercios.add(agregarComercio);
    grupoComercios.add(borrarComercio);
    add(agregarComercio);
    add(borrarComercio);
    }
    
    public JButton getAgregarComercio() {
        return agregarComercio;
    }

    public JButton getBorrarComercio() {
        return borrarComercio;
    }
}