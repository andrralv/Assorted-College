<!DOCTYPE html>
 <%@page contentType="text/html" pageEncoding="UTF-8" language="java" 
         import="java.util.*, java.lang.*"%>
<html>
    <head>
        <title>VideoClub Ficticio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Sitio web ficticio para la administracion de un videoclub">
        <link rel="icon" type="image/png" href="images/icono.png" sizes="16x16">
        <link rel="stylesheet" type="text/css" href="CSS/styleCatalogo.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id='wrapper'>
        <header>
            <div id="imagenHeader"></div>
            <h3>Bienvenido al Servicio de VideoClub Ficticio</h3>
	</header>
	<nav>
            <ul>
                <li><a href="ingreso.jsp" id="index"><h5>[Volver Al Inicio]</h5></a></li>
                <li><a href="catalogo.jsp" id="catalogo"><h5>[Catalogo]</h5></a></li>
                <li><a href="https://github.com/andrralv" id="catalogo"><h5>[Acerca de Nosotros]</h5></a></li>
                <li><a href="logout.jsp" id="logout"><h5>[Logout]</h5></a></li>
            </ul>
	</nav>
        <section>
            <table id="myTable">
                <tr><th>Codigo</th><th>Nombre de Filme</th></tr>
                <tr><td>1001</td><td>Neon Genesis Evangelion</td></tr>
                <tr><td>1232</td><td>Pulp Fiction</td></tr>
                <tr><td>4323</td><td>V for Vendetta</td></tr>
                <tr><td>4832</td><td>Unglorious Bastards</td></tr>
                <tr><td>3423</td><td>The Danish Girl</td></tr>
                <tr><td>3453</td><td>Diarios de una Pasion</td></tr>
                <tr><td>9694</td><td>Kung Fu Panda</td></tr>
                <tr><td>7656</td><td>The Wolf Of Wall Street</td></tr>
                <tr><td>3213</td><td>Harry Potter and the Prisioner of Askaban</td></tr>
                <tr><td>9534</td><td>The Dark Knight</td></tr>
                <tr><td>8593</td><td>Spotlight</td></tr>
                <tr><td>5345</td><td>Avatar</td></tr>
                <tr><td>7776</td><td>The Texas Chainsaw Massacre</td></tr>
                <tr><td>1212</td><td>Forrest Gump</td></tr>
                <tr><td>9989</td><td>Willy Wonka and his Chocolate Factory</td></tr>
                <tr><td>3332</td><td>Kujo</td></tr>
                <tr><td>6664</td><td>Eternal Sunshine of the Spotless Light</td></tr>
            </table>
        </section>
            <a href="acceso.jsp" id="return">[Volver Al Sistema]</a>
        </div>
        <footer>
            <h5>Andre Rodriguez. UNED 2016. [andralv77@gmail.com]</h5>
            <a href="acceso.jsp" id="return">Volver al Sistema</a>
        </footer>
    </body>
</html>
        