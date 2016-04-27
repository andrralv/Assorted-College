package proyecto.gui;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author andre
 */
public class PanelTransaccion extends JPanel {
     // labels y textos para paneltransaccion
    private JLabel labelCodigoComercio;

    public JTextField fieldCodigoComercio;
    private JLabel labelFechaHora;
    public JTextField fieldFechaHora;
    private JLabel labelFechaLicencia;
    public JTextField fieldFechaLicencia;
    private JLabel labelMonto;
    public JTextField fieldMonto;
    private JLabel labelTransaccion;
    public JTextField fieldTransaccion;
    public JComboBox boxListaTransacciones;
    private PanelBotonesTransacciones botones;
    
    public PanelTransaccion() {
        String transacciones = "Transacciones";
        JLabel transaccionesLabel = new JLabel(transacciones);
        transaccionesLabel.setBorder(new EmptyBorder(15, 2, 15, 2));
        transaccionesLabel.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(transaccionesLabel);
        //
        String codigoComercio = "Codigo Comercio: ";
        labelCodigoComercio = new JLabel(codigoComercio);
        labelCodigoComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);  
        add(labelCodigoComercio);
        //
        fieldCodigoComercio = new JTextField(4);
        add(fieldCodigoComercio);
        //
        String fechaTransaccion = "Fecha Transaccion: ";
        labelFechaHora= new JLabel(fechaTransaccion);    
        labelFechaHora.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelFechaHora);
        //
        fieldFechaHora = new JTextField(12);
        add(fieldFechaHora);
        //
        String fechaLicencia = "Expiracion de Licencia: ";
        labelFechaLicencia = new JLabel(fechaLicencia);
        labelFechaLicencia.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelFechaLicencia);
        //
        fieldFechaLicencia = new JTextField(12);
        add(fieldFechaLicencia);
        //
        String montoTransaccion = "Monto: ";
        labelMonto = new JLabel(montoTransaccion);
        labelMonto.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelMonto);
        //
        fieldMonto = new JTextField(12);
        add(fieldMonto);
        //
        String numeroTransaccion = "Transaccion No: ";
        labelTransaccion = new JLabel(numeroTransaccion);
        labelTransaccion.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelTransaccion);
        //
        fieldTransaccion = new JTextField(12);
        add(fieldTransaccion);
        //
        boxListaTransacciones = new JComboBox();
        boxListaTransacciones.setBorder(new EmptyBorder(10, 2, 10, 2));
        add(boxListaTransacciones);
        //
        botones = new PanelBotonesTransacciones(this);
        add(botones);
        //
    }
}
