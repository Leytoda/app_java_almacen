package pe.com.empresa.dao;

import java.util.List;
import pe.com.empresa.modelo.Producto;

/**
 *
 * @author Levano
 */
public interface Productodao {
    boolean agregar(Producto producto);
    boolean eliminar(int idproducto);
    boolean editar(Producto producto);
    List<Producto> listar();
    List<Producto> buscarporcodigo(String codigo);
}
