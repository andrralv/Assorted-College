<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="javax.xml.transform.dom.DOMSource"%>
<%@ page import="javax.xml.transform.stream.StreamResult"%>
<%@ page import="javax.xml.transform.OutputKeys"%>
<%@ page import="javax.xml.transform.Transformer"%>
<%@ page import="javax.xml.transform.TransformerFactory"%>

<% 
    String thisUser = request.getParameter("cliente");
    Controlador.SQLConnection newConnection = new Controlador.SQLConnection();
    
    if (newConnection.removeClient(thisUser) == true) {
        out.println("Se ha removido el cliente de la lista de clientes. <a href='acceso.jsp'>Volver al Sistema.</a>");
    } else {
        out.println("El usuario ingresado no se encuentra en el sistema de clientes. "
                + "Intentelo de nuevo. <a href='acceso.jsp'>Volver al Sistema.</a>");
    }
    
%>