package Controlador;
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {
    // clase controladora para la logica del programa
    
    public SQLConnection() throws SQLException, ClassNotFoundException {
        makeConnection();
        Class.forName("com.mysql.jdbc.Driver");
    } 
    private Connection myConnect;  
    // crea una conexion con la base de datos
    // si la conexion da timeout, se debe ingresar a AWS y permitir
    // esta direccion IP
    public Connection makeConnection() throws SQLException {
        if (myConnect == null) {
            new Driver();
            // boot connection
            myConnect = DriverManager.getConnection(
                       "jdbc:mysql://ec2-52-35-132-70.us-west-2.compute.amazonaws.com:3306/videoclub",
                       "root",
                       "rugalpopo");
        }
        return myConnect;
    }  
    public boolean checkUser(String requestSt) throws SQLException, ClassNotFoundException {
        // revisa si un usuario ya existe en el registro
        // si retorna true no permite al usuario registrar
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        try {
        String sqlStmt = "SELECT username FROM adminRegistro"
                + " WHERE username = '" + requestSt + "'";
        Statement stmt = conn.myConnect.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStmt);
        rs.next();
        String rsValue = rs.getString("username");
        rs.close();
        if (rsValue.equals(requestSt)){
            bool = false; 
            }
        } catch (SQLException e){
            bool = true;
            }
        return bool;
        }
    public boolean newUser (String username, String password, String fullName, String email) throws Exception{
        // ingresa un nuevo usuario en la base de datos
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "INSERT INTO adminRegistro(username, password, fullName, email)"
                    + " VALUES('" + username + "', '" + password + "', '" + fullName + "', '" + email + "');";
            stmt.executeUpdate(sqlStmt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean login (String username, String password) throws Exception {
        // checkea si los credenciales ingresados
        // existen en la base de datos
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        try {
            String sqlStmt = "SELECT username FROM adminRegistro"
                    + " WHERE username = '" + username + "';";
            Statement stmt = conn.myConnect.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStmt);
            rs.next();
            String rsValue = rs.getString("username");
            rs.close();
            if (rsValue.equals(username)) {
                bool = true;
            }
        } catch (Exception e) {
            bool = false;
            } 
        return bool;
    }
    public boolean checkNewClient (String user) throws Exception {
        // checkea si un nuevo cliente ya existe en la base de datos
        // si retorna true no permite al usuario registrar el nuevo usuario
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        try {
            String sqlStmt = "SELECT clienteUser FROM clientes"
                    + " WHERE clienteUser = '" + user + "';";
            Statement stmt = conn.myConnect.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStmt);
            rs.next();
            String rsValue = rs.getString("clienteUser");
            rs.close();
            if (rsValue.equals(user)) {
                bool = true;
                }
            }
        catch (Exception e) {
            bool = false;
            }
        return bool;
    }
    public boolean newClient (String user, String email, String name) throws Exception {
        // ingresa un nuevo cliente en la base de datos
        boolean bool;
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "INSERT INTO clientes(clienteUser, clienteEmail, clienteNombre)"
                    + " VALUES('" + user + "', '" + email + "', '" + name + "');";
            stmt.executeUpdate(sqlStmt);
            bool = true;
        } catch (Exception e) {
            bool = false;
        }
    return bool;
    }
    
    public ArrayList clientData() throws Exception {
        // crea una lista de objetos con los clientes en
        // la base de datos. Devuelte el arraylist para
        // desplegar la informacion de salida
        Client cliente = null;
        ArrayList cList = new Controlador.ClientList().lista;
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "SELECT * FROM clientes;";
            ResultSet rs = stmt.executeQuery(sqlStmt);
            rs.beforeFirst();
            while (rs.next()) {
                String rsUserValue = rs.getString("clienteUser");
                String rsEmailValue = rs.getString("clienteEmail");
                String rsNameValue = rs.getString("clienteNombre");
                cliente = new Client(rsUserValue, rsEmailValue, rsNameValue);
                cList.add(cliente);
            }
            rs.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    return cList;
    }  
    
    public static void setFilm(String filmName, String user) throws Exception {
        // agrega un nuevo filme a un cliente
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "INSERT INTO clienteFilmes(clienteFilme)" +
                    " VALUES(" + filmName + ") WHERE clienteUser = '" + user + "';";
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
    public static boolean checkFilm(int code, String user) throws Exception {
        // checkea si el filme ingresado se encuentra en catalogo
        SQLConnection conn = new SQLConnection();
        try {
            // statements para datos de clientes
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "SELECT codigoFilme, nombreFilme FROM filmes"
                    + "WHERE codigoFilme = '" + code + "';";
            ResultSet rs = stmt.executeQuery(sqlStmt);
            // statements para datos de peliculas
            Statement stmt2 = conn.myConnect.createStatement();
            rs.next();
            String rsCodigoValue = rs.getString("codigoFilme");
            String rsNombreValue = rs.getString("nombreFilme");
            if (rsCodigoValue.equals(code)) {
                setFilm(rsNombreValue, user);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
            }
    }
    
public class Client {
    // clase de usuario
    // refleja el modelo en la base de datos
    private String userName;
    private String email;
    private String fullName;
    private String[] films = new String[4]; 
    
    public Client(String name, String email, String fullName) {
        this.userName = name;
        this.email = email;
        this.fullName = fullName;
    }
    
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFullname(String fullName) {
        this.fullName = fullName;
    }
    public String getUsername() {
        return this.userName;
    }
    public String getFullname() {
        return this.fullName;
    }
    public String getEmail() {
        return this.email;
    }
    public void addFilm(String filmName, int index) {
        this.films[index] = filmName;
    }
    public String getFilm(int index) {
        return films[index];
    }
    public String toString() {
        return "<div id='clientInfo'><ul><li>Nombre De Usuario: <b>" + this.userName + 
                "</b></li><li>Email: <b>" + 
                this.email + "</b></li><li>Nombre De Cliente: <b>" + 
                this.fullName + "</b></li></ul></div><hr />";
        }
    public void addFilm(int code) throws Exception {
        Controlador.SQLConnection.checkFilm(code, this.getUsername());
        }
    }
}
