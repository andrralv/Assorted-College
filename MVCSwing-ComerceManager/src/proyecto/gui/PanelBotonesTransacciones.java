package proyecto.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public PanelTransaccion thisTransaccion;
    // botones para panelcomercio

    public PanelBotonesTransacciones(PanelTransaccion transaccion) {
    
    agregarTransaccion = new JButton("Agregar Transaccion");
    borrarTransaccion = new JButton("Borrar Transaccion");
    grupoTransacciones = new ButtonGroup();
    grupoTransacciones.add(agregarTransaccion);
    grupoTransacciones.add(borrarTransaccion);
    add(agregarTransaccion);
    add(borrarTransaccion);
    
    thisTransaccion = transaccion;
    }    

    class ManejadorBotonTransaccion implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == agregarTransaccion) {
                String codigo = thisTransaccion.fieldCodigoComercio.getText();
                String fechaHora = thisTransaccion.fieldFechaHora.getText();
                String fechaLicencia = thisTransaccion.fieldFechaLicencia.getText();
                String monto = thisTransaccion.fieldMonto.getText();
                String numeroTrans = thisTransaccion.fieldTransaccion.getText();

                
            } else if (e.getSource() == borrarTransaccion) {
                String codigo = thisTransaccion.fieldCodigoComercio.getText();
            }
        }
    }
}