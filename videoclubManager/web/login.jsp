<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="javax.xml.transform.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>

<%
    // scriplet
    String userName = request.getParameter("loginID");
    String userPass = request.getParameter("loginPass");
    try {
        // crear el documento desde el XML
        File inputFile = new File("files/administracionRegistro.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        // normalizar formato
        doc.getDocumentElement().normalize();
        NodeList listaUsuarios = doc.getElementsByTagName("username");
        NodeList listaPasswords = doc.getElementsByTagName("pass");
        outerloop:
        for (int i = 0; i < listaUsuarios.getLength(); i++){    
            Node nodoUsuario = listaUsuarios.item(i);
            Node nodoPassword = listaPasswords.item(i);
            String usuarioText = nodoUsuario.getTextContent();
            String passText = nodoPassword.getTextContent();
            if ((usuarioText.equals(userName)) && (passText.equals(userPass))) {
                // inicia sesion con el token obtenido del login
                session.setAttribute("userID", userName);
                response.sendRedirect("acceso.jsp");
                }
            else {
                continue;
            }
            }
        out.println("Usuario invalido o no existente.");
        out.println("<a href='ingreso.jsp'>Volver al Inicio</a>");
        } 
    catch (IOException io) {
            String what = io.getMessage();
            out.println(what);
    }
%>