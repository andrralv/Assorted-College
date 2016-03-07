<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="Controlador.modeloVideoClub.*"%>
<%@ page import="javax.xml.transform.dom.DOMSource"%>
<%@ page import="javax.xml.transform.stream.StreamResult"%>
<%@ page import="javax.xml.transform.OutputKeys"%>
<%@ page import="javax.xml.transform.Transformer"%>
<%@ page import="javax.xml.transform.TransformerFactory"%>

<%
    // checkea si el usuario ya existe en el registro accediendo al modelo
    int foo = Controlador.modeloVideoClub.checkUsers(request.getParameter("loginID"));
    if (foo == 1) {
        // scriplet
    try {
        // crear el documento desde el XML
        File file = new File("files/administracionRegistro.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        
        // toma el elemento root
        Node usuarios = doc.getFirstChild();
        // crea un nuevo usuario
        // agrega los atributos y los hijos de nombreUsuario y passUsuario
        Element parent = doc.getDocumentElement();
        Element usuarioNuevo = doc.createElement("user");
        parent.appendChild(usuarioNuevo);
        
        Element nombreUsuario = doc.createElement("username");
        Element passUsuario = doc.createElement("pass");
        Element nombrefullUsuario = doc.createElement("name");
        Element emailUsuario = doc.createElement("email");
        
        nombreUsuario.setTextContent(request.getParameter("userID"));
        passUsuario.setTextContent(request.getParameter("userPass"));
        nombrefullUsuario.setTextContent(request.getParameter("userName"));
        emailUsuario.setTextContent(request.getParameter("userEmail"));
        
        usuarioNuevo.appendChild(nombreUsuario);
        usuarioNuevo.appendChild(passUsuario);
        usuarioNuevo.appendChild(nombrefullUsuario);
        usuarioNuevo.appendChild(emailUsuario);
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult file2 = new StreamResult(file);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
        transformer.transform(source, file2);
        response.sendRedirect("registrado.jsp");
    } catch (Exception e) {
        String what = e.getMessage();
        out.println(what);
        // error
       }
    } else if (foo == 2) {
        out.println("Ese usuario ya ha sido registrado!");
        // error
    } else {
        out.println("Error abriendo el archivo.xml");
    }
%>