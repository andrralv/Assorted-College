package Pruebas;

import javax.xml.transform.TransformerException;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author andre
 */
public class ClasePruebaBorrarComercio {
    @Test 
    public void prueba1() throws TransformerException {
        proyecto.model.BorrarComercio borracomer = new proyecto.model.BorrarComercio();

        borracomer.borrarRegistro(2323);
        System.out.println();
    }
}