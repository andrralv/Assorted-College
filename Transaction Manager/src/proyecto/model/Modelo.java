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
    public EscribeTransaccion escribeTransaccion = new EscribeTransaccion();
    public ManageDocument manageDocument;
    public BorrarComercio borrarComercio = new BorrarComercio();
    public BorrarTransaccion borrarTransaccion = new BorrarTransaccion();
    public MuestraComercioData muestraComercioData = new MuestraComercioData();
    public MuestraTransaccionData muestraTransaccionData = new MuestraTransaccionData();
}
