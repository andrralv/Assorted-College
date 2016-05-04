package proyecto.gui;

import java.awt.Component;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * @author andre
 */
public class PanelComercio extends JPanel {
    // labels y textos para panelcomercio
    private JLabel labelNombreComercio;
    public JTextField fieldNombreComercio;
    private JLabel labelCodigoComercio;
    public JTextField fieldCodigoComercio;
    private JLabel labelTelefonoComercio;
    public JTextField fieldTelefonoComercio;
    private JLabel labelDescripcionComercio;
    public JTextField fieldDescripcionComercio;
    private JLabel labelCreacionComercio;
    private JLabel labelFechaLicencia;
    private JLabel labelUbicacionComercio;
    public JTextField fieldUbicacionComercio;
    public JComboBox boxListaComercios;
    private PanelBotonesComercio botones;
    public String[] estados = {"", "Activo", "Inactivo"};
    private JLabel labelEstados;
    public JComboBox estadosBox;
    private JLabel labelComercios;
    public JDatePickerImpl datePicker;
    public JDatePickerImpl datePickerLicencia;
    
    @SuppressWarnings("unchecked")
    public PanelComercio() {
        // title label
        String comercios = "Comercios";
        JLabel comerciosLabel = new JLabel(comercios);
        comerciosLabel.setBorder(new EmptyBorder(15, 2, 15, 2));
        comerciosLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(comerciosLabel);
        // nombre
        String nombreComercio = "Nombre Comercio: ";
        labelNombreComercio = new JLabel(nombreComercio);
        labelNombreComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);  
        add(labelNombreComercio);
        // nombre field
        fieldNombreComercio = new JTextField(32);
        fieldNombreComercio.setMaximumSize(fieldNombreComercio.getPreferredSize());
        add(fieldNombreComercio);
        // codigo
        String codigoComercio = "Codigo Comercio: ";
        labelCodigoComercio = new JLabel(codigoComercio);
        labelCodigoComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelCodigoComercio);
        // codigo field
        fieldCodigoComercio = new JTextField(32);
        fieldCodigoComercio.setMaximumSize(fieldCodigoComercio.getPreferredSize());
        add(fieldCodigoComercio);
        // telefono
        labelTelefonoComercio = new JLabel("Telefono: ");
        labelTelefonoComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelTelefonoComercio);
        // telefono field
        fieldTelefonoComercio = new JTextField(32);
        fieldTelefonoComercio.setMaximumSize(fieldTelefonoComercio.getPreferredSize());
        add(fieldTelefonoComercio);
        // descripcion
        String descripcionComercio = "Descripcion Comercio: ";
        labelDescripcionComercio = new JLabel(descripcionComercio);
        labelDescripcionComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelDescripcionComercio);
        // descripcion field
        fieldDescripcionComercio = new JTextField(32);
        fieldTelefonoComercio.setMaximumSize(fieldTelefonoComercio.getPreferredSize());
        add(fieldDescripcionComercio);
        // fecha
        String fechaComercio = "Fecha Creacion: ";
        labelCreacionComercio = new JLabel(fechaComercio);
        labelCreacionComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelCreacionComercio);
        // fecha field
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // picker 
        datePicker = new JDatePickerImpl(datePanel, new proyecto.Utilidades.DateLabelFormatter());
        add(datePicker);
        //fecha licencia 
        String fechaLicencia = "Expiracion de Licencia: ";
        labelFechaLicencia = new JLabel(fechaLicencia);
        labelFechaLicencia.setAlignmentX(Component.RIGHT_ALIGNMENT); 
        add(labelFechaLicencia);
        // picker
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Date");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanelLicencia = new JDatePanelImpl(model2, p2);
        datePickerLicencia = new JDatePickerImpl(datePanelLicencia, new proyecto.Utilidades.DateLabelFormatter());
        add(datePickerLicencia);
        // ubicacion
        String ubicacionComercio = "Ubicacion: ";
        labelUbicacionComercio = new JLabel(ubicacionComercio);
        labelUbicacionComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelUbicacionComercio);
        // ubicacion field
        fieldUbicacionComercio = new JTextField(32);
        fieldUbicacionComercio.setMaximumSize(fieldUbicacionComercio.getPreferredSize());
        add(fieldUbicacionComercio); 
        // estados
        labelEstados = new JLabel("Estado: ");
        labelEstados.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelEstados);
        // lista de estados
        estadosBox = new JComboBox<>(estados);
        add(estadosBox);
        // lista de comercios
        labelComercios = new JLabel("Comercios: ");
        labelComercios.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelComercios);
        // lista dinamica de comercios
        boxListaComercios = new JComboBox<>();
        boxListaComercios.setBorder(new EmptyBorder(10, 2, 10, 2));
        DefaultComboBoxModel modelBox = (DefaultComboBoxModel) boxListaComercios.getModel();
        boxListaComercios.setModel(modelBox);
        boxListaComercios.setModel(modelBox);
        add(boxListaComercios);
        
        botones = new PanelBotonesComercio();
        add(botones);
    }
    
    public PanelBotonesComercio getBotones() {
        return botones;
    }
}


