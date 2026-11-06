package pe.com.empresa.config.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Levano
 */
public class Conectabd {
    private static Connection c = null;
    private static final String BD = "Almacen.db";
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:";
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            if (c == null || c.isClosed()) {
                c = DriverManager.getConnection(URL + BD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        System.out.println("<Base de Datos: " + BD + " > OK");
        return c;
    }
}
