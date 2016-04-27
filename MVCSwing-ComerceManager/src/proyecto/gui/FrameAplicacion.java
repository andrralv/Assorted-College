package proyecto.gui;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.border.*;


/**
 * @author andre
 */
public class FrameAplicacion extends JFrame{
    PanelComercio panelTop;
    PanelTransaccion panelBottom;
    
    public FrameAplicacion() {
        // frame data
        super("Administrador de Comecios");
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
    }
    
}
