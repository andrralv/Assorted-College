package proyecto.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author andre
 */
public class ComerciosManager {
    public static void main(String args[]) throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, 
            UnsupportedLookAndFeelException {
        // instancia el frame
        //tira excepciones si no es soportado el lookandfeel
        FrameAplicacion aplicacion = new FrameAplicacion();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        aplicacion.setSize(700, 500); // tamano del marco
        aplicacion.setVisible(true);
        aplicacion.setResizable(false); // for now
    } // fin de main
} // fin de la aplicacion
