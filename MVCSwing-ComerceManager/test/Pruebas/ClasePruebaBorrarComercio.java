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
        proyecto.model.BorrarComercio borracomer = new proyecto.model.BorrarComercio(552);
        Document doc = borracomer.manageDocument("archivoComercio.xml");

        boolean foo = borracomer.borrarRegistro(doc, 3288);
        System.out.println(foo);
    }
}