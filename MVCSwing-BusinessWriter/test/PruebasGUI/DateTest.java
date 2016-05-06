/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasGUI;

import java.util.Date;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class DateTest {
    
    proyecto.Utilidades.getDate getFecha = new proyecto.Utilidades.getDate();

    @Test
    public void prueba() throws Exception {
        Date date = getFecha.getFecha("00-00-0000", false);
    }
    
    @Test
    public void prueba2() throws Exception  {
        String hi = "h";
        proyecto.gui.FrameAplicacion gui = new proyecto.gui.FrameAplicacion();
        if (gui.getFechaComercioLicencia() == null) {
            hi = "bad";
        } else if (gui.getFechaComercioLicencia().equals("")) {
            hi = "hih";
        } else {
            hi = "shit";
        }
        System.out.println(hi);
        
    }
}
