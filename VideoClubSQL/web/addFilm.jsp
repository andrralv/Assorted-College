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
String codeString = request.getParameter("code");
int code = Integer.parseInt(codeString);
String thisUser = request.getParameter("myUser");

if (Controlador.SQLConnection.checkRepeats(code, thisUser) == true) {
            Controlador.SQLConnection.checkFilm(code, thisUser);
            response.sendRedirect("acceso.jsp");
        } else {
    out.println("El filme no esta en catalogo o ya ha sido alquilado por otro usuario. <a href='acceso.jsp'>Volver al Sistema</a>");
}
%>
