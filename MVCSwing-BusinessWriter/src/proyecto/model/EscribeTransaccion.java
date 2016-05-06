package proyecto.model;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Realizado por andre rodriguez el 4/23/2016
 * ESCRIBE UNA TRANSACCION NUEVA EN EL ARCHIVO XML
 */
public class EscribeTransaccion extends ManageDocument {
    
    public void writeData(int codigoComercio, Date fechaTiempo, 
    double monto, int numAutorizacion, char estado)
            throws TransformerConfigurationException, TransformerException {
        Document document = manageDocument("archivoTransaccion.xml");
        // escribe datos en el documento
        File file = null;
        // casting de variables a string
        String codigoComercioString = Integer.toString(codigoComercio);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaString = formatter.format(fechaTiempo);
        String montoString = String.valueOf(monto);
        String numAutString = Integer.toString(numAutorizacion);
        String estadoString = Character.toString(estado);
        int lenTransacciones;

        try {
            file = new File("archivoTransaccion.xml");
            // *** inicio de datos del archivo
            // elemento raiz
            Element raiz = null; 
        if (document.getDocumentElement() == null) {
                raiz = document.createElement("transacciones");
                document.appendChild(raiz);
            } else {
                raiz = document.getDocumentElement();
            }
            lenTransacciones = raiz.getElementsByTagName("transaccion").getLength();
            String lenToString = Integer.toString(lenTransacciones);
            // nuevo nodo
            Element transaccion = document.createElement("transaccion");
            raiz.appendChild(transaccion);
            transaccion.setAttribute("numero", lenToString);
        
            // elemento codigo comercio
            Element codigoComercioTransaccion = document.createElement("codigo-comercio");
            codigoComercioTransaccion.setTextContent(codigoComercioString);
            transaccion.appendChild(codigoComercioTransaccion);
            // elemento nombre comercio
            Element fechaTransaccion = document.createElement("fecha-transaccion");
            fechaTransaccion.setTextContent(fechaString);
            transaccion.appendChild(fechaTransaccion);
            //elemento descripcion
            Element montoTransaccion = document.createElement("monto");
            montoTransaccion.setTextContent(montoString);
            transaccion.appendChild(montoTransaccion);
            //elemento fecha
            Element numTransaccion = document.createElement("numero-transaccion");
            numTransaccion.setTextContent(numAutString);
            transaccion.appendChild(numTransaccion);
            // elemento fecha licencia
            Element estadoTransaccion = document.createElement("estado-transaccion");
            estadoTransaccion.setTextContent(estadoString);
            transaccion.appendChild(estadoTransaccion);
            // *** fin de datos del archivo
        
            // clase para escribir archivos xml en DOM 
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // agrega indentacion al archivo xml
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            // toma el parametro de documento
            DOMSource source = new DOMSource(document);
            // usa el archivo definido al principio de la clase
            StreamResult result = new StreamResult(file);
            // escribe al archivo
            transformer.transform(source, result);
            // escribe a la consola para testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        
            } catch (Exception e) {
                e.printStackTrace();
                String msg = e.getMessage();
                System.err.println(msg); 
        }
    }
}
