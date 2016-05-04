package proyecto.controller;

import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import proyecto.gui.FrameAplicacion;

/**
 * @author andre
 */
public class ComerciosManager {
    public ListaComercios lista;
    public static void main(String args[]) throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, 
            UnsupportedLookAndFeelException, ParseException {
        // instancia el frame
        // tira excepciones si no es soportado el lookandfeel
        FrameAplicacion aplicacionView = new FrameAplicacion();
        aplicacionView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        aplicacionView.setSize(700, 500); // tamano del marco
            aplicacionView.setVisible(true);
            aplicacionView.setResizable(false);
            
        proyecto.model.Modelo aplicacionModel = new proyecto.model.Modelo();
        
        proyecto.controller.ObjetoControlador aplicacionControlador = new 
        proyecto.controller.ObjetoControlador(aplicacionView, aplicacionModel);
    } // fin de main
} // fin de la aplicacion
