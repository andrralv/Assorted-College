package Controlador;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import com.mysql.jdbc.Driver;
import java.sql.*;

public class SQLConnection {
    public SQLConnection() throws SQLException, ClassNotFoundException {
        makeConnection();
        Class.forName("com.mysql.jdbc.Driver");
    } 
    private Connection myConnect;  
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
        boolean bool = false;
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
    
    public void clientData() throws Exception {
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "SELECT * FROM clientes;";
            ResultSet rs = stmt.executeQuery(sqlStmt);
            while (rs.next()) {
                String rsUserValue = rs.getString("clienteUser");
                String rsEmailValue = rs.getString("clienteEmail");
                String rsNameValue = rs.getString("clienteNombre");
                Client cliente = new Client(rsUserValue, rsEmailValue, rsNameValue);
                
            }
            rs.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
    public void setFilm(int index, String filmName, String user) throws Exception {
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "INSERT INTO clienteFilmes(clienteFilme" + index +")" +
                    " VALUES(" + filmName + ") WHERE clienteUser = '" + user + "';";
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
    public String checkFilm(int code, String user) throws Exception {
        SQLConnection conn = new SQLConnection();
        try {
            Statement stmt = conn.myConnect.createStatement();
            String sqlStmt = "SELECT codigoFilme, nombreFilme FROM filmes"
                    + "WHERE codigoFilme = '" + code + "';";
            ResultSet rs = stmt.executeQuery(sqlStmt);
            rs.next();
            String rsCodigoValue = rs.getString("codigoFilme");
            String rsNombreValue = rs.getString("nombreFilme");
            if (rsCodigoValue.equals(code)) {
                setFilm(1, rsNombreValue, "user");
                return "Se ha introducido un filme alquilado a su cuenta.";
            } else {
                return "shit dont work yo";
            }
        } catch (Exception e) {
            return "Ese filme no existe. Por Favor revise el catalogo de filmes.";
            }
    }
    
public class Client {
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
}
}
