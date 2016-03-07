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

// obtiene los datos del usuario del archivo de registro
// obtiene los datos de las peliculas alquiladas por el usuario
public class getUserData {
    public getUserData() {
        File file = new File("files/usuariosRegistro.xml");
        Document doc = modeloVideoClub.getDocument("files/usuariosRegistro.xml");
        Node usuarios = doc.getFirstChild();
        // toma el elemento root
        Element parent = doc.getDocumentElement();
        // toma todos los usuarios
        NodeList users = parent.getChildNodes();
        for (int i = 0; i < users.getLength(); i++) {
            // get nodos
            Node user = users.item(i);
            Node username = user.getFirstChild();
            Node fullname = username.getNextSibling();
            Node useremail = fullname.getNextSibling();
            Node filmesNodo = useremail.getNextSibling();
            NodeList filme = filmesNodo.getChildNodes();
            for (int j=0;j<filme.getLength(); j++) {
                Node filmCode = filme.item(j);
                Node filmName = filme.item(j+1);
                String filmCodeValue = filmCode.getTextContent();
                String filmNameValue = filmName.getTextContent();
            }
            // get values
            String[] userData = new String[3];
            userData[0] = user.getTextContent();
            userData[1] = username.getTextContent();
            userData[2] = fullname.getTextContent();
            userData[3] = useremail.getTextContent();
            }
        }
    }