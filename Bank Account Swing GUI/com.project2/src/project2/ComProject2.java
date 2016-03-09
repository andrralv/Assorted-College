package project2;


public class ComProject2 {
       static Cliente[] first = new Cliente[20];
    public static void main(String args[]) {
        // clase main principal del programa 
        MarcoPrograma programaCuentas = new MarcoPrograma();
        for (int i=0;i<first.length; i++){
          first[i] = new Cliente();  
        }
    }
}
