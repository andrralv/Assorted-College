<!DOCTYPE html>
 <%@page contentType="text/html" pageEncoding="UTF-8" language="java" 
         import="java.util.*, java.lang.*, Controlador.modeloVideoClub.*"%>
<html>
    <head>
        <title>VideoClub Ficticio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Sitio web ficticio para la administracion de un videoclub">
        <link rel="icon" type="image/png" href="images/icono.png" sizes="16x16">
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
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
                <li><a href="logoout.jsp" id="index"><h5>[Volver Al Inicio]</h5></a></li>
                <li><a href="catalogo.html" id="catalogo"><h5>[Catalogo]</h5></a></li>
                <li><a href="https://github.com/andrralv" id="catalogo"><h5>[Acerca de Nosotros]</h5></a></li>
                <li><a href="logout.jsp" id="logout"><h5>[Logout]</h5></a></li>
            </ul>
	</nav>
        <section>
            <fieldset id='logWrapper'>
                <legend><b>Ingrese al Sistema</b></legend>
		<form id="myForm" action="login.jsp" method="GET">
                    <p>Nombre de Usuario</p><input type="text" class="formControl" 
                           placeholder="Nombre de Usuario..." name="loginID" id="usuarioID" required>
                    <br />
                   <p>Password</p><input type="password" class="formControl" placeholder="Password..." name="loginPass" 
                          id="usuarioPass" required>
                   <button type="submit" class="btn" id="subButton">Ingresar</button>
                </form>
            </fieldset>
            <fieldset id='RegWrapper'>
                <legend><b>Registre un Usuario</b></legend>
                <form id="myForm" action="registro.jsp" method="POST">
                    <p>Nombre de Usuario</p><input type="text" class="formControl" 
                           placeholder="Nombre de Usuario..." name="userID" id="usuarioID" required>
                    <p>Password</p><input type="password" class="formControl" placeholder="Password..." 
                            name="userPass" id="usuarioPass" required>
                    <p>Nombre Completo</p><input type="text" class="formControl" placeholder="Nombre..." 
                            name="userName" id="usuarioNombre" required>
                    <p>Correo Electronico</p><input type="email" class="formControl" placeholder="Email..."
                            name="userEmail" id="usuarioEmail" required>
                    <button type="submit" class="btn" id="subButton">Registrar</button>
                </form>
            </fieldset>
        </section>
    </div>
        <footer>
            <h5>Andre Rodriguez. UNED 2016. [andralv77@gmail.com]</h5>
        </footer>
    </body>
</html>
