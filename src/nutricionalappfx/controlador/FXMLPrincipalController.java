
package nutricionalappfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nutricionalappfx.dominio.pojo.Colaborador;

/**
 * FXML Controller class
 *
 * @author Angel
 */


public class FXMLPrincipalController implements Initializable {

    private Colaborador colaborador;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblRol;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void inicializarInformacion(Colaborador colaborador){
        this.colaborador = colaborador;
        mostrarInfoPantalla();
    }
    
    private void mostrarInfoPantalla(){
        
        if(colaborador != null){
            lblNombre.setText("Bienvenido(a) " + colaborador.toString());
            lblRol.setText("Rol: " + colaborador.getRol());
            
        }
    }

    @FXML
    private void handlerCerrarSesion(ActionEvent event) {
    }

    @FXML
    private void handlerIrAdminColaboradores(ActionEvent event) {
    }

    @FXML
    private void handlerIrAdminPacientes(ActionEvent event) {
    }

    @FXML
    private void handlerIrAdminCitas(ActionEvent event) {
    }

    @FXML
    private void handlerIrAdminDietas(ActionEvent event) {
    }

    @FXML
    private void handlerIrConsultas(ActionEvent event) {
    }
}
