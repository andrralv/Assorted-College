package proyecto.model;

import java.util.ArrayList;
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
    proyecto.Utilidades.getDate getFecha;
    public ArrayList<proyecto.model.Comercio> listaComercios = new ArrayList<>();

    // agrega comercios al arraylist
    public void showData() {
        Document document = manageDocument("archivoComercio.xml");
        Element raiz = null;
        Comercio thisComercio = null;
        Node elNodo = null; // el nodo que vamos a tomar
        try {
            // toma de elementos del archivo
            raiz = document.getDocumentElement();
            if (raiz.hasChildNodes()) {
                NodeList nodelist = raiz.getElementsByTagName("codigo-comercio");
                int len = nodelist.getLength();
                for (int i = 0; i < len; i++) {
                    String nodeString = nodelist.item(i).getTextContent();
                        elNodo = nodelist.item(i).getParentNode();  
            
        // remover nodos de espacio blanco
            if (elNodo != null) {
                NodeList nodes = elNodo.getChildNodes(); 
                for (int y = 0; y < nodes.getLength(); y++) {
                    if (nodes.item(y).getNodeType() == nodes.item(y).TEXT_NODE) {
                        nodes.item(y).getParentNode().removeChild(nodes.item(y));
                    }
                }
                // objeto de getfecha
                // parsing datos y devolviendo un objeto comercio
                getFecha = new proyecto.Utilidades.getDate();
            
                String codigoComercio = nodes.item(0).getTextContent();
                int codigoComercioInt = Integer.valueOf(codigoComercio);
                String nombreComercio = nodes.item(1).getTextContent();
                String descripcionComercio = nodes.item(2).getTextContent();
                String fechaCreacionComercio = nodes.item(3).getTextContent();
                Date fechaCreacionComercioDate = getFecha.getFecha(fechaCreacionComercio, false);
                String fechaLicenciaComercio = nodes.item(4).getTextContent();
                Date fechaLicenciaComercioDate = getFecha.getFecha(fechaLicenciaComercio, false);
                String ubicacionComercio = nodes.item(5).getTextContent();
                String telefonoComercio = nodes.item(6).getTextContent();
                String estadoComercio = nodes.item(7).getTextContent();
                char estadoComercioChar = estadoComercio.charAt(0);
            
                thisComercio = new Comercio();
                thisComercio.setCodigo(codigoComercioInt);
                thisComercio.setNombre(nombreComercio);
                thisComercio.setDescripcion(descripcionComercio);
                thisComercio.setFecha(fechaCreacionComercioDate);
                thisComercio.setFechaLicencia(fechaLicenciaComercioDate);
                thisComercio.setUbicacion(ubicacionComercio);
                thisComercio.setTelefono(Integer.valueOf(telefonoComercio));
                thisComercio.setEstado(estadoComercioChar);
                this.addComercio(thisComercio);
                } else {
                // dunno lol
                    }            
                }
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    // retorna el arraylist
    public ArrayList getArrayList() {
        return listaComercios;
    }
    
    public void addComercio(Comercio e) {
        listaComercios.add(e);
    }
    
    public Comercio getItemData(String nombre) {
        Document document = manageDocument("archivoComercio.xml");
        Element raiz = null;
        Comercio thisComercio = null;
        Node elNodo = null; // el nodo que vamos a tomar
        try {
            // toma de elementos del archivo
            raiz = document.getDocumentElement();
            if (raiz.hasChildNodes()) {
                NodeList nodelist = raiz.getElementsByTagName("nombre-comercio");
                int len = nodelist.getLength();
                for (int i = 0; i < len; i++) {
                    String nodeString = nodelist.item(i).getTextContent();
                        if (nombre.equals(nodeString)) {
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
                // objeto de getfecha
                // parsing datos y devolviendo un objeto comercio
                getFecha = new proyecto.Utilidades.getDate();
            
                String codigoComercio = nodes.item(0).getTextContent();
                int codigoComercioInt = Integer.valueOf(codigoComercio);
                String nombreComercio = nodes.item(1).getTextContent();
                String descripcionComercio = nodes.item(2).getTextContent();
                String fechaCreacionComercio = nodes.item(3).getTextContent();
                Date fechaCreacionComercioDate = getFecha.getFecha(fechaCreacionComercio, false);
                String fechaLicenciaComercio = nodes.item(4).getTextContent();
                Date fechaLicenciaComercioDate = getFecha.getFecha(fechaLicenciaComercio, false);
                String ubicacionComercio = nodes.item(5).getTextContent();
                String telefonoComercio = nodes.item(6).getTextContent();
                String estadoComercio = nodes.item(7).getTextContent();
                char estadoComercioChar = estadoComercio.charAt(0);
            
                thisComercio = new Comercio();
                thisComercio.setCodigo(codigoComercioInt);
                thisComercio.setNombre(nombreComercio);
                thisComercio.setDescripcion(descripcionComercio);
                thisComercio.setFecha(fechaCreacionComercioDate);
                thisComercio.setFechaLicencia(fechaLicenciaComercioDate);
                thisComercio.setUbicacion(ubicacionComercio);
                thisComercio.setTelefono(Integer.valueOf(telefonoComercio));
                thisComercio.setEstado(estadoComercioChar);
                } else {
                // dunno lol
                    }            
        } catch (Exception e) {
        e.printStackTrace();
        }
    return thisComercio;
    }
}
