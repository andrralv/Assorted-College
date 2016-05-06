package Pruebas;

import java.util.Date;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.junit.Test;

/**
 * @author andre
 */
public class ClasePruebaTransaccion {
    @Test 
    public void prueba1() throws TransformerException {
        proyecto.model.EscribeTransaccion thisTransaccion = new proyecto.model.EscribeTransaccion();
        Document doc = thisTransaccion.manageDocument("archivoTransaccion.xml");
        Date fecha = new Date();

        thisTransaccion.writeData(1235, fecha, 123587, 555, 'O');
    }

}