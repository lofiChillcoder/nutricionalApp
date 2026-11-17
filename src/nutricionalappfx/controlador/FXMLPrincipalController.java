
package nutricionalappfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/nutricionalappfx/vista/FXMLAdminPaciente.fxml"));
            Parent vista = loader.load();

            Scene escena = new Scene(vista);
            Stage stagePacientes = new Stage();
            stagePacientes.setScene(escena);
            stagePacientes.setTitle("Administrador de pacientes");
            stagePacientes.initModality(Modality.APPLICATION_MODAL);
            stagePacientes.showAndWait();
        }catch(IOException e){
            e.printStackTrace();
        }
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
