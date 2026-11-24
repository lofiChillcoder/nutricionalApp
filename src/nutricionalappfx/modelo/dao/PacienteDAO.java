package nutricionalappfx.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nutricionalappfx.dominio.contrato.IPacienteRepository;
import nutricionalappfx.dominio.pojo.OperacionResultado;
import nutricionalappfx.dominio.pojo.Paciente;
import nutricionalappfx.modelo.ConexionBD;

/**
 *
 * @author Angel
 */
public class PacienteDAO implements IPacienteRepository{

    @Override
    public List<Paciente> obtenerPacientesNutriologo(int idNutriologo) throws RuntimeException {
        List<Paciente> listaPacientes = new ArrayList<>();
        String sentencia = "select codigo, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, pesoInicial from pacientes " +
            "where idNutriologo = ?";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sentencia)){    
            
            ps.setInt(1, idNutriologo);
            
            try(ResultSet resultado = ps.executeQuery()){
                if(resultado.next()){
                    Paciente paciente = new Paciente();
                    paciente.setCodigo(resultado.getString("codigo"));
                    paciente.setNombre(resultado.getString("nombre"));
                    paciente.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                    paciente.setApellidoMaterno(
                        (resultado.getString("apellidoMaterno") != null) ? resultado.getString("apellidoMaterno") : "");
                    paciente.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                    paciente.setPesoInicial(resultado.getFloat("pesoInicial"));
                    
                    listaPacientes.add(paciente);
                    
                } else {
                    throw new RuntimeException("Error en la integridad de los datos");
                }
                return listaPacientes;
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
    }

    @Override
    public OperacionResultado registrarPaciente(Paciente paciente) throws RuntimeException {
        OperacionResultado resultado = new OperacionResultado();
        
        String sentencia="INSERT INTO `nutricionapp`.`pacientes` (codigo, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, altura, pesoInicial, sexo, telefono, correo, idNutriologo) " +
            "VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sentencia)){
            
            ps.setString(1, paciente.getCodigo());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellidoPaterno());
            ps.setString(4, paciente.getApellidoMaterno());
            ps.setString(5, paciente.getFechaNacimiento());
            ps.setInt(6, paciente.getAltura());
            ps.setFloat(7, paciente.getPesoInicial());
            ps.setString(8, "" + paciente.getSexo());
            ps.setString(9, paciente.getTelefono());
            ps.setString(10, paciente.getCorreo());
            ps.setInt(11, paciente.getIdNutriologo());
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas > 0){
                resultado.setError(false);
                resultado.setMensaje("Información del paciente guardada correctamente");
            }else{
                resultado.setError(true);
                resultado.setMensaje("Lo sentimos, la información del paciente no se guardó, por favor intentelo nuevamente");
            }
            
            return resultado;
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error en el almacenamiento");
        }
    }

    @Override
    public OperacionResultado editarPaciente(Paciente paciente) throws RuntimeException {
        return null;
    }

    @Override
    public OperacionResultado eliminarPaciente(int idPaciente) throws RuntimeException {
        return null;
    }

    @Override
    public boolean verificarExistenciaCodigoPaciente(String codigo) throws RuntimeException {
        return false;
    }
    
}
