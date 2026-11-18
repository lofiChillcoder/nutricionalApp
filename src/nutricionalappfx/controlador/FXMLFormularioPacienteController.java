/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nutricionalappfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class FXMLFormularioPacienteController implements Initializable {

    @FXML
    private TextField txtNombrePaciente;
    @FXML
    private TextField txtApellidoPaternoPaciente;
    @FXML
    private DatePicker datepFechaNacPaciente;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private TextField txtTelefonoPaciente;
    @FXML
    private TextField txtAlturaPaciente;
    @FXML
    private TextField txtPesoInicialPaciente;
    @FXML
    private TextField txtCorreoPaciente;
    @FXML
    private TextField txtApellidoMaternoPaciente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


   
    @FXML
    private void handlerRegistrarPaciente(ActionEvent event) {
    }

    @FXML
    private void handlerRegresarAPrincipal(ActionEvent event) {
        Stage stagePacientes = (Stage) txtNombrePaciente.getScene().getWindow();
        stagePacientes.close();
    }

 
}
