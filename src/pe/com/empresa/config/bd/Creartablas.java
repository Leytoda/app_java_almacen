package pe.com.empresa.config.bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Levano
 */
public class Creartablas {
    public static void inicio(){
        Conectabd cn = new Conectabd();
        String sql = """
                     CREATE TABLE IF NOT EXISTS PRODUCTO(
                        IDPRODUCTO  INTEGER PRIMARY KEY AUTOINCREMENT,
                        NOMBRE      TEXT NOT NULL,
                        CODIGO      TEXT NOT NULL UNIQUE,
                        PRECIO      REAL NOT NULL,
                        STOCK       INTEGER NOT NULL
                     );                     
                     """;
        try(    Connection c = cn.getConnection();
                PreparedStatement pst = c.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("<TABLA PRODUCTO, CREADA CORRECTAMENTE>");
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Error: NO SE PUDO CREAR LA TABLA PRODUCTO");
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        inicio();
    }
}
