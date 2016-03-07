<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="Controlador.controladorVideoClub.*"%>
<%@ page import="Controlador.modeloVideoClub.*"%>
<%@ page import="javax.xml.transform.dom.DOMSource"%>
<%@ page import="javax.xml.transform.stream.StreamResult"%>
<%@ page import="javax.xml.transform.OutputKeys"%>
<%@ page import="javax.xml.transform.Transformer"%>
<%@ page import="javax.xml.transform.TransformerFactory"%>

<% 
    String usuarioNuevo = request.getParameter("user");
    String nombreCompletoNuevo = request.getParameter("fullname");
    String emailNuevo = request.getParameter("email");
    
    Controlador.controladorVideoClub.modelo.newUser(usuarioNuevo, 
            nombreCompletoNuevo, emailNuevo);
    session.setAttribute("userID", usuarioNuevo);
    response.sendRedirect("acceso.jsp");
%>      

