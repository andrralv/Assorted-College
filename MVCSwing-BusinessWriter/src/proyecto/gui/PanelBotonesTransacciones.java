package proyecto.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author andre
 */
public class PanelBotonesTransacciones extends JPanel {

    private JButton agregarTransaccion;
    private JButton borrarTransaccion;
    private ButtonGroup grupoTransacciones;

    public PanelBotonesTransacciones() {
    
    agregarTransaccion = new JButton("Agregar Transaccion");
    borrarTransaccion = new JButton("Borrar Transaccion");
    grupoTransacciones = new ButtonGroup();
    grupoTransacciones.add(agregarTransaccion);
    grupoTransacciones.add(borrarTransaccion);
    add(agregarTransaccion);
    add(borrarTransaccion);
    }    
    
    public JButton getAgregarTransaccion() {
        return agregarTransaccion;
    }

    public JButton getBorrarTransaccion() {
        return borrarTransaccion;
    }
}