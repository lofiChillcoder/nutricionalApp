package nutricionalappfx.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class ConexionBD {

private static final Properties  propiedades = new Properties();

//Si se prefiere un método public static el método que se mande a llamar se estaría llamando siempre sabiendo que son los mismos datos
    //
    //Este carga los properties solo una vez, que cumple el objetivo
    static  {
        try{
            InputStream input = ConexionBD.class.getResourceAsStream("database.properties");
            if(input == null){
                throw new RuntimeException("Error: No se encontró el archivo");
            }
            propiedades.load(input);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Connection obtenerConexion() throws SQLException{
        try {
            Class.forName(propiedades.getProperty("db.driver"));
            return DriverManager.getConnection(propiedades.getProperty("db.url"),
                propiedades.getProperty("db.user"),
                propiedades.getProperty("db.password"));
        } catch (ClassNotFoundException ex) {
            throw new SQLException("No se encontró el driver de MySQL: " + ex.getMessage());
        }
    }
}
