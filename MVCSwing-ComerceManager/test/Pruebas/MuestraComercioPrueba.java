package Pruebas;

import java.util.Date;
import javax.xml.transform.TransformerException;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author andre
 */
public class MuestraComercioPrueba {
    @Test 
    public void prueba1() throws TransformerException {
        proyecto.model.MuestraComercioData comercio = new proyecto.model.MuestraComercioData();
        Document doc = comercio.manageDocument("archivoComercio.xml");

        proyecto.model.Comercio foo = comercio.showData(doc, 3212);
        System.out.println(foo.getDescripcion());
        System.out.println(foo.getFecha());
    }
}