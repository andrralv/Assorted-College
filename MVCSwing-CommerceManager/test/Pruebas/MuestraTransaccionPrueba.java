package Pruebas;

import java.util.Date;
import javax.xml.transform.TransformerException;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author andre
 */
public class MuestraTransaccionPrueba {
    @Test 
    public void prueba1() throws TransformerException {
        proyecto.model.MuestraTransaccionData transaccion = new proyecto.model.MuestraTransaccionData();
        Document doc = transaccion.manageDocument("archivoTransaccion.xml");

        proyecto.model.Transaccion foo = transaccion.showData(doc, 1235);
        System.out.println(foo.getFechaTiempoAutorizacion());
        System.out.println(foo.getMonto());
        
    }
}