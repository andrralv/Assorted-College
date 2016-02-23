package registroEmpleados;
import java.util.Scanner;


public class Menu {
    String listaEmpleados[]; 
    public static void agregarEmpleado() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String nombreEmpleado = in.nextLine();
        System.out.println("Ingrese el numero de cedula: ");
        String cedulaEmpleado = in.nextLine();
        System.out.println("Ingrese el salario bruto: ");
        int salarioEmpleado = in.nextInt();
        System.out.println("Ingrese la cantidad de años laborados: ");
        int antiguedadEmpleado = in.nextInt();
        System.out.println("Pertenece a la asociacion solidarista?(y/n):");
        Character esAsociacion = in.next().charAt(0);
        boolean asociacionEmpleado = false;
        if (esAsociacion == 'y') {
            System.out.println("Usted introdujo: Sí pertenece");
            asociacionEmpleado = true;
            EmpleadoNuevo empleado = new EmpleadoNuevo(nombreEmpleado, cedulaEmpleado, 
                salarioEmpleado, antiguedadEmpleado, asociacionEmpleado);
            System.out.println();
            System.out.print(empleado.toString());
            System.out.println();
            RegistroEmpleados.lista.add(empleado);
        } else {
            System.out.println("Usted introdujo: No pertenece o caracter invalido.");
            EmpleadoNuevo empleado = new EmpleadoNuevo(nombreEmpleado, cedulaEmpleado, 
                salarioEmpleado, antiguedadEmpleado, asociacionEmpleado);
            System.out.println();
            System.out.print(empleado.toString());
            System.out.println();
            RegistroEmpleados.lista.add(empleado);

        }   
    }
    
    public static void verEmpleado() {
        for (EmpleadoNuevo i: RegistroEmpleados.lista) {
            System.out.println("---------------------------");
            System.out.println("Nombre: " + i.getNombre());
            System.out.println("Cedula: " + i.getCedula());
            System.out.println("Salario Bruto: " + i.getSalario());
            System.out.println("Salario Neto: " + (int)i.retenciones(i.getSalario()));
            System.out.println("Ha trabajado por: " + i.getAntiguedad() + " años\n\n");
        }
    }
}
