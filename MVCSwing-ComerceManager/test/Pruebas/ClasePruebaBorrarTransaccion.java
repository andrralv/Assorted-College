package Pruebas;

import javax.xml.transform.TransformerException;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author andre
 */
public class ClasePruebaBorrarTransaccion {
    @Test 
    public void prueba1() throws TransformerException {
        proyecto.model.BorrarTransaccion transborra = new proyecto.model.BorrarTransaccion(552);
        Document doc = transborra.manageDocument("archivoTransaccion.xml");

        boolean foo = transborra.borrarRegistro(doc, 555);
        System.out.println(foo);
    }
}