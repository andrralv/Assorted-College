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
import java.util.ArrayList;

public class screenWriter{
    public static ArrayList lista = new ArrayList();

    public String[] screenWriter(){
    String[] anArray = new String[2];
    Document doc = Controlador.modeloVideoClub.getDocument("usuariosRegistro.xml");
    Node parent = doc.getDocumentElement();
    NodeList listaUsuarios = doc.getElementsByTagName("userName");
    NodeList listaNombres = doc.getElementsByTagName("fullName");
    NodeList listaEmails = doc.getElementsByTagName("userEmail");

    for (int i = 0; i < listaUsuarios.getLength();i++){
        Node username = listaUsuarios.item(i);
        Node fullname = listaNombres.item(i);
        Node email = listaEmails.item(i);
        anArray[0] = username.getTextContent();
        anArray[1] = fullname.getTextContent();
        anArray[2] = email.getTextContent();
        }
    return anArray;
    }
}
