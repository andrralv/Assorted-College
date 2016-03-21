package Controlador;
import java.util.ArrayList;

public class ClientList {
    private myList lista;
    public ClientList() {
        this.lista = new myList();
    }  
    public myList getLista() {
        return this.lista;
    }
}

class myList {
    public ArrayList<Controlador.SQLConnection.Client> lista;
    myList() {
        this.lista = new ArrayList<>();
    }
}

