package trabajofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conectar = null;
    String usuario= "root";
    String contrasenia = "root";
    String bd = "argentina_programa";
    String ip = "localhost";
    String puerto = "3306";
    
    String ruta = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
    
    public Connection estableceConexion () {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(ruta, usuario, contrasenia);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se conectó correctamente" + e);
        }
        
        return conectar;
    }
    
    public void cerrarConexion () throws SQLException {
        
        try {
            
            conectar.close();
            
        } catch (Exception e) {
            
        }
    }
}
