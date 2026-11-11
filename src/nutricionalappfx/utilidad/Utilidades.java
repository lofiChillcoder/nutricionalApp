package nutricionalappfx.utilidad;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.scene.control.Alert;



/**
 *
 * @author Angel
 */
public class Utilidades {
    public static String generarCifradoSHA256(String dato) throws RuntimeException{  
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dato.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            
            for(byte b: hash){
                String hexadecimal = Integer.toHexString(0xff & b);
                if(hexadecimal.length() == 1){
                    hexString.append('0');
                }
                
                hexString.append(hexadecimal);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Error al cifrar la informacion");
        }
    }
    
    public static void mostrarAlertaSimple(String titulo, String contenido, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();    
    }
}
