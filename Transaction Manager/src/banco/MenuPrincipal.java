package banco;

public class MenuPrincipal {
    public static void main(String[] args) {
        GestorClientes prueba = new GestorClientes();
        int opcion = 0; 
        while (opcion != 6){
            System.out.println (" Menu de Opciones Tarea No. 2");
            System.out.println ("1-Crear Cliente");
            System.out.println ("2-Agregar Cuenta a un Cliente");
            System.out.println ("3-Hacer Depósito a Cuenta");
            System.out.println ("4-Hacer Retiro a Cuenta");
            System.out.println ("5-Ver Información de un Cliente");
            System.out.println ("6-Terminar");
            System.out.print("Digite opcion : ");
            try{
            opcion = prueba.teclado.nextInt();
            switch (opcion){
                case 1: prueba.agregarCliente();
                        break;
                case 2: prueba.agregarCuenta();
                        break;
                case 3: prueba.deposito();
                        break;
                case 4: prueba.retiro();
                        break;
                case 5: prueba.verInformacion();
                        break;
                case 6: System.out.println("Termina el programa....Digite cualquier tecla diferente a enter");
                        prueba.teclado.next();
                        break;
                default: System.out.println("Opción no válida");
            }    
        }catch(Exception ex){
            prueba.teclado.next();
        }
        }//Fin del while
        System.exit(0);
    }
}
