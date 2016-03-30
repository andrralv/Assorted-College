package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class acceso_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>VideoClub Ficticio | Catalogo</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"Sitio web ficticio para la administracion de un videoclub\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icono.png\" sizes=\"16x16\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/styleGen4.css\">\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id='wrapper'>\n");
      out.write("        <header>\n");
      out.write("            <div id=\"imagenHeader\"></div>\n");
      out.write("            <h3>Administracion de Usuarios | Catalogo de Peliculas</h3>\n");
      out.write("\t</header>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"ingreso.jsp\" id=\"index\"><h5>[Volver Al Inicio]</h5></a></li>\n");
      out.write("                <li><a href=\"catalogo.jsp\" id=\"catalogo\"><h5>[Catalogo]</h5></a></li>\n");
      out.write("                <li><a href=\"https://github.com/andrralv\" id=\"catalogo\" target=\"_blank\"><h5>[Acerca de Nosotros]</h5></a></li>\n");
      out.write("                <li><a href=\"logout.jsp\" id=\"logout\"><h5>[Logout]</h5></a></li>\n");
      out.write("            </ul>  \n");
      out.write("\t</nav>\n");
      out.write("            <section>\n");
      out.write("                <div id=\"tableWrapper\">\n");
      out.write("                    <p id=\"titulo\"><b>Listado de Clientes</b></p>\n");
      out.write("                    <hr />\n");
      out.write("                    <!-- Codigo Java de Datos de los Clientes -->\n");
      out.write("                    ");
  Controlador.SQLConnection newConnection = new Controlador.SQLConnection();
                        ArrayList myList = newConnection.clientData();
                        for (int i = 0; i < myList.size(); i++) {
                            Controlador.SQLConnection.Client thisClient = (Controlador.SQLConnection.Client)myList.get(i);
                            out.println(thisClient);
                            out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><i>Filmes Alquilados: </i></b>");
                            out.println("<hr /><ul>");
                            out.println("<span class='thisCount'>"); // principio de span
                            String clientUser = thisClient.getUsername();
                            for (int j = 0; j < 5; j++) {
                                String film = thisClient.getFilm(j);
                                String filmFormat = String.format("<li class='thisMovie'>%s&nbsp;&nbsp;" // principio de li thisMovie
                                        + "<form action=\"removeFilm.jsp\">"
                                        + "<button type=\"submit\" name=\"remover\">Remover Filme</button>"
                                        + "<input type='hidden' name='film' value ='%s'></form>"
                                        + "<input type='hidden' name='user' value='%s'>"
                                        + "</li>", film, film, clientUser); // final de li thisMovie
                                if (film == null) {
                                    out.println("&nbsp;&nbsp;");
                                } else {
                                    out.println(filmFormat);
                                }
                            }
                        out.println("<form action=\"addFilm.jsp\" novalidate>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                + "<input type='text' name='code' placeholder='codigo de 4 digitos'>"
                                + "<button class='thisButton' type=\"submit\" name=\"agregar\">Agregar un Filme Nuevo"
                                + "</button><span id='noMas'></span>"
                                + "<input type='hidden' name='myUser' value='" + clientUser + "'></form><br />"
                                + "<hr /></span></ul>"); //fin de span
                            }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"formWrapper\">\n");
      out.write("            <form action=\"clienteNuevo.jsp\" id=\"form1\"><label>Agregar Cliente Nuevo: </label><input type=\"text\" name=\"user\" \n");
      out.write("                            placeholder=\"Nombre de usuario\" required> <input type=\"text\" name=\"fullname\" \n");
      out.write("                            placeholder=\"Nombre completo\" required> <input type=\"email\" name=\"email\" \n");
      out.write("                            placeholder=\"Email\" required> <button type=\"submit\">Agregar</button></form>\n");
      out.write("            <form action=\"removerCliente.jsp\" id=\"form2\"><label>Remover Cliente: </label><input type=\"text\" name=\"cliente\"\n");
      out.write("                            placeholder=\"Introduzca usuario\"><button type=\"submit\">Remover</button></form>                                                                             \n");
      out.write("        </div>\n");
      out.write("        <div id=\"bottomMessage\"><h5>Buscar Cliente: Ctrl + F > Introducir nombre de usuario</h5></div>\n");
      out.write("        <footer>\n");
      out.write("            <h5>Andre Rodriguez. UNED 2016. [andralv77@gmail.com]</h5>\n");
      out.write("        </footer>\n");
      out.write("        <script src=\"JS/jquery-v1.12.0.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            console.log(\"hello there\");\n");
      out.write("            $('.thisCount').each(function()\n");
      out.write("                {\n");
      out.write("                    var count = $(this).find('.thisMovie').length;\n");
      out.write("                    if(count > 4)\n");
      out.write("                    {\n");
      out.write("                        console.log(\"working up to this point\");\n");
      out.write("                        $(this).find('.thisButton').first().prop('disabled', true);\n");
      out.write("                        $('#noMas').text(\" Ya no puede alquilar más filmes.\");\n");
      out.write("                    }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
