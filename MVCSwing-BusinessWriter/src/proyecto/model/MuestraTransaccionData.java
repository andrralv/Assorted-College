package proyecto.model;

import java.util.ArrayList;
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
    public ArrayList<proyecto.model.Transaccion> listaTransacciones = new ArrayList<>();
    
    // agrega transacciones al arraylist
    public void showData(String numComercio) {
        Document document = manageDocument("archivoTransaccion.xml");
        Element raiz = null;
        Transaccion thisTransaccion = null;
        Node elNodo = null; // el nodo que vamos a tomar
        try {
            // toma de elementos del archivo
            raiz = document.getDocumentElement();
            if (raiz.hasChildNodes()) {
                NodeList nodelistcomercio = raiz.getElementsByTagName("codigo-comercio");
                NodeList nodelist = raiz.getElementsByTagName("numero-transaccion");
                int len = nodelist.getLength();
                for (int i = 0; i < len; i++) {
                    String codigo = nodelistcomercio.item(i).getTextContent();
                    if (codigo.equals(numComercio)) {
                    String nodeString = nodelist.item(i).getTextContent();
                        elNodo = nodelist.item(i).getParentNode();              
                    }
            // remover nodos de espacio blanco
            if (elNodo != null) {
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
                Date fechaTransaccionDate = getFecha.getFecha(fechaTransaccion, false);
                String montoTransaccion = nodes.item(2).getTextContent();
                double montoTransaccionDouble = Double.parseDouble(montoTransaccion);
                String numeroTransaccion = nodes.item(3).getTextContent();
                int numeroTransaccionInt = Integer.valueOf(numeroTransaccion);
                String estadoTransaccion = nodes.item(4).getTextContent();
                char estadoTransaccionChar = estadoTransaccion.charAt(0);
        
                thisTransaccion = new Transaccion();
                thisTransaccion.setCodigo(codigoComercioInt);
                thisTransaccion.setFechaTiempoAutorizacion(fechaTransaccionDate);
                thisTransaccion.setMonto(montoTransaccionDouble);
                thisTransaccion.setNumAutorizacion(numeroTransaccionInt);
                thisTransaccion.setEstado(estadoTransaccionChar);
                this.addTransaccion(thisTransaccion);  
                this.clearTransacciones();  
                    }
            else {
            // lol who knows what life might bring
                }
            }
        } else{
               // ¯\_(ツ)_/¯
            }
    } catch (Exception e) {
             e.printStackTrace();    
        }
    }
    
    // retorna el arraylist
    public ArrayList getArrayList() {
        return listaTransacciones;
    }
    
    
    public void clearTransacciones() {
        listaTransacciones.clear();
    }
    
    public void addTransaccion(Transaccion e) {
        listaTransacciones.add(e);  
    }
    
    public Transaccion getItemData(String transaccion) {
        Document document = manageDocument("archivoTransaccion.xml");
        Element raiz = null;
        Transaccion thisTransaccion = null;
        Node elNodo = null; // el nodo que vamos a tomar
        try {
            // toma de elementos del archivo
            raiz = document.getDocumentElement();
            if (raiz.hasChildNodes()) {
                NodeList nodelist = raiz.getElementsByTagName("numero-transaccion");
                int len = nodelist.getLength();
                for (int i = 0; i < len; i++) {
                    String nodeString = nodelist.item(i).getTextContent();
                    if (transaccion.equals(nodeString)) {
                    elNodo = nodelist.item(i).getParentNode();              
                    }
                }
            }
            // remover nodos de espacio blanco
            if (elNodo != null) {
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
            Date fechaTransaccionDate = getFecha.getFecha(fechaTransaccion, false);
            String montoTransaccion = nodes.item(2).getTextContent();
            double montoTransaccionDouble = Double.parseDouble(montoTransaccion);
            String numeroTransaccion = nodes.item(3).getTextContent();
            int numeroTransaccionInt = Integer.valueOf(numeroTransaccion);
            String estadoTransaccion = nodes.item(4).getTextContent();
            char estadoTransaccionChar = estadoTransaccion.charAt(0);
        
            thisTransaccion = new Transaccion();
            thisTransaccion.setCodigo(codigoComercioInt);
            thisTransaccion.setFechaTiempoAutorizacion(fechaTransaccionDate);
            thisTransaccion.setMonto(montoTransaccionDouble);
            thisTransaccion.setNumAutorizacion(numeroTransaccionInt);
            thisTransaccion.setEstado(estadoTransaccionChar);
            }
        else {
            // lol who knows what life might bring
            }

    } catch (Exception e) {
             e.printStackTrace();    
        }
    return thisTransaccion;
    }
}
    