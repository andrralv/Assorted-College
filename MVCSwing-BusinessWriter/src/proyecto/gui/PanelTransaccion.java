package proyecto.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
    private JLabel labelMonto;
    public JTextField fieldMonto;
    private JLabel labelTransaccion;
    public JTextField fieldTransaccion;
    public JComboBox boxListaTransacciones;
    private PanelBotonesTransacciones botones;
    public JComboBox estadosBoxT;
    private String[] estados = {"", "Denegada", "Nula", "Aprobada"};
    private JLabel estadosLabel;
    public JDatePickerImpl datePickerTrans;
    
    
    public PanelTransaccion() {
        String transacciones = "Transacciones";
        JLabel transaccionesLabel = new JLabel(transacciones);
        transaccionesLabel.setBorder(new EmptyBorder(15, 2, 15, 2));
        transaccionesLabel.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(transaccionesLabel);
        // codigo
        String codigoComercio = "Codigo Comercio: ";
        labelCodigoComercio = new JLabel(codigoComercio);
        labelCodigoComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);  
        add(labelCodigoComercio);
        // field codigo
        fieldCodigoComercio = new JTextField(32);
        fieldCodigoComercio.setMaximumSize(fieldCodigoComercio.getPreferredSize());
        add(fieldCodigoComercio);
        // fecha hora
        String fechaTransaccion = "Fecha Transaccion: ";
        labelFechaHora= new JLabel(fechaTransaccion);    
        labelFechaHora.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelFechaHora);
        // fecha hora field
        // fecha field
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // picker 
        datePickerTrans = new JDatePickerImpl(datePanel, new proyecto.Utilidades.DateLabelFormatter());
        add(datePickerTrans);
        // monto
        String montoTransaccion = "Monto: ";
        labelMonto = new JLabel(montoTransaccion);
        labelMonto.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelMonto);
        // monto field
        fieldMonto = new JTextField(32);
        fieldMonto.setMaximumSize(fieldMonto.getPreferredSize());
        add(fieldMonto);
        // numero 
        String numeroTransaccion = "Transaccion No: ";
        labelTransaccion = new JLabel(numeroTransaccion);
        labelTransaccion.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelTransaccion);
        // numero field
        fieldTransaccion = new JTextField(32);
        fieldTransaccion.setMaximumSize(fieldTransaccion.getPreferredSize());
        add(fieldTransaccion);
        // estados 
        estadosLabel = new JLabel("Estado:");
        estadosLabel.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(estadosLabel);
        // dimension
        Dimension dimension = new Dimension(300, 200);
        // lista estados 
        estadosBoxT = new JComboBox<>(estados);
        estadosBoxT.setMaximumSize(dimension);
        add(estadosBoxT);
        // transacciones
        transaccionesLabel = new JLabel("Transacciones: ");
        transaccionesLabel.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(transaccionesLabel);
        // lista dinamica de transacciones
        boxListaTransacciones = new JComboBox();
        boxListaTransacciones.setBorder(new EmptyBorder(10, 2, 10, 2));
        boxListaTransacciones.setMaximumSize(dimension);
        add(boxListaTransacciones);
        //
        botones = new PanelBotonesTransacciones();
        add(botones);     
    }
    
    public PanelBotonesTransacciones getBotones() {
        return botones;
    }
    public JComboBox getTransaccionesBox() {
        return boxListaTransacciones;
    }
}
