package pe.com.empresa.utils;

import java.util.Scanner;

/**
 *
 * @author Levano
 */
public class Lectura {
    private static Scanner teclado = new Scanner(System.in);
    public String cadena(){
        return teclado.nextLine();
    }
    public int entero(){
        return Integer.parseInt(cadena());
    }
    public double decimal(){
        return Double.parseDouble(cadena());
    }
    public void cerrar(){
        teclado.close();
    }
}
