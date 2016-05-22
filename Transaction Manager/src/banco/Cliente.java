package banco;

public class Cliente {

    private Cuenta cuenta;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipoCuenta;

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Cliente(String f, String l, String g) {
        nombre = f;
        apellido1 = l;
        apellido2 = g;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    // cambio 4
    // establece la cuenta dependiendo del datatype
    // usando poliformismo
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public void setCuenta(CuentaAhorros cuenta) {
        this.cuenta = cuenta;
    }
    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }
    
    // getter y setter para el tipo de cuenta del cliente
    public void setTipoCuenta(String tipo) {
        this.tipoCuenta = tipo;
    }
    
    public String getTipoCuenta() {
        return this.tipoCuenta;
    }
}
