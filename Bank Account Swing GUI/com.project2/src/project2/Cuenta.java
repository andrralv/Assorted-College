package project2;

public class Cuenta {
    protected float saldo;
    public Cuenta() 
    {
        this.saldo = 0;
    }
    public void setSaldo(String saldoSet){
        this.saldo = Float.parseFloat(saldoSet);
    }
    public float getSaldo() {
        return this.saldo;
    }
    public void addSaldo(String monto){
        this.saldo += Float.parseFloat(monto);
    } 
    public void substractSaldo(String monto){
        if ((this.saldo - Float.parseFloat(monto)) < 0) {
            this.saldo = 0;
        }
        else {
            this.saldo -= Float.parseFloat(monto);
        }
    }
}

class Cliente extends Cuenta{
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String numCuenta;
    private Cuenta cuenta;
    public static int counter;
    
    public void Cliente(String nom, String ape1, String ape2) {
        this.nombre = nom;
        this.apellido1 = ape1;
        this.apellido2 = ape2;
        counter++;
        }
    
    public void setName(String name) {
        this.nombre = name;
    }
    public void setLastN(String lastN) {
        this.apellido1 = lastN;
    }
    public void setMaidenN(String maidenN) {
        this.apellido2 = maidenN;
    }
    public Cuenta getCuenta() {
        return this.cuenta;
    }  
    public String getNumCuenta() {
        return this.numCuenta;
    }
    public void setNumCuenta(String number) {
        this.numCuenta = number;
    }
    public float getMoney() {
        return this.saldo;
    }
}