package pe.com.empresa.utils;

/**
 *
 * @author Levano
 */
public class Utilitarios {
    public static void salir(){
        System.out.println("Gracias por su visita");
    }
    public static void error(int tipo){
        System.out.print("Error: ");
        switch (tipo) {
            case 1 -> System.out.println("Opción inválida");
            case 2 -> System.out.println("Codigo incorrecto");
            case 3 -> System.out.println("No es un numero");
            default ->
                System.out.println("--");
        }
    }
    public static void lineasenblanco(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            System.out.println("");
        }
    }
}
