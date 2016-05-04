package proyecto.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;

public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
    DateLabelFormatter formatter = null;
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        formatter = (DateLabelFormatter) dateFormatter.parseObject(text);
        return formatter;
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        String returnValue;
        if (value != null) {
            Calendar cal = (Calendar) value;
            returnValue = dateFormatter.format(cal.getTime());
        } else {
            returnValue = "0000-00-00";
        }
    return returnValue;
    }
}