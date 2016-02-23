package registroEmpleados;
@SuppressWarnings("LeakingThisInConstructor")

public class EmpleadoNuevo{
    private String nombre;
    private String cedula;
    private int salario;
    private int antiguedad;
    public boolean asociacion;
    public EmpleadoNuevo(String nombreInicial, String cedulaInicial, int salarioInicial, 
            int antiguedadInicial, boolean asociacionInicial) {
        /** constructor inicializador */
        System.out.println();
        this.nombre = nombreInicial;
        this.cedula = cedulaInicial;
        this.salario = salarioInicial;
        this.antiguedad = antiguedadInicial;
        this.asociacion = asociacionInicial;
        SalarioFinal();
        retenciones(SalarioFinal());
        
    }
    public void setNombre(String argNombre){
        this.nombre = argNombre; // almacena el nombre
    } // fin de metodo setNombre
    public String getNombre(){
        return nombre; // retorna nombre
    } // fin de metodo getNombre
    public void setCedula(String argCedula){
        this.cedula = argCedula; // almacena la cedula
    } // fin de metodo setCedula
    public String getCedula(){
        return cedula; // retorna cedula
    } // fin de metodo getCedula
    public void setSalario(int argSalario){
        this.salario = argSalario; // almacena el nombre
    } // fin de metodo setNombre
    public int getSalario(){
        return salario; // retorna nombre
    } // fin de metodo getNombre
    public void setAntiguedad(int argAntiguedad){
        this.antiguedad = argAntiguedad; // almacena el nombre
    } // fin de metodo setNombre
    public int getAntiguedad(){
        return antiguedad; // retorna nombre
    } // fin de metodo getNombre
    
    /* metodos para los calculos solicitados */
    
    public double SalarioFinal(){
        double salarioFinal = salario;
        if (antiguedad < 3){
            salarioFinal = salarioFinal * 0.05;
        } else if ((antiguedad > 3) && (antiguedad < 5)) {
            salarioFinal = salarioFinal * 0.10;
        } else if ((antiguedad > 5) && (antiguedad < 10)) {
            salarioFinal = salarioFinal * 0.15;
        } else if (antiguedad > 10) {
            salarioFinal = salarioFinal * 0.20;
        } else {
            salarioFinal = 0;
        }
        return salarioFinal;
    }
    
    public double esDeAsociacion(double salarioFinal) {
        double salarioMax = salarioFinal;
        if (asociacion = true) {
            salarioMax = salarioMax + (salarioMax * 0.05); 
        }
        return salarioMax;
    }
    
    public double retenciones(double salarioMax){
        double conRetenciones = 0;
        if (salarioMax < 700000) {
            conRetenciones = salarioMax - (salarioMax * 0.05);
        } else if ((salarioMax > 700000) && (salarioMax < 900000)) {
            conRetenciones = ((salarioMax - (salarioMax * 0.10)) - (salarioMax * 0.5));
        } else if (salarioMax > 900000) {
            conRetenciones = ((salarioMax - (salarioMax * 0.15)) - (salarioMax * 0.10));
        }
        return conRetenciones;
    }
    @Override
    public String toString(){
        
        String message = "Ha introducido al siguiente empleado en el registro: \n"
            + "Nombre: " + this.nombre + "\n"
            + "Cedula: " + this.cedula + "\n";
        return message;
    }
}