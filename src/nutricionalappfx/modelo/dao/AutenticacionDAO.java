/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nutricionalappfx.dominio.contrato.IAutenticacionRepository;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorEstatus;
import nutricionalappfx.modelo.ConexionBD;

/**
 *
 * @author Angel
 */
public class AutenticacionDAO implements IAutenticacionRepository{

    @Override
    public int verificarCredenciales(String noPersonal, String contrasenia) throws RuntimeException {
        
        String consulta = "select idColaborador from colaboradores where noPersonal = ? and password = ?";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(consulta)){    
            
            ps.setString(1, noPersonal);
            ps.setString(2, contrasenia);
            
            try(ResultSet resultado = ps.executeQuery()){
                if(resultado.next()){
                    return resultado.getInt("idColaborador");
                }else{
                    return -1;
                }
            }
              
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
    }

    @Override
    public ColaboradorEstatus verificarEstatusColaborador(int idColaborador) throws RuntimeException {
        ColaboradorEstatus estatus = new ColaboradorEstatus();
        String consulta = "select c.idEstatus, e.estatus " +
                            "from colaboradores c " +
                            "inner join colaboradores_estatus e on e.idEstatus = c.idEstatus " +
                            "where idColaborador = ?";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(consulta)){    
            
            ps.setInt(1, idColaborador);
            
            try(ResultSet resultado = ps.executeQuery()){
                if(resultado.next()){
                    estatus.setIdEstatus(resultado.getInt("idEstatus"));
                    estatus.setEstatus(resultado.getString("estatus"));
                    return estatus;
                } else {
                    throw new RuntimeException("Error en la integridad de los datos");
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
    }

    @Override
    public Colaborador obtenerInformacionColaborador(int idColaborador) throws RuntimeException {
        Colaborador colaborador = new Colaborador(); 
        String consulta = "select idColaborador, noPersonal, nombre, apellidoPaterno, apellidoMaterno, fechaContratacion, c.idRol, r.rol, c.idEstatus, e.estatus " +
                            "from colaboradores c " +
                            "inner join roles r on r.idRol = c.idRol " +
                            "inner join colaboradores_estatus e on e.idEstatus = c.idEstatus " +
                            "where idColaborador = ?";
        
        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(consulta)){    
            
            ps.setInt(1, idColaborador);
            
            try(ResultSet resultado = ps.executeQuery()){
                if(resultado.next()){
                    colaborador.setIdColaborador(resultado.getInt("idColaborador"));
                    colaborador.setNoPersonal(resultado.getString("noPersonal"));
                    colaborador.setNombre(resultado.getString("nombre"));
                    colaborador.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                    colaborador.setApellidoMaterno(
                        (resultado.getString("apellidoMaterno") != null) ? resultado.getString("apellidoMaterno") : "");
                    colaborador.setFechaContratacion(resultado.getString("fechaContratacion"));
                    colaborador.setIdRol(resultado.getInt("idRol"));
                    colaborador.setRol(resultado.getString("rol"));
                    colaborador.setIdEstatus(resultado.getInt("idEstatus"));
                    colaborador.setEstatus(resultado.getString("estatus"));
                    
                    return colaborador;
                } else {
                    throw new RuntimeException("Error en la integridad de los datos");
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
    }
    
}
