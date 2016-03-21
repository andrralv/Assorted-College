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
    Controlador.SQLConnection myConnection = new Controlador.SQLConnection();
    String userName = request.getParameter("loginID");
    String userPass = request.getParameter("loginPass");
    boolean choice = myConnection.login(userName, userPass);
    if (choice == false) {
        out.println("Ese usuario no existe, vuelva a intentarlo o registre un usuario nuevo."
                + " <a href='ingreso.jsp'>Volver al Inicio</a>");
    } else if (choice == true) {
        session.setAttribute("loginID", userName);
        session.setMaxInactiveInterval(10000);
        response.sendRedirect("acceso.jsp");
    }
%>
