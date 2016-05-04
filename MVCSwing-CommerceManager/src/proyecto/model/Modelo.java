/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.model;

/**
 *
 * @author andre
 */
public class Modelo {
    public Comercio comercio = new Comercio();
    public Transaccion transaccion = new Transaccion();
    public EscribeComercio escribeComercio = new EscribeComercio();
    public EscribeTransaccion escribeTransaccion;
    public ManageDocument manageDocument;
    public BorrarComercio borrarComercio;
    public BorrarTransaccion borrarTransaccion;
    public MuestraComercioData muestraComercioData;
    public MuestraTransaccionData muestraTransaccionData;
    
}
