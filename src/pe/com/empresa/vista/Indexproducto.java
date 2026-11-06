package pe.com.empresa.vista;

import java.util.List;
import pe.com.empresa.dao.Productodao;
import pe.com.empresa.daoimpl.Productodaoimpl;
import pe.com.empresa.modelo.Producto;
import pe.com.empresa.utils.Lectura;
import pe.com.empresa.utils.Utilitarios;

/**
 *
 * @author Levano
 */
public class Indexproducto {

    private static Lectura leer = new Lectura();
    private static Productodao daoimpl = new Productodaoimpl();

    public static void agregar() {
        System.out.println("Agregar producto: ");
        System.out.print("> Nombre: ");
        String nombre = leer.cadena();
        System.out.print("> Codigo: ");
        String codigo = leer.cadena();
        System.out.print("> Precio: ");
        double precio = leer.decimal();
        System.out.print("> Stock: ");
        int stock = leer.entero();
        Producto producto = new Producto(0, nombre, codigo, precio, stock);
        daoimpl.agregar(producto);
        System.out.print("> ");
    }

    public static void eliminar() {
        listar();
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id = leer.entero();
        daoimpl.eliminar(id);
    }

    public static void editar() {
        listar();
        System.out.print("Ingrese ID del producto a editar: ");
        int id = leer.entero();
        System.out.print("> Nuevo Nombre: ");
        String nombre = leer.cadena();
        System.out.print("> Nuevo Codigo: ");
        String codigo = leer.cadena();
        System.out.print("> Nuevo Precio: ");
        double precio = leer.decimal();
        System.out.print("> Nuevo Stock: ");
        int stock = leer.entero();
        Producto producto = new Producto(id, nombre, codigo, precio, stock);
        daoimpl.editar(producto);
    }

    public static void listar() {
        List<Producto> productos = daoimpl.listar();
        System.out.println("LISTADO DE PRODUCTOS");
        System.out.println("#\tID\tCodigo\tNombre\tPrecio\tStock");
        int num = 0;
        for (Producto producto : productos) {
            num++;
            System.out.println(num + "\t"
                    + producto.getIdproducto() + "\t"
                    + producto.getCodigo() + "\t"
                    + producto.getNombre() + "\t"
                    + producto.getPrecio() + "\t"
                    + producto.getStock()
            );
        }
    }

    public static void buscarporcodigo() {
        System.out.println("BUSCAR POR CODIGO");
        System.out.print("Codigo: ");
        String codigo = leer.cadena();
        List<Producto> productos = daoimpl.buscarporcodigo(codigo);
        if (productos.isEmpty()) {
            System.out.println("No existe productos con el codigo: " + codigo);
        } else {
            System.out.println("Autor: Levano");
            System.out.println("LISTADO DE PRODUCTOS ENCONTRADOS");
            System.out.println("ID\tCodigo\tNombre\tPrecio\tStock");
            int num = 0;
            Producto producto = productos.get(0);            
            System.out.println(
                      producto.getIdproducto() + "\t"
                    + producto.getCodigo() + "\t"
                    + producto.getNombre() + "\t"
                    + producto.getPrecio() + "\t"
                    + producto.getStock()
            );
        }
    }

    public static void menu() {
        System.out.println("""
                           * DATOS DEL PRODUCTO *
                           1. AGREGAR
                           2. ELIMINAR
                           3. EDITAR
                           4. LISTAR
                           5. BUSCAR
                           6. SALIR
                           """);
        System.out.print("Escoja una opcion [1-6]: ");
    }

    public static void inicio() {
        int opcion;
        do {
            Utilitarios.lineasenblanco(3);
            menu();
            opcion = leer.entero();
            switch (opcion) {
                case 1 ->
                    agregar();
                case 2 ->
                    eliminar();
                case 3 ->
                    editar();
                case 4 ->
                    listar();
                case 5 ->
                    buscarporcodigo();
                case 6 ->
                    Utilitarios.salir();
                default ->
                    Utilitarios.error(1);
            }
        } while (opcion != 6);
    }
}
