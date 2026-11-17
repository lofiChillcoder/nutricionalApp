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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class FXMLAdminPacienteController implements Initializable {

    @FXML
    private TextField txtBuscarPaciente;
    @FXML
    private TableView<?> tblRegistrosPacientes;
    @FXML
    private TableColumn<?, ?> colCodPaciente;
    @FXML
    private TableColumn<?, ?> colNombrePaciente;
    @FXML
    private TableColumn<?, ?> colApellidoPaternoPaciente;
    @FXML
    private TableColumn<?, ?> colApellidoMaternoPaciente;
    @FXML
    private TableColumn<?, ?> colFechaNacimientoPaciente;
    @FXML
    private TableColumn<?, ?> colTelefonoPaciente;
    @FXML
    private TableColumn<?, ?> colSexoPaciente;
    @FXML
    private TableColumn<?, ?> colAlturaPaciente;
    @FXML
    private TableColumn<?, ?> colPesoInicialPaciente;
    @FXML
    private TableColumn<?, ?> colCorreoPaciente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerBuscarPaciente(ActionEvent event) {
    }

    @FXML
    private void handlerIrFormularioAltaPaciente(ActionEvent event) {
    }

    @FXML
    private void handlerIrFormularioEditarPaciente(ActionEvent event) {
    }

    @FXML
    private void handlerRegresarAPrincipal(ActionEvent event) {
        Stage stagePacientes = (Stage) txtBuscarPaciente.getScene().getWindow();
        stagePacientes.close();
    }
    
}
