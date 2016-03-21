<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="javax.servlet.jsp.*"%>
<%@ page import="Controlador.*"%>
<%@ page import="javax.xml.transform.dom.DOMSource"%>
<%@ page import="javax.xml.transform.stream.StreamResult"%>
<%@ page import="javax.xml.transform.OutputKeys"%>
<%@ page import="javax.xml.transform.Transformer"%>
<%@ page import="javax.xml.transform.TransformerFactory"%>

<%
    // checkea si el usuario ya existe en el registro accediendo al modelo
    Controlador.SQLConnection myConnection = new Controlador.SQLConnection();
    String myLogin = request.getParameter("userID");
    String myPass = request.getParameter("userPass");
    String myName = request.getParameter("userName");
    String myEmail = request.getParameter("userEmail");
    boolean foo = myConnection.checkUser(myLogin);
%>
<% if (foo == false){
        out.println("Ese usuario ya existe. Por favor vuelva a intentarlo. <a href='ingreso.jsp'>Volver al Inicio</a>");
    } else if (foo == true) {
        session.setAttribute("LoginID", myLogin);
        boolean newUser = myConnection.newUser(myLogin, myPass, myName, myEmail);
         if (newUser == true) {
            out.println("Un nuevo usuario ha sido registrado, por favor logueese al sistema "
                    + "con los nuevos credenciales. <a href='ingreso.jsp'>Volver al Inicio</a>");
        } else if (newUser == false) {
            out.println("No se ha podido registrar el nuevo usuario. <a href='ingreso.jsp'>Volver al Inicio</a>");
        } else {
            out.println("Something bad happened.");
            }
        }
%>