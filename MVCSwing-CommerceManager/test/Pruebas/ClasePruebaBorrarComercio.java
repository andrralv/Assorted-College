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
        Document doc = borracomer.manageDocument("archivoComercio.xml");

        borracomer.borrarRegistro(55555);
        System.out.println();
    }
}