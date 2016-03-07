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
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;


// agrega datos de un filme al usuario respectivo de la sesion
public class writeMovieData {
    public static void writeMovie(String code, HttpSession session, 
            HttpServletResponse response) {
        
        //crear el documento para escribir luego
        try {
        // crear el documento desde el XML
                
        // abre los documentos
        Document docClientes = modeloVideoClub.getDocument("files/usuariosRegistro.xml");
        Document docCatalogo = modeloVideoClub.getDocument("files/catalogoRegistro.xml");
        Node clientes = docClientes.getFirstChild();
        Node filmes = docCatalogo.getFirstChild();
        
        // crea los elementos que seran escritos
        Element filmF = docClientes.createElement("filme");
        Element filmCodeF = docClientes.createElement("filmeCode");
        Element filmNameF = docClientes.createElement("filmeNom");
        
        // crear el transformer para escribir el documento
        File file = new File("files/usuariosRegistro.xml");
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(docClientes);
        StreamResult file2 = new StreamResult(file);
        StreamResult console = new StreamResult(System.out);

        // toma el elemento root
        Element parent = docClientes.getDocumentElement();
        Element parentMovies = docCatalogo.getDocumentElement();
        
        // toma todos los usuarios
        NodeList users = parent.getChildNodes();
        Node username = users.item(0);
        String usernameString = username.getTextContent();
        NodeList movielist = parentMovies.getChildNodes();
        
        // informacion de la sesion
        String myIDString = String.valueOf(session.getAttribute("userID"));
        
        // por cada filme registrado
        // comparar con el codigo introducido
        // si existe, buscar por cada usuario
        // el que tenga username igual a la sesion
        for (int i=0;i<movielist.getLength();i++){
            Node movie = movielist.item(i);
            Node movieNode = movie.getFirstChild();
            Node movieNameNode = movieNode.getNextSibling();
            String movieCode = movieNode.getTextContent();
            String movieName = movieNameNode.getTextContent();
            
            // si el codigo que ingreso el usuario esta registrado en el xml
            if (code.equals(movieCode)) {
                for (int j=0;j<users.getLength();j++) {
                    // si la sesion es igual al usuario registrado en el xml    
                    if (myIDString.equals(usernameString)) {
                        // agrega los nodos al xml
                        Node filmesW = username.getLastChild();
                        filmesW.appendChild(filmF);
                        filmF.appendChild(filmCodeF);
                        filmF.appendChild(filmNameF);
                        // escribe al archivo xml
                        transformer.transform(source, console);
                        transformer.transform(source, file2);
                        // sale del loop principal
                        break;
                    }
                }
            }
        } 
        }
        catch (Exception e) {
                 System.out.println(e.getMessage());
        }   
    }
        
}