<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>VideoClub Ficticio | Catalogo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Sitio web ficticio para la administracion de un videoclub">
        <link rel="icon" type="image/png" href="images/icono.png" sizes="16x16">
        <link rel="stylesheet" type="text/css" href="CSS/styleGen3.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id='wrapper'>
        <header>
            <div id="imagenHeader"></div>
            <h3>Administracion de Usuarios | Catalogo de Peliculas</h3>
	</header>
        <nav>
            <ul>
                <li><a href="index.html" id="index"><h5>[Volver Al Inicio]</h5></a></li>
                <li><a href="catalogo.html" id="catalogo"><h5>[Catalogo]</h5></a></li>
                <li><a href="https://github.com/andrralv" id="catalogo"><h5>[Acerca de Nosotros]</h5></a></li>
                <li><a href="logout.jsp" id="logout"><h5>[Logout]</h5></a></li>
            </ul>  
	</nav>
            <section>
                <div id="tableWrapper">
                    <p id="titulo"><b>Listado de Clientes</b></p>
                    <hr />
                    <ul>
                        <li>Usuario: <div id="usuario">linkmario</div></li>
                        <li>Nombre Completo: <div id="nombre">Shigeru Miyamoto</div></li>
                        <li>Email: <div id="email">miyamoto@nintendo.co.jp</div></li>
                        <li>Alquileres: <br /><br /> <div id="alquileres"></div></li>
                        <ul>
                            <!-- Cliente -->
                            <hr />
                            <li id="movie" name="movie">Codigo:&nbsp;<span id="codigo">2423</span>
                                    &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;Filme:&nbsp;&nbsp;
                                    <b><span id="filme">A Fistful of Dollars</b></span>
                                    &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<i>Estado :</i>&nbsp; Prestado hasta el &nbsp;<span id="periodo"><i>
                                    1 Semana</i></span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<label><br/>
                                    <button type="button">Remover Alquiler</button>
                                    <br />
                            </li>
                            <!-- Fin de bloque cliente -->
                            <!-- Cliente -->
                            <hr />
                            <li id="movie" name="movie">Codigo:&nbsp;<span id="codigo">2323</span>
                                    &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;Filme:&nbsp;&nbsp;
                                    <b><span id="filme">vicepresidente: Tensión, Fama y el Deceso</b></span>
                                    &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<i>Estado :</i>&nbsp; Prestado hasta el &nbsp;<span id="periodo"><i>
                                    2 semanas</i></span>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<label><br/>
                                    <button type="button">Remover Alquiler</button>
                                    <br />
                            </li>
                            <!-- Fin de bloque cliente -->
                            <hr /> <!-- boton agregar pelicula -->
                            <form action="agregaFilme.jsp">
                            <label>Agregar Pelicula: </label><input type="text" name="agregar" 
                            placeholder="Ingrese el codigo">  <button type="submit">Agregar</button>
                            </form>
                            <!-- fin de boton -->
                            <hr />
                        </ul>
                    </ul>
                    <hr />
                </div>
            </section>
        </div>
        <div id="formWrapper">
            <form action="clienteNuevo.jsp"><label>Agregar Cliente Nuevo: </label><input type="text" name="user" 
                            placeholder="Nombre de usuario" required> <input type="text" name="fullname" 
                            placeholder="Nombre completo" required> <input type="email" name="email" 
                            placeholder="Email" required> <button type="submit">Agregar</button></form>
        </div>
        <div id="bottomMessage"><h5>Buscar Cliente: Ctrl + F > Introducir nombre de usuario</h5></div>
        <footer>
            <h5>Andre Rodriguez. UNED 2016. [andralv77@gmail.com]</h5>
        </footer>
    </body>
</html>
