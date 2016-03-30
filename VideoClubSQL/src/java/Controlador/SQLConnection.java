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
        } else {
            // ignore
        }
        return myConnect;
    }  
    
    public boolean checkUser(String requestSt) throws SQLException, ClassNotFoundException {
        // revisa si un usuario ya existe en el registro
        // si retorna true no permite al usuario registrar
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        try {
        String sqlStmt = "SELECT username FROM adminRegistro"
                + " WHERE username = '" + requestSt + "'";
        stmt = conn.myConnect.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStmt);
        rs.next();
        String rsValue = rs.getString("username");
        if (rsValue.equals(requestSt)){
            bool = false; 
            }
        } catch (SQLException e){
            bool = true;
            } finally {
            stmt.close();
            conn.myConnect.close();
        }
        return bool;
        }
    
    public boolean newUser (String username, String password, String fullName, String email) throws Exception{
        // ingresa un nuevo usuario en la base de datos
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        try {
            stmt = conn.myConnect.createStatement();
            String sqlStmt = "INSERT INTO adminRegistro(username, password, fullName, email)"
                    + " VALUES('" + username + "', '" + password + "', '" + fullName + "', '" + email + "');";
            stmt.executeUpdate(sqlStmt);
            stmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            stmt.close();
            conn.myConnect.close();
        }
    }
    
    public boolean login (String username, String password) throws Exception {
        // checkea si los credenciales ingresados
        // existen en la base de datos
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        try {
            String sqlStmt = "SELECT username FROM adminRegistro"
                    + " WHERE username = '" + username + "';";
            stmt = conn.myConnect.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStmt);
            rs.next();
            String rsValue = rs.getString("username");
            rs.close();
            stmt.close();
            if (rsValue.equals(username)) {
                bool = true;
            }
        } catch (Exception e) {
            bool = false;
            } finally {
            stmt.close();
            conn.myConnect.close();
        }
        return bool;
    }
    
    public boolean checkNewClient (String user) throws Exception {
        // checkea si un nuevo cliente ya existe en la base de datos
        // si retorna true no permite al usuario registrar el nuevo usuario
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        try {
            String sqlStmt = "SELECT clienteUser FROM clientes"
                    + " WHERE clienteUser = '" + user + "';";
            stmt = conn.myConnect.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStmt);
            rs.next();
            String rsValue = rs.getString("clienteUser");
            rs.close();
            stmt.close();
            if (rsValue.equals(user)) {
                bool = true;
                }
            }
        catch (Exception e) {
            bool = false;
            } finally {
            stmt.close();
            conn.myConnect.close();
        }
        return bool;
    }
    
    public boolean newClient (String user, String email, String name) throws Exception {
        // ingresa un nuevo cliente en la base de datos
        boolean bot;
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        try {
            stmt = conn.myConnect.createStatement();
            String sqlStmt = "INSERT INTO clientes(clienteUser, clienteEmail, clienteNombre)"
                    + " VALUES('" + user + "', '" + email + "', '" + name + "');";
            stmt.executeUpdate(sqlStmt);
            stmt.close();
            bot = true;
        } catch (Exception e) {
            bot = false;
        } finally {
            stmt.close();
            conn.myConnect.close();
        }
    return bot;
    }
    
    public boolean removeClient (String user) throws Exception {
        // remueve un cliente de la base de datos
        boolean bot = false;
        SQLConnection conn = new SQLConnection();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try {
            String sqlStmt = "DELETE FROM clientes "
                    + "WHERE clientes.clienteUser = '" + user + "';";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            pstmt.executeUpdate(sqlStmt);
            pstmt.close();
            String sqlStmt2 = "DELETE FROM clienteFilmes"
                    + " WHERE clienteFilmes.clienteUser = '" + user + "';";
            pstmt2 = conn.myConnect.prepareStatement(sqlStmt2);
            pstmt2.executeUpdate(sqlStmt2);
            pstmt2.close();
            bot = true;
        } catch (Exception e) {
            e.printStackTrace();
            bot = false;
        } finally {
            conn.myConnect.close();
        }
    return bot;
    }
    
    public static boolean setFilm(String filmName, int code, String user) throws Exception {
        // agrega un nuevo filme a un cliente
        boolean bot = true;
        PreparedStatement pstmt = null;
        SQLConnection conn = new SQLConnection();
        try {
            String sqlStmt = "INSERT INTO clienteFilmes(nombreFilme, codigoFilme, clienteUser)" +
                    " VALUES('" + filmName + "', " + code + ", '" + user +"');";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            pstmt.executeUpdate(sqlStmt);
            pstmt.close();
            changeSaldo(user, true);
            bot = true;
    } catch (Exception e) {
        return false;
    } finally {
        conn.myConnect.close();
        }
    return bot;
    }
    
    public static boolean removeMovie (String movie, String user) throws Exception {
        // ingresa un nuevo cliente en la base de datos
        boolean bool;
        SQLConnection conn = new SQLConnection();
        PreparedStatement pstmt = null;
        try {
            String sqlStmt = "DELETE FROM clienteFilmes"
                    + " WHERE nombreFilme = '" + movie + "';";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            pstmt.execute(sqlStmt);
            changeSaldo(user, false);
            bool = true;
        } catch (Exception e) {
            bool = false;
        } finally {
            pstmt.close();
            conn.myConnect.close();
        }
    return bool;
    }
    
    public static boolean changeSaldo(String user, boolean bool) throws Exception {
        // cambia el saldo del cliente 
        // false para remover filme
        // true para agregar filme
        SQLConnection conn = new SQLConnection();
        Statement pstmt = null;
        Statement pstmt2 = null;
        boolean bot = false;
        int newSaldo = 0;
        try {
            String sqlStmt = "SELECT clienteSaldo FROM clientes WHERE clienteUser = '" + user + "';";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            ResultSet rs = pstmt.executeQuery(sqlStmt);
            rs.next();
            int mySaldo = rs.getInt("clienteSaldo");
            if (bool = true) {
                newSaldo = mySaldo + 1000;   
            } else {
                newSaldo = mySaldo - 1000;
            }
            String stSaldo = Integer.toString(newSaldo);
            rs.close();
            pstmt.close();
            String sqlStmt2 = "UPDATE clientes SET clienteSaldo = " + stSaldo + " WHERE clienteUser = '" + user + "';";
            pstmt2 = conn.myConnect.prepareStatement(sqlStmt2);
            pstmt2.executeUpdate(sqlStmt2);
            pstmt2.close();
            bot = true;
        } catch (Exception e) {
            e.printStackTrace();
            bot = false;
        } finally {
            conn.myConnect.close();
        }
    return bot;
    }
    
    public ArrayList clientData() throws Exception {
        // crea una lista de objetos con los clientes en
        // la base de datos. Devuelte el arraylist para
        // desplegar la informacion de salida
        Client cliente = null;
        ArrayList cList = new Controlador.ClientList().lista;
        SQLConnection conn = new SQLConnection();
        PreparedStatement pstmt = null;
        try {
            String sqlStmt = "SELECT * FROM clientes;";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            ResultSet rs = pstmt.executeQuery(sqlStmt);
            rs.beforeFirst();
            while (rs.next()) {
                String rsUserValue = rs.getString("clienteUser");
                String rsEmailValue = rs.getString("clienteEmail");
                String rsNameValue = rs.getString("clienteNombre");
                int rsSaldo = rs.getInt("clienteSaldo");
                int[] codesLista = retrieveCodes(rsUserValue);
                String[] filmesLista = retrieveMovies(rsUserValue);
                cliente = new Client(rsUserValue, rsEmailValue, rsNameValue, rsSaldo);
                for (int i = 0; i < filmesLista.length; i++) {
                    cliente.addFilm(filmesLista[i], codesLista[i], i, rsUserValue);
                }
                cList.add(cliente);
            }    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            conn.myConnect.close();
        }
    return cList;
    }  
    
    public int[] retrieveCodes(String user) throws Exception {
        // devuelve la lista de peliculas alquiladas de un usuario especifico
        SQLConnection conn = new SQLConnection();
        int i = 0;
        int[] codes = new int[5];
        PreparedStatement pstmt = null;
        try {
            String sqlStmt = "SELECT codigoFilme FROM clienteFilmes"
                    + " WHERE clienteUser = '" + user + "';";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            ResultSet rs = pstmt.executeQuery(sqlStmt);
            while (rs.next()) {
                int code = rs.getInt("codigoFilme");
                codes[i++] = code;
            }
        }
        catch (Exception e) {
          e.printStackTrace();  
        } finally {
            pstmt.close();
            conn.myConnect.close();
        }
    return codes;
    }
    
    public String[] retrieveMovies(String user) throws Exception {
        // devuelve la lista de peliculas alquiladas de un usuario especifico
        SQLConnection conn = new SQLConnection();
        int i = 0;
        PreparedStatement pstmt = null;
        String[] names = new String[5];
        try {
            String sqlStmt = "SELECT nombreFilme FROM clienteFilmes"
                    + " WHERE clienteUser = '" + user + "';";
            pstmt = conn.myConnect.prepareStatement(sqlStmt);
            ResultSet rs = pstmt.executeQuery(sqlStmt);
            while (rs.next()) {
                String name = rs.getString("nombreFilme");
                names[i++] = name;
            }
        }
        catch (Exception e) {
          e.printStackTrace();  
        } finally {
            pstmt.close();
            conn.myConnect.close();
        }
    return names;
    }
    
    public static boolean checkFilm(int code, String user) throws Exception {
        // checkea si el filme ingresado se encuentra en catalogo
        SQLConnection conn = new SQLConnection();
        boolean bot = false;
        Statement stmt = null;
        try {
            // statements para datos de clientes
            stmt = conn.myConnect.createStatement();
            String sqlStmt = "SELECT codigoFilme, nombreFilme FROM filmes"
                    + " WHERE codigoFilme = " + code + ";";
            ResultSet rs = stmt.executeQuery(sqlStmt);
            // statements para datos de peliculas
            if (rs.next()) {
                String myFilm = rs.getString("nombreFilme");
                setFilm(myFilm, code, user);
                bot = true;
                rs.close();
            } 
        }
        catch (Exception e) {
            return false;
            } finally {
            conn.myConnect.close();
            }        
        return bot;
        } 
    
    public static boolean checkRepeats(int code, String user) throws Exception {
        // checkea si el usuario ya tiene este filme alquilado
        Integer myCode = code;
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        try {
        // statements de datos
        stmt = conn.myConnect.createStatement();
        String sqlStmt = "SELECT codigoFilme, clienteUser FROM clienteFilmes"
                + " WHERE codigoFilme = " + code + " AND clienteUser = '" + user + "';"; 
        ResultSet rs = stmt.executeQuery(sqlStmt);
        if(rs.next()) {
            rs.close();
            return false;
            } 
        else {
            rs.close();
            return true;
             } 
        }
        catch (Exception e) {
            return false;
        }
        finally {
            stmt.close();
            conn.myConnect.close();
        }
    }
    
public class Client {
    // clase de usuario
    // refleja el modelo en la base de datos
    private String userName;
    private String email;
    private String fullName;
    private String[] films = new String[5]; 
    private int saldo;
    
    public Client(String name, String email, String fullName, int saldo) {
        this.userName = name;
        this.email = email;
        this.fullName = fullName;
        this.saldo = saldo;
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
    public void addFilm(String filmName, int filmCode, int index, String user) throws Exception {
        // adds to the object movies in database
        if (Controlador.SQLConnection.checkFilm(filmCode, user) == true) { 
            this.films[index] = filmName;
        }
    }
    public String getFilm(int index) {
        return films[index];
    }
    public String toString() {
        return "<div id='clientInfo'><ul><li>Nombre De Usuario: <b>" + this.userName + 
                "</b></li><li>Email: <b>" + 
                this.email + "</b></li><li>Nombre De Cliente: <b>" + 
                this.fullName + "</b></li>"
                + "<li>Saldo por cancelar: <b>" + this.saldo + 
                "</b></li></ul></div>";
        }
    }
}
