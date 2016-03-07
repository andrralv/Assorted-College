<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="Controlador.controladorVideoClub.*"%>
<%@ page import="Controlador.writeMovieData.*"%>
<%@ page import="Controlador.modeloVideoClub.*"%>
<%@ page import="javax.xml.transform.dom.DOMSource"%>
<%@ page import="javax.xml.transform.stream.StreamResult"%>
<%@ page import="javax.xml.transform.OutputKeys"%>
<%@ page import="javax.xml.transform.Transformer"%>
<%@ page import="javax.xml.transform.TransformerFactory"%>

<% 
String codigo = request.getParameter("agregar");
Controlador.controladorVideoClub.addMovie.writeMovie(codigo, session, response);
%>
