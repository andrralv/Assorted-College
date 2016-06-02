package Pruebas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.junit.Test;

/**
 * @author andre
 */

/*
public class ClasePruebaComercio {
    @Test 
    public void prueba1() throws TransformerException {

        Document doc = thisComercio.manageDocument("C:\\Users\\archivoComercio.xml");
        Date fecha = new Date();
        Date futureDate = getFechaFutura("08/23/2018");
        thisComercio.writeData(doc, 3288, "Lenovo", "Fabricantes de computadoras chinas", fecha, futureDate, "Hong Kong",
                88542222, 'S');
    }
    
    public Date getFechaFutura(String date){
        String startDateString = date;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        Date startDate = null;
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return startDate;
    }
}
*/