package Controlador;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import java.lang.*;


public class Debug {
    /** paquete de pruebas para realizar debugging */
    public static void checkUsers(String id) { 
    // checkea si el usuario ingresado ya existe    
    try {
        // crear el documento desde el XML
        File inputFile = new File("C:\\Users\\andre\\Documents\\Programacion\\"
                + "2016 I cuatri\\Progra Web\\Projects\\WebApplication1\\web\\"
                + "administracionRegistro.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        // normalizar formato
        doc.getDocumentElement().normalize();
        if (doc == null) {
            System.out.println("Can't find the file.");
        } else {
            String hi = doc.getDocumentURI();
            Element bye = doc.getDocumentElement();
            String ugh = bye.getTagName();
            System.out.println("The file is in " + hi + "\nand the root element name is " + "\"" + ugh + "\"");
            NodeList listaUsuarios = doc.getElementsByTagName("username");
            NodeList listaPasswords = doc.getElementsByTagName("pass");
            for (int i = 0; i < listaUsuarios.getLength(); i++){    
                Node nodoUsuario = listaUsuarios.item(i);
                Node nodoPassword = listaPasswords.item(i);
                System.out.println(nodoUsuario.getTextContent());
                System.out.println(nodoPassword.getTextContent());
            }
        }
        
        // verificar si nombre de usuario ya existe en el documento
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    public static void main(String args[]){
        checkUsers("admin1");
    }
}
