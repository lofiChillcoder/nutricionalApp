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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nutricionalappfx.NutricionalAppFX;
import nutricionalappfx.dominio.AutenticacionDM;
import nutricionalappfx.dominio.pojo.Autenticacion;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.modelo.dao.AutenticacionDAO;
import nutricionalappfx.utilidad.Utilidades;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class FXMLAutenticacionController implements Initializable {

    @FXML
    private Label lblErrorUsuario;
    @FXML
    private Label lblErrorPassword;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassContrasenia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        lblErrorUsuario.managedProperty().bind(lblErrorUsuario.visibleProperty());
        lblErrorPassword.managedProperty().bind(lblErrorPassword.visibleProperty());
        
        lblErrorUsuario.setVisible(false);
        lblErrorPassword.setVisible(false);
    }

    private boolean sonCamposVacios(){
        boolean esValido = true;
        lblErrorUsuario.setText("");
        lblErrorPassword.setText("");
        if(txtUsuario.getText().isEmpty()){
            lblErrorUsuario.setVisible(true);
            lblErrorUsuario.setText("El número de personal es obligatorio");
            esValido = false;
        }
        if(txtPassContrasenia.getText().isEmpty()){
            lblErrorPassword.setVisible(true);
            lblErrorPassword.setText("La contraseña es obligatoria");
            esValido = false;
        }
        
        return esValido;
        
    }
    
    private void validarCredenciales(String noPersonal, String password){
        AutenticacionDM autenticacionDM = 
                new AutenticacionDM(new AutenticacionDAO());
        try{
            Autenticacion respuesta =
                    autenticacionDM.verificarCredencialesColaborador(noPersonal, password);
            if(respuesta.isCredencialesCorrectas() && respuesta.isActivo()){
                Utilidades.mostrarAlertaSimple("Credenciales correctas", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
                irPantallaPrincipal(respuesta.getColaborador());
            }else{
                Utilidades.mostrarAlertaSimple("Lo sentimos :((", respuesta.getMensaje(), Alert.AlertType.WARNING);
            }
        }catch(RuntimeException e){
            Utilidades.mostrarAlertaSimple("ERROR", e.getMessage(), Alert.AlertType.ERROR);
        }
        
    }

    @FXML
    private void handleIngresar(ActionEvent event) {
        String noPersonal = txtUsuario.getText();
        String password = txtPassContrasenia.getText();
        if(sonCamposVacios()){
            validarCredenciales(noPersonal, password);
        }
    }
    
    private void irPantallaPrincipal(Colaborador colaborador){
        try{
            Stage escenario = (Stage) txtUsuario.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLPrincipal.fxml"));
            Parent vista = loader.load();
            FXMLPrincipalController controlador = loader.getController();
            controlador.inicializarInformacion(colaborador);
            Scene escena = new Scene(vista);
            escenario.setScene(escena);
            escenario.setTitle("Control nutricional");
            escenario.show();
            
            
        } catch(IOException e){
            e.printStackTrace();
        }
        
    
    }
    
    
}
