<%
session.removeAttribute("userID");
session.invalidate();
response.sendRedirect("ingreso.jsp");
%>