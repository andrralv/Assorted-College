<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.*" %>
<%@ page import="javax.xml.transform.*" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.lang.*" %>

<%
    String printThis = Controlador.SQLConnection.clientData();
    out.println(printThis);
%>