package proyecto.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author andre
 * Utilidades estaticas para el modelo
 */

public class Utilidades {
    // convierte un string en una fecha
    public static Date getFecha(String date){
        String startDateString = date;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date startDate = null;
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return startDate;
    }
}
