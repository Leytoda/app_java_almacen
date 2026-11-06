package pe.com.empresa.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Levano
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private int idproducto;
    private String nombre;
    private String codigo;
    private double precio;
    private int stock;
}
