package proyecto.model;
import java.util.Date;

/**
 * creado por andre rodriguez el 4/23/2016
 * ESTRUCTURA DE DATOS DE UNA TRANSACCION
 */

public class Transaccion {
    private int codigoComercio;
    private Date fechaTiempoAutorizacion;
    private double monto;
    private int numAutorizacion;
    private char estado;

    public Transaccion(int codigo, Date fechaTiempoAutorizacion, double monto, int numAutorizacion, char estado) {
        this.codigoComercio = codigo;
        this.fechaTiempoAutorizacion = fechaTiempoAutorizacion;
        this.monto = monto;
        this.numAutorizacion = numAutorizacion;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigoComercio;
    }

    public void setCodigo(int codigo) {
        this.codigoComercio = codigo;
    }

    public Date getFechaTiempoAutorizacion() {
        return fechaTiempoAutorizacion;
    }

    public void setFechaTiempoAutorizacion(Date fechaAutorizacion) {
        this.fechaTiempoAutorizacion = fechaAutorizacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(int numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
