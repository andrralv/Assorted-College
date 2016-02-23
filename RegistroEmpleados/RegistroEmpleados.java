package registroEmpleados;
import java.util.Scanner;
import java.util.ArrayList;
// Andre Rodriguez - 18/02/2016
// Tarea 1 - ProgIntermedia

public class RegistroEmpleados {
    public static ArrayList<EmpleadoNuevo> lista = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean salir = false;
        System.out.println("\nBienvenido al programa 'Calcula Salarios' de la compañia Ficticia S.A.");
        System.out.println();
        while (salir == false){
            System.out.print("1. Ingresar empleado \n2. Ver Empleados \n3. Salir del Programa");
            System.out.print("\n> ");
            int seleccion = in.nextInt();
            switch (seleccion) {
                case 1:
                    Menu.agregarEmpleado();
                    continue;
                case 2:
                    Menu.verEmpleado();
                    continue;
                case 3:
                    System.out.println("Saliendo del programa...");
                    salir = true;
            }
        }
    }
}