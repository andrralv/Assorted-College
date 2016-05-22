package banco;

// cambio 1 
// creacion de subclases
// cuenta ahorros procesa el saldo con una tasa de interes
public class CuentaAhorros extends Cuenta {
    private double tasaInteres;
    public CuentaAhorros(double saldoInicial, double tasaInteres) {
        super(saldoInicial);
        double miSaldo = saldoInicial - (saldoInicial * (tasaInteres / 100));
        this.setSaldo(miSaldo);
    }
    public void setSaldo(double miSaldo) {
      this.saldo = miSaldo;
  }
}

class CuentaCorriente extends Cuenta {
    public CuentaCorriente(double saldoInicial) {
        super(saldoInicial);
    } 
}