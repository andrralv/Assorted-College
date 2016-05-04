package proyecto.model;

import java.util.Date;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author andre
 * MUESTRA DATOS DE LA TRANSACCION SEGUN EL NUM DE TRANSACCION QUE SE INTRODUZCA
 */
public class MuestraTransaccionData extends ManageDocument {
    proyecto.Utilidades.getDate getFecha;
    public void MuestraTransaccionData(int codigo) {
        Document doc = manageDocument("archivoTransaccion.xml");
        }
    public Transaccion showData(Document document, int codigo) {
        Element raiz = null;
        Transaccion thisTransaccion = null;
        Node elNodo = null; // el nodo que vamos a tomar
        String codigoString = Integer.toString(codigo);
        int len = 0;
        try {
        // toma de elementos del archivo
        raiz = document.getDocumentElement();
        NodeList nodelist = raiz.getElementsByTagName("codigo-comercio");
        len = nodelist.getLength();
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
        getFecha = new proyecto.Utilidades.getDate();
        
        // parsing datos y devolviendo un objeto comercio
        String codigoComercio = nodes.item(0).getTextContent();
        int codigoComercioInt = Integer.valueOf(codigoComercio);
        String fechaTransaccion = nodes.item(1).getTextContent();
        Date fechaTransaccionDate = getFecha.getFecha(fechaTransaccion, true);
        String montoTransaccion = nodes.item(2).getTextContent();
        double montoTransaccionDouble = Integer.valueOf(montoTransaccion);
        String numeroTransaccion = nodes.item(3).getTextContent();
        int numeroTransaccionInt = Integer.valueOf(numeroTransaccion);
        String estadoTransaccion = nodes.item(4).getTextContent();
        char estadoTransaccionChar = estadoTransaccion.charAt(0);
        
        thisTransaccion = new Transaccion();
        
        } catch (Exception e) {
                e.printStackTrace();    
        }
    return thisTransaccion;
    }
}
    
