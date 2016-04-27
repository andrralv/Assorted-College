package proyecto.gui;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author andre
 */
public class PanelComercio extends JPanel {
    // labels y textos para panelcomercio
    private JLabel labelNombreComercio;
    public JTextField fieldNombreComercio;
    private JLabel labelCodigoComercio;
    public JTextField fieldCodigoComercio;
    private JLabel labelDescripcionComercio;
    public JTextField fieldDescripcionComercio;
    private JLabel labelCreacionComercio;
    public JTextField fieldCreacionComercio;
    private JLabel labelUbicacionComercio;
    public JTextField fieldUbicacionComercio;
    private JComboBox boxListaComercios;
    private PanelBotonesComercio botones;
    
    public PanelComercio() {
        String comercios = "Comercios";
        JLabel comerciosLabel = new JLabel(comercios);
        comerciosLabel.setBorder(new EmptyBorder(15, 2, 15, 2));
        comerciosLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(comerciosLabel);
        String nombreComercio = "Nombre Comercio: ";
        labelNombreComercio = new JLabel(nombreComercio);
        labelNombreComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);  
        add(labelNombreComercio);
        fieldNombreComercio = new JTextField(18);
        add(fieldNombreComercio);
        String codigoComercio = "Codigo Comercio: ";
        labelCodigoComercio = new JLabel(codigoComercio);
        labelCodigoComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelCodigoComercio);
        fieldCodigoComercio = new JTextField(4);
        add(fieldCodigoComercio);
        String descripcionComercio = "Descripcion Comecio: ";
        labelDescripcionComercio = new JLabel(descripcionComercio);
        labelDescripcionComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelDescripcionComercio);
        fieldDescripcionComercio = new JTextField(32);
        add(fieldDescripcionComercio);
        String fechaComercio = "Fecha Creacion (yyyy-MM-dd): ";
        labelCreacionComercio = new JLabel(fechaComercio);
        labelCreacionComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelCreacionComercio);
        fieldCreacionComercio = new JTextField(8);
        add(fieldCreacionComercio);
        String ubicacionComercio = "Ubicacion: ";
        labelUbicacionComercio = new JLabel(ubicacionComercio);
        labelUbicacionComercio.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(labelUbicacionComercio);
        fieldUbicacionComercio = new JTextField(18);
        add(fieldUbicacionComercio);       
        boxListaComercios = new JComboBox();
        boxListaComercios.setBorder(new EmptyBorder(10, 2, 10, 2));
        add(boxListaComercios);
        botones = new PanelBotonesComercio();
        add(botones);
    }
}
