package proyecto.model;

import java.util.Date;

/**
 * Realizado por andre rodriguez el 4/23/2016
 * ESTRUCTURA DE DATOS DE UN COMERCIO
 */
public class Comercio {

    private int codigo;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Date fechaLicencia;
    private String ubicacion;
    private int telefono;
    private char estado;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setFechaLicencia(Date fechaLicencia) {
        this.fechaLicencia = fechaLicencia;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getFechaLicencia() {
        return fechaLicencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public char getEstado() {
        return estado;
    }
}
