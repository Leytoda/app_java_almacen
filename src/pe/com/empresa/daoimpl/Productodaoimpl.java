package pe.com.empresa.daoimpl;

import java.util.List;
import pe.com.empresa.config.bd.Conectabd;
import pe.com.empresa.dao.Productodao;
import pe.com.empresa.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Levano
 */
public class Productodaoimpl implements Productodao{
    private final Conectabd cn = new Conectabd();
    @Override
    public boolean agregar(Producto producto) {
        String sql = """
                     INSERT INTO PRODUCTO(NOMBRE, CODIGO, PRECIO, STOCK)
                     VALUES(?,?,?,?);
                     """;
        try (   Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql);
                ){
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getCodigo());
            pst.setDouble(3, producto.getPrecio());
            pst.setInt(4, producto.getStock());
            pst.executeUpdate();
            System.out.println("<SE AGREGÓ UN NUEVO PRODUCTO>");
        } catch (SQLException e) {
            System.out.println("<NO SE PUDO AGREGAR EL PRODUCTO>");
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(int idproducto) {
        String sql = """
                     DELETE FROM PRODUCTO
                     WHERE
                        IDPRODUCTO = ?;
                     """;
        try (   Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql);
                ){            
            pst.setInt(1, idproducto);
            pst.executeUpdate();
            System.out.println("<SE ELIMINO UN PRODUCTO>");
        } catch (SQLException e) {
            System.out.println("<NO SE PUDO ELIMINAR EL PRODUCTO>");
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Producto producto) {
        String sql = """
                     UPDATE PRODUCTO
                     SET
                        NOMBRE = ?,
                        CODIGO = ?,
                        PRECIO = ?,
                        STOCK = ?
                     WHERE
                        IDPRODUCTO = ?;
                     """;
        try (   Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql);
                ){
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getCodigo());
            pst.setDouble(3, producto.getPrecio());
            pst.setInt(4, producto.getStock());
            pst.setInt(5, producto.getIdproducto());
            pst.executeUpdate();
            System.out.println("<SE EDITÓ LOS DATOS DEL PRODUCTO>");
        } catch (SQLException e) {
            System.out.println("<NO SE PUDO EDITAR EL PRODUCTO>");
            return false;
        }
        return true;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM PRODUCTO;
                     """;
        try(    Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                ) {
            while (rs.next()) {                
                productos.add(new Producto(
                            rs.getInt("idproducto"),
                            rs.getString("nombre"),
                            rs.getString("codigo"),
                            rs.getDouble("precio"),
                            rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            System.out.println("No se pudo listar");
        }
        return productos;
    }

    @Override
    public List<Producto> buscarporcodigo(String codigo) {
        List<Producto> productos = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM PRODUCTO
                     WHERE
                        CODIGO = ?;
                     """;
        try(    Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql);                
                ) {
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {                
                productos.add(new Producto(
                            rs.getInt("idproducto"),
                            rs.getString("nombre"),
                            rs.getString("codigo"),
                            rs.getDouble("precio"),
                            rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el producto por codigo");
        }
        return productos;
    }    
}