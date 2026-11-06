package pe.com.empresa.config.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Levano
 */
public class Eliminartablas {
    public static void inicio(){
        Conectabd cn = new Conectabd();
        String sql = """
                     DROP TABLE IF EXISTS PRODUCTO;       
                     """;
        try(    Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("<TABLA PRODUCTO, ELIMINADA  CORRECTAMENTE>");
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Error: NO SE PUDO ELIMINAR LA TABLA PRODUCTO");
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        inicio();
    }
}
