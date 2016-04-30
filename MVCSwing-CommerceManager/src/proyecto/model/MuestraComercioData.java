package proyecto.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author andre
 * DEVUELVE UN OBJECTO COMERCIO AL USAR UN CODIGO DE COMERCIO
 */

public class MuestraComercioData extends ManageDocument {
    public Comercio MuestraComercioData(int codigo) {
        Document doc = manageDocument("archivoComercio.xml");
        Comercio thisComercio = showData(doc, codigo);
        return thisComercio;

    }
    public Comercio showData(Document document, int codigo) {
        Element raiz = null;
        Comercio thisComercio = null;
        Node elNodo = null; // el nodo que vamos a tomar
        String codigoString = Integer.toString(codigo);
        try {
        // toma de elementos del archivo
        raiz = document.getDocumentElement();
        NodeList nodelist = raiz.getElementsByTagName("codigo-comercio");
        int len = nodelist.getLength();
            for (int i = 0; i < len; i++) {
                String nodeString = nodelist.item(i).getTextContent();
                if (nodeString.equals(codigoString)) {
                    // si encuentra el comercio
                    // toma el nodo
                    elNodo = nodelist.item(i).getParentNode();
                }
            }
            // remover nodos de espacio blanco
            NodeList nodes = elNodo.getChildNodes();
            for (int y = 0; y < nodes.getLength(); y++) {
                        if (nodes.item(y).getNodeType() == nodes.item(y).TEXT_NODE) {
                            nodes.item(y).getParentNode().removeChild(nodes.item(y));
                }
            }
            // objeto de getfecha
            // parsing datos y devolviendo un objeto comercio
            String codigoComercio = nodes.item(0).getTextContent();
            int codigoComercioInt = Integer.valueOf(codigoComercio);
            String nombreComercio = nodes.item(1).getTextContent();
            String descripcionComercio = nodes.item(2).getTextContent();
            String fechaCreacionComercio = nodes.item(3).getTextContent();
            Date fechaCreacionComercioDate = proyecto.Utilidades.Utilidades.getFecha(fechaCreacionComercio);
            String fechaLicenciaComercio = nodes.item(4).getTextContent();
            Date fechaLicenciaComercioDate = proyecto.Utilidades.Utilidades.getFecha(fechaLicenciaComercio);
            String ubicacionComercio = nodes.item(5).getTextContent();
            String telefonoComercio = nodes.item(6).getTextContent();
            int telefonoComercioInt = Integer.valueOf(telefonoComercio);
            String estadoComercio = nodes.item(7).getTextContent();
            char estadoComercioChar = estadoComercio.charAt(0);
            
            thisComercio = new Comercio(codigoComercioInt, nombreComercio, descripcionComercio, fechaCreacionComercioDate, 
    fechaLicenciaComercioDate, ubicacionComercio, telefonoComercioInt, estadoComercioChar);
            
    } catch (Exception e) {
        e.printStackTrace();
        }
    return thisComercio;
    }

}
