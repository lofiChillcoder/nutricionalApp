/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nutricionalappfx.dominio.pojo.Paciente;

/**
 * FXML Controller class
 *
 * @author Angel
 */
public class FXMLAdminPacienteController implements Initializable {
    
    private int idNutriologo;

    private TextField txtBuscarPaciente;
    @FXML
    private TextField tfBuscarPaciente;
    @FXML
    private TableView<Paciente> tvPacientes;
    @FXML
    private TableColumn colCodigo;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApPaterno;
    @FXML
    private TableColumn colApMaterno;
    @FXML
    private TableColumn colFechaNacimiento;
    @FXML
    private TableColumn colPeso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        //tvPacientes.setItems(value);
    }    
    
    private void configurarColumnasTabla(){
        colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        colApMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colPeso.setCellValueFactory(new PropertyValueFactory("pesoInicial"));
        
    }

    @FXML
    private void handlerBuscarPaciente(ActionEvent event) {
        
    }

    private void handlerIrFormularioAltaPaciente(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/nutricionalappfx/vista/FXMLFormularioPaciente.fxml"));
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
    private void handlerRegresarAPrincipal(ActionEvent event) {
        Stage stagePacientes = (Stage) txtBuscarPaciente.getScene().getWindow();
        stagePacientes.close();
    }
    
    public void recibirInformacion(int idNutriologo){
        this.idNutriologo = idNutriologo;
    }

    @FXML
    private void handleBtnRegistrar(ActionEvent event) {
    }

    @FXML
    private void handleBtnEditar(ActionEvent event) {
    }

    @FXML
    private void handleBtnEliminar(ActionEvent event) {
    }
}
