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
String movieString = request.getParameter("film");
String thisUser = request.getParameter("user");
if (Controlador.SQLConnection.removeMovie(movieString, thisUser) == true) {
    response.sendRedirect("acceso.jsp");
} else {
    out.println("No se pudo remover la pelicula por un error interno. <a href=\"acceso.jsp\">Volver al Sistema</a>");
}
%>

