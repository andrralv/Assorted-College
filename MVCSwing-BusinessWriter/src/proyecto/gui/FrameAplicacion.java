package proyecto.gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.*;
        
/**
 * @author andre
 */
public class FrameAplicacion extends JFrame{
    private PanelComercio panelTop;
    private PanelTransaccion panelBottom;
    public proyecto.Utilidades.getDate getFecha;
    String dateStringComercio;
    String dateStringLicencia;
    public FrameAplicacion() throws ParseException {
        // frame data
        super("Administrador de Comercios");
        setLayout(new GridLayout(1, 2));
        // panel de comercio
        panelTop = new PanelComercio();
        BoxLayout layout = new BoxLayout(panelTop, BoxLayout.Y_AXIS);       
        panelTop.setLayout(layout);
        Border border = panelTop.getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        panelTop.setBorder(new CompoundBorder(border, margin));
        
        // panel de transacciones       
        panelBottom = new PanelTransaccion();
        BoxLayout layout2 = new BoxLayout(panelBottom, BoxLayout.Y_AXIS);
        panelBottom.setLayout(layout2);
        Border border2 = panelBottom.getBorder();
        Border margin2 = new EmptyBorder(10,10,10,10);
        panelBottom.setBorder(new CompoundBorder(border2, margin2));

        // agregar paneles
        add(panelTop);
        add(panelBottom);
        
        // get dates
        
        if (panelTop.datePicker.getJFormattedTextField().getText().equals("") || 
                panelTop.datePickerLicencia.getJFormattedTextField().getText().equals("")){
            dateStringComercio = "00-00-0000";
            dateStringLicencia = "00-00-0000";

        } else {
            dateStringComercio = panelTop.datePicker.getJFormattedTextField().getText();
            dateStringComercio = panelTop.datePicker.getJFormattedTextField().getText();
        }
    }
    
    // **************** GETTERS DE PANELES ***************
    public PanelComercio getPanelTop() {
        return panelTop;
    }

    public PanelTransaccion getPanelBottom() {
        return panelBottom;
    }
    
    // *********** GETTERS DE ELEMENTOS EN COMERCIO **************
    public String getNombreComercio() {
        return panelTop.fieldNombreComercio.getText();
    }
    
     public String getCodigoComercio() {
        return panelTop.fieldCodigoComercio.getText();
    }
     
    public String getTelefonoComercio() {
        return panelTop.fieldTelefonoComercio.getText();
    }
    
    public String getDescripcionComercio() {
        return panelTop.fieldDescripcionComercio.getText();
    }
        
    public Date getFechaComercio() throws NullPointerException, ParseException {
         String comercioString = panelTop.datePicker.getJFormattedTextField().getText();
         if (comercioString.equals("")) {
             comercioString = "0000-00-00";
         }
         this.getFecha = new proyecto.Utilidades.getDate();
         return this.getFecha.getFecha(comercioString, false);
    }
    
    public Date getFechaComercioLicencia() throws NullPointerException, ParseException {
         String licenciaString = panelTop.datePickerLicencia.getJFormattedTextField().getText();
         if (licenciaString.equals("")) {
             licenciaString = "0000-00-00";
         }
         this.getFecha = new proyecto.Utilidades.getDate();
         return this.getFecha.getFecha(licenciaString, false);
    }
    
       public Date getFechaTrans() throws NullPointerException, ParseException {
         String transString = panelBottom.datePickerTrans.getJFormattedTextField().getText();
         if (transString.equals("")) {
             transString = "0000-00-00";
         }
         this.getFecha = new proyecto.Utilidades.getDate();
         return this.getFecha.getFecha(transString, false);
    }
    
    public String getUbicacionComercio() {
        return panelTop.fieldUbicacionComercio.getText();
    }
   
    public String getEstadoComercio() {
        // posibilidad de excepcion
        return panelTop.estadosBox.getSelectedItem().toString();
    }
    
    public String getSelectedComercio() {
        // posibilidad de excepcion
        return panelTop.boxListaComercios.getSelectedItem().toString();
    }
    
    // ************ AGREGAR LISTENERS A BOTONES COMERCIO ***************
    
    public void addListenerAgregarComercio(ActionListener listener) {
        panelTop.getBotones().getAgregarComercio().addActionListener(listener);
    }
    
    public void addListenerBorrarComercio(ActionListener listener) {
        panelTop.getBotones().getBorrarComercio().addActionListener(listener);
    }
    
    //*********** GETTERS DE ELEMENTOS EN TRANSACCION ***************
    
    public String getCodigoComercioTrans() {
        return panelBottom.fieldCodigoComercio.getText();
    }    
    
    
    public String getMonto() {
        return panelBottom.fieldMonto.getText();
    }
    
    public String getTransNum() {
        return panelBottom.fieldTransaccion.getText();
    }
    
    public String getEstadoTrans() {
        // posibilidad de excepcion
        return panelBottom.estadosBoxT.getSelectedItem().toString();
    }
    
    public String getSelectedTransaccion() {
        // posibilidad de excepcion
        return panelBottom.boxListaTransacciones.getSelectedItem().toString();
    }
    
    // *************** SETTERS DE ELEMENTOS EN COMERCIO ****************
    
    public void setNombreComercio(String nombre) {
        panelTop.fieldNombreComercio.setText(nombre);
    }
    
    public void setCodigoComercio(String codigo) {
        panelTop.fieldCodigoComercio.setText(codigo);
    }
    
    public void setTelefonoComercio(String telefono) {
        panelTop.fieldTelefonoComercio.setText(telefono);
    }
    
    public void setUbicacionComercio(String ubicacion) {
        panelTop.fieldUbicacionComercio.setText(ubicacion);
    }
    
    public void setDescripcionComercio(String descripcion) {
        panelTop.fieldDescripcionComercio.setText(descripcion);
    }
    
    public void setEstadoComercio(char estado) {
        int index = 0;
        if (estado == 'A'){
            index = 1;
        } else if (estado == 'I') {
            index = 2;
        }
        panelTop.estadosBox.setSelectedIndex(index);
    }
    
    // ************ AGREGAR LISTENERS A BOTONES TRANSACCION ***************
    
    public void addListenerAgregarTransaccion(ActionListener listener) {
        panelBottom.getBotones().getAgregarTransaccion().addActionListener(listener);
    }
    
    public void addListenerBorrarTransaccion(ActionListener listener) {
        panelBottom.getBotones().getBorrarTransaccion().addActionListener(listener);
    }
    
    // ************* ERROR MESSAGE AND DISPLAY MESSAGE *************
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }   
    public JComboBox getComerciosLista() {
        return panelTop.getComerciosBox();
    }
    public JComboBox getTransaccionesLista() {
        return panelBottom.getTransaccionesBox();
    }
    
    public void addListenerItemComercio(ItemListener listener) {
        panelTop.getComerciosBox().addItemListener(listener);
    }
    
}
