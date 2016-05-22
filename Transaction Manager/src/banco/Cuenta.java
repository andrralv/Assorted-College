package banco;

public class Cuenta {

  // cambio 3
  // se podria dejar private y utilizar getSaldo 
  // pero la intencion era probar la funcionalidad protected  
  protected double saldo;

  public Cuenta(double monto) {
    saldo = monto;
  }

  public double getSaldo() {
    return saldo;
  }
  
  public boolean depositar(double cantidad) {
    saldo = saldo + cantidad;
    return true;
  }
  public boolean retirar(double cantidad) {
    boolean resultado = true;
    if ( saldo < cantidad ) {
      resultado= false;
    } else {
      saldo = saldo - cantidad;
    }
    return resultado;
  }
}
