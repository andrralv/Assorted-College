package Controlador;
import java.util.ArrayList;

public class ClientList {
    // crea un arraylist con objetos cliente
    public ArrayList<Controlador.SQLConnection.Client> lista;
    ClientList() {
        this.lista = new ArrayList<>();
    }
    ArrayList getLista(){
        return this.lista;
    }
}