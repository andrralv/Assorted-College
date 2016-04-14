package domain;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class logicaUsuario {
    public clientToDisplay retrieveUserData(String user) throws Exception {
    // revisa si un usuario ya existe en el registro
        // si retorna true no permite al usuario registrar
        boolean bool = false;
        SQLConnection conn = new SQLConnection();
        Statement stmt = null;
        clientToDisplay cliente = null;
        try {
        String sqlStmt = "SELECT clientes.clienteUser, clientes.clienteNombre, clientes.clienteApellido,"
                + " clientes.clienteSaldo, clientes.clienteTelefono,"
                + " clientes.clienteDireccion, clienteFilmes.nombreFilme,"
                + " clienteFilmes.codigoFilme"
                + " FROM clientes"
                + " INNER JOIN clienteFilmes"
                + " ON clientes.clienteUser = clienteFilmes.clienteUser"
                + " WHERE clientes.clienteUser = '" + user + "';";
        stmt = conn.myConnect.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStmt);
        rs.next();
        String rsUserValue = rs.getString("clienteUser");
        String rsNombreValue = rs.getString("clienteNombre");
        String rsApellidoValue = rs.getString("clienteApellido");
        double rsSaldoValue = rs.getDouble("clienteSaldo");
        int rsTelefonoValue = rs.getInt("clienteTelefono");
        String rsDireccionValue = rs.getString("clienteDireccion");
        String[] filmeList = new String[5];
        int[] filmeCodigoList = new int[5];
        int counter = 0;
        while (rs.next()) {
            if (!(rs.getString("clienteFilmes").isEmpty())) {
                String rsNombreFValue = rs.getString("nombreFilme");
                int rsFilmeValue = rs.getInt("codigoFilme");
                filmeList[counter] = rsNombreFValue;
                filmeCodigoList[counter] = rsFilmeValue;
                counter++;
            }
        }
        int rsCodigoValue = rs.getInt("codigoFilme");
        cliente = new clientToDisplay(rsUserValue, rsNombreValue, rsApellidoValue, rsSaldoValue,
        rsTelefonoValue, rsDireccionValue, filmeList, filmeCodigoList);
        }
    catch (Exception e) {
        e.printStackTrace();
        }
    return cliente;
    }  
}

class SQLConnection {
    // clase controladora para la logica del programa
    
    public SQLConnection() throws SQLException, ClassNotFoundException {
        makeConnection();
        Class.forName("com.mysql.jdbc.Driver");
    } 
    public Connection myConnect;  
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
}

class clientToDisplay {
    private String usuario;
    private String nombre;
    private String apellido;
    private double saldo;
    private int telefono;
    private String direccion;
    private String[] filmes;
    private int[] codigoFilmes;
    
    clientToDisplay(String usuario, String nombre, String apellido, double saldo,
            int telefono, String direccion, String[] filmes, int[] codigoFilmes) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.filmes = filmes;
        this.codigoFilmes = codigoFilmes;
    }
    public String getUser() {
        return this.usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public int getTelefono() {
        return this.telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public String[] getFilmes() {
        return this.filmes;
    }
    public int[] getCodigoFilmes() {
        return this.codigoFilmes;
    }
    public String saldoToString() {
        String stSaldo = Integer.toString((int) this.getSaldo());
        return stSaldo;
    }
    public String telToString() {
        String stTelefono = Integer.toString(this.getTelefono());
        return stTelefono;
    }
    
    public String thisString() {
        return "User: " + this.getUser() + "\n"
                + "Nombre: " + this.getNombre() + "\n"
                + "Apellido: " + this.getApellido() + "\n"
                + "Saldo: " + this.saldoToString() + "\n"
                + "telefono: " + this.telToString() + "\n"
                + "Direccion: " + this.getDireccion() + "\n";  
    }
}


