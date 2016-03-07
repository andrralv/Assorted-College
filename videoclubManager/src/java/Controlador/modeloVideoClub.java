package Controlador;
import static Controlador.modeloVideoClub.getDocument;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import java.lang.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import org.w3c.dom.NodeList;

public class modeloVideoClub {
    /** paquete de utilidades modeloControlador de la logica del programa */
    public static int checkUsers(String id) { 
    // checkea si el usuario ingresado ya existe    
    try {
        // crear el documento desde el XML
        File inputFile = new File("files/administracionRegistro.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        // normalizar formato
        doc.getDocumentElement().normalize();
        // verificar si nombre de usuario ya existe en el documento
        NodeList listaUsuarios = doc.getElementsByTagName("username");
        for (int i = 0; i < listaUsuarios.getLength(); i++) {
            String nodoUsuario = listaUsuarios.item(i).getTextContent();
            if (nodoUsuario == id) {
                return 2;
            }
        }
        return 1;
    } catch (Exception e) {
        String what = e.getMessage();
        return 3;
    }
}   
    // devuelve el documento listo para trabajar
    public static Document getDocument(String path) {
        Document doc = null;
        try {
        // utilidad para crear un documento xml de usuariosRegistro
        File file = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(file);
        // normalizar formato
        doc.getDocumentElement().normalize();
    } catch (Exception e) {
        String what = e.getMessage();
    }
        return doc;
    }
    
    // escribe un cliente nuevo en el registro xml
    public void newUser(String user, String fullName, String email) throws 
            TransformerConfigurationException, TransformerException {
        File file = new File("files/usuariosRegistro.xml");
        Document doc = getDocument("files/usuariosRegistro.xml");
        Node usuarios = doc.getFirstChild();
        // toma el elemento root
        Element parent = doc.getDocumentElement();
        Element usuarioNuevo = doc.createElement("user");
        parent.appendChild(usuarioNuevo);
        
        Element nombreUsuario = doc.createElement("userName");
        Element nombrefullUsuario = doc.createElement("fullName");
        Element emailUsuario = doc.createElement("userEmail");
        
        nombreUsuario.setTextContent(user);
        nombrefullUsuario.setTextContent(fullName);
        emailUsuario.setTextContent(email);
        
        usuarioNuevo.appendChild(nombreUsuario);
        usuarioNuevo.appendChild(nombrefullUsuario);
        usuarioNuevo.appendChild(emailUsuario);
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult file2 = new StreamResult(file);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
        transformer.transform(source, file2);   
    }
    
    public String[] displayUserData(String[] userList) {
        return userList;
    }
    
    public String[] displayMovieData(String code, String name) {
        String[] datosFilme = new String[1];
        datosFilme[0] = code;
        datosFilme[1] = name;
        return datosFilme;
    }   
}



