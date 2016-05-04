package proyecto.controller;

import java.util.ArrayList;
import proyecto.model.Comercio;

/**
 *
 * @author andre
 */
public class ListaComercios {
    public ArrayList<proyecto.model.Comercio> listaComercios;
        
    public ListaComercios() {
        this.listaComercios = new ArrayList<>();
    }
    
    public void addComercio(Comercio e) {
        listaComercios.add(e);
    }
    
    public Comercio getComercio(int code) {
        Comercio thisComercio = null;
        for (Comercio comercio: listaComercios) {
            if (comercio.getCodigo() == code) {
                return thisComercio = comercio;
            }
        }
    return thisComercio;
    }
    
    public ArrayList getArrayList() {
        return listaComercios;
    }
}
