/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nutricionalappfx.dominio.contrato;

import java.util.List;
import nutricionalappfx.dominio.pojo.OperacionResultado;
import nutricionalappfx.dominio.pojo.Paciente;

/**
 *
 * @author Angel
 */
public interface IPacienteRepository{
    
    public List<Paciente> obtenerPacientesNutriologo(int idNutriologo) throws RuntimeException;
    
    public OperacionResultado registrarPaciente(Paciente paciente) throws RuntimeException;
    
    public OperacionResultado editarPaciente(Paciente paciente) throws RuntimeException;
    
    public OperacionResultado eliminarPaciente(int idPaciente) throws RuntimeException;
    
    public boolean verificarExistenciaCodigoPaciente(String codigo) throws RuntimeException;
}
