package nutricionalappfx.dominio.contrato;

import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorEstatus;

/**
 *
 * @author Angel
 */
public interface IAutenticacionRepository {
    
    public int verificarCredenciales(String noPersonal, String contrasenia) throws RuntimeException;
    
    public ColaboradorEstatus verificarEstatusColaborador(int idColaborador) throws RuntimeException;
    
    public Colaborador obtenerInformacionColaborador(int idColaborador) throws RuntimeException;
}
