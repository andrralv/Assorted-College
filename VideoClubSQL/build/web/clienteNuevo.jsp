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
    String usuarioNuevo = request.getParameter("user");
    String emailNuevo = request.getParameter("email");
    String nombreNuevo = request.getParameter("fullname");
    
    Controlador.SQLConnection newConnection = new Controlador.SQLConnection();
    
    boolean foo = newConnection.newClient(usuarioNuevo, emailNuevo, nombreNuevo);
    if (foo == true) {
        out.println("Se ha agregado el cliente nuevo satisfactoriamente."
        + " <a href='acceso.jsp'>Volver al Registro</a>");
    } else {
        out.println("Error interno. No se ha podido agregar el nuevo cliente."
            + " <a href='ingreso.jsp'>Volver al Registro</a>");
    }
%>      

