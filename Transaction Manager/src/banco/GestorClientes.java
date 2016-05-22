package banco;
import java.util.*;

public class GestorClientes {
private Cliente[] clientes = new Cliente[20];
private static int MAX_CLIENTES = 0;
private Cliente cliente;
private Cuenta cuenta;
public Scanner teclado = new Scanner(System.in);
    public void agregarCliente() {
        String nombre;
        String ap1;
        String ap2;
        System.out.println("Ingresar Nombre = ");
        nombre = teclado.next();
        System.out.println("Ingresar Apellido 1 = ");
        ap1 = teclado.next();
        System.out.println("Ingresar Apellido 2 = ");
        ap2 = teclado.next();
        cliente = new Cliente(nombre,ap1,ap2);
        if (MAX_CLIENTES < 20){
            clientes[MAX_CLIENTES] = cliente;
            MAX_CLIENTES++;
        }
        else
            System.out.println("Ya no puede agregar más Clientes");
    }
    public void agregarCuenta() throws Exception{
        double saldoInicial=0;
        double tasaInteres=0;
        int numeroCliente=0;
        int choice;
        try{
        System.out.println("Ingresar Numero Cliente: De 0 - 19 = ");
        numeroCliente = teclado.nextInt();
        if (numeroCliente < MAX_CLIENTES){
            if(clientes[numeroCliente].getCuenta() == null){
                System.out.println("Ingresar tipo de cuenta:");
                System.out.println("1: Cuenta de Ahorros");
                System.out.println("2: Cuenta Corriente");
                choice = teclado.nextInt();
                System.out.println("Ingresar Saldo de la Cuenta= ");
                saldoInicial  = teclado.nextDouble();
                // cambio 2
                // edicion del metodo agregar cuenta
                // inicio de metodo editado
                if (choice == 1) {
                    System.out.println("Ingresar la tasa de interes= ");
                    tasaInteres = teclado.nextDouble();
                    CuentaAhorros cuenta = new CuentaAhorros(saldoInicial, tasaInteres);
                    clientes[numeroCliente].setCuenta(cuenta);
                    clientes[numeroCliente].setTipoCuenta("Ahorros");
                    System.out.println("Se ha creado una Cuenta Corriente.");
                } else if (choice == 2) {
                    CuentaCorriente cuenta = new CuentaCorriente(saldoInicial);
                    clientes[numeroCliente].setCuenta(cuenta);
                    clientes[numeroCliente].setTipoCuenta("Corriente");
                    System.out.println("Se ha creado una Cuenta Corriente.");
                } else {
                    System.out.println("No ha ingresado una opcion valida.");
                }
                // fin de metodo editado
            }
            else
            {
                System.out.println("Cliente ya tiene Cuenta asociada");
            }
        }
        else
        {
            System.out.println("Cliente no existe");
        }
        } catch(Exception e){
            System.out.println("Ocurrio una excepción al agregar Cuenta");
            throw new Exception();
        }
    }
    public void deposito() throws Exception{
        double monto=0;
        int numeroCliente=0;
        Cliente paso;
        System.out.println("Ingresar Numero Cliente: De 0 - 19 = ");
        try{
        numeroCliente = teclado.nextInt();
        if (numeroCliente < MAX_CLIENTES ){
            paso =  clientes[numeroCliente];
            if (paso != null && paso.getCuenta() != null){
                System.out.println("Ingresar monto de Depósito = ");
                monto  = teclado.nextDouble();
                paso.getCuenta().depositar(monto);
            }
            else
            {
                System.out.println("Cliente o Cuenta no existe");
            }
                
        }
        else
        {
            System.out.println("Cliente no existe");
        }
        } catch(Exception e){
            System.out.println("Ocurrio una excepción al hacer un depósito");
            throw new Exception();
        }

    }
    public void retiro() throws Exception{
        double monto=0;
        int numeroCliente=0;
        Cliente paso;
        Cuenta paso1;
        System.out.println("Ingresar Numero Cliente: De 0 - 19 = ");
        try{
        numeroCliente = teclado.nextInt();
        if (numeroCliente < MAX_CLIENTES ){
            System.out.println("Ingresar monto a Retirar = ");
            monto  = teclado.nextDouble();
            paso =  clientes[numeroCliente];
            if (paso != null && paso.getCuenta() != null){
                if (!paso.getCuenta().retirar(monto));
                    System.out.println("No se pudo hacer el retiro, no tiene fondos ");
            }
            else
            {
                System.out.println("Cliente o Cuenta no existe");
            }
                
        }
        else
        {
            System.out.println("Cliente no existe");
        }
        } catch(Exception e){
            System.out.println("Ocurrio una excepción al hacer retiro");
            throw new Exception();
        }

    }
    public void verInformacion() throws Exception{
        int numeroCliente=0;
        Cliente paso;
        Cuenta paso1;
        System.out.println("Ingresar Numero Cliente: De 0 - 19 = ");
        try{
        numeroCliente = teclado.nextInt();
        if (numeroCliente < MAX_CLIENTES ){
            paso =  clientes[numeroCliente];
            if (paso != null && paso.getCuenta() != null){
                System.out.print("El número de cliente <<"+ numeroCliente+ ">> ");
                System.out.print(paso.getNombre()+" "+paso.getApellido1()+ " "+ paso.getApellido2());
                System.out.print(" tiene una cuenta de tipo " + paso.getTipoCuenta() + " con saldo = "+ paso.getCuenta().getSaldo());
                System.out.println();
            }
            else
            {
                System.out.println("Cliente o Cuenta no existe");
            }       
        }
        else
        {
            System.out.println("Cliente no existe");
        }
        } catch(Exception e){
            System.out.println("Ocurrio una excepción al Ver Información de un Cliente");
            throw new Exception();
        }

    }
}
