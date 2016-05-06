package proyecto.Utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author andre
 getDate estaticas para el modelo
 */

public class getDate {
    // convierte un string en una fecha
    public Date getFecha(String date, boolean withHours) throws ParseException{
        String startDateString = date;
        Date startDate = null;

        // si boolean es true incluye horas
        DateFormat df = (withHours) ? new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss", Locale.ENGLISH) 
                : new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    return startDate;
    }
}

