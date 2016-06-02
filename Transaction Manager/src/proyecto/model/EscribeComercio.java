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
 * ESCRIBE UN COMERCIO NUEVO EN EL ARCHIVO XML
 */
public class EscribeComercio extends ManageDocument {
     
    public boolean writeData(String nombreDocumento, int codigo, String nombre, 
String descripcion, Date fecha, Date fechaLicencia, String ubicacion, int telefono, char estado)
            throws TransformerConfigurationException, TransformerException {
        Document document = manageDocument(nombreDocumento);
        // escribe datos en el documento
        boolean test;
        File file = null;
        // casting de variables a string
        String codigoString = Integer.toString(codigo);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaString = formatter.format(fecha);
        String fechaLicenciaString = formatter.format(fechaLicencia);
        String telefonoString = Integer.toString(telefono);
        String stringEstado = Character.toString(estado);
        try {
        file = new File("archivoComercio.xml");
        // *** inicio de datos del archivo
        // elemento raiz
        Element raiz = null;
        if (document.getDocumentElement() == null) {
            raiz = document.createElement("comercios");
            document.appendChild(raiz);
        } else {
            raiz = document.getDocumentElement();
        }
        // nuevo nodo
        Element comercio = document.createElement("comercio");
        raiz.appendChild(comercio);
        // elemento codigo comercio
        Element codigoComercio = document.createElement("codigo-comercio");
        codigoComercio.setTextContent(codigoString);
        comercio.appendChild(codigoComercio);
        // elemento nombre comercio
        Element nombreComercio = document.createElement("nombre-comercio");
        nombreComercio.setTextContent(nombre);
        comercio.appendChild(nombreComercio);
        //elemento descripcion
        Element descripcionComercio = document.createElement("descripcion");
        descripcionComercio.setTextContent(descripcion);
        comercio.appendChild(descripcionComercio);
        //elemento fecha
        Element fechaComercio = document.createElement("fecha-creacion");
        fechaComercio.setTextContent(fechaString);
        comercio.appendChild(fechaComercio);
        // elemento fecha licencia
        Element fechaLicenciaComercio = document.createElement("licencia-comercio");
        fechaLicenciaComercio.setTextContent(fechaLicenciaString);
        comercio.appendChild(fechaLicenciaComercio);
        // elemento ubicacion
        Element ubicacionComercio = document.createElement("ubicacion");
        ubicacionComercio.setTextContent(ubicacion);
        comercio.appendChild(ubicacionComercio);
        // elemento telefono
        Element telefonoComercio = document.createElement("telefono");
        telefonoComercio.setTextContent(telefonoString);
        comercio.appendChild(telefonoComercio);
        // elemento estado
        Element estadoComercio = document.createElement("estado");
        estadoComercio.setTextContent(stringEstado);
        comercio.appendChild(estadoComercio);
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
        
        test = true;
        } catch (Exception e) {
            e.getMessage();
            test = false;  
        }
    return test;
    }
}
