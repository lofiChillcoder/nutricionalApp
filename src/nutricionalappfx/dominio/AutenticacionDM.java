
package nutricionalappfx.dominio;

import nutricionalappfx.dominio.contrato.IAutenticacionRepository;
import nutricionalappfx.dominio.pojo.Autenticacion;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorEstatus;
import nutricionalappfx.utilidad.Utilidades;

/**
 *
 * @author Angel
 */
public class AutenticacionDM {
    
    private final IAutenticacionRepository contrato;
    private final int CREDENCIALES_INCORRECTAS = -1;
    private final int ESTATUS_COLABORADOR_ACTIVO = 1;
    private final int ESTATUS_COLABORADOR_SUSPENDIDO = 3;
    
    public AutenticacionDM(IAutenticacionRepository contrato){
        this.contrato = contrato;
    }
    
    public Autenticacion verificarCredencialesColaborador(String noPersonal, String password)
            throws RuntimeException{
        
        Autenticacion respuesta = new Autenticacion();
        //Programación defensiva: esperar siempre los peor
        if(noPersonal.isEmpty() || password.isEmpty()){
            respuesta.setCredencialesCorrectas(false);
            respuesta.setMensaje("Los campos no están en el formato solicitado");
            return respuesta;
        }
        
        String passwordCifrado = Utilidades.generarCifradoSHA256(password);
        int idColaborador = contrato.verificarCredenciales(noPersonal, passwordCifrado);
        
        if(idColaborador == CREDENCIALES_INCORRECTAS){
            respuesta.setCredencialesCorrectas(false);
            respuesta.setMensaje("Numero de personal y/o contraseña incorrectas");
            return respuesta;
        }
        ColaboradorEstatus estatus = contrato.verificarEstatusColaborador(idColaborador);
        
        if(estatus.getIdEstatus() == ESTATUS_COLABORADOR_ACTIVO){
            respuesta.setCredencialesCorrectas(true);
            respuesta.setActivo(true);
            Colaborador info = contrato.obtenerInformacionColaborador(idColaborador);
            respuesta.setColaborador(info);
            respuesta.setMensaje("Bienvenido(a) " +
                    info.getNombre() + " a tu sistema de gestión de pacientes");
            return respuesta;            
        }
        
        respuesta.setCredencialesCorrectas(true);
        respuesta.setActivo(false);
        if(estatus.getIdEstatus() == ESTATUS_COLABORADOR_SUSPENDIDO){
            respuesta.setMensaje("Lo sentimos tu cuenta ha sido suspendida indefinidamente" +
                     "\nContacta a un administrador al correo soporte@nutricionapp.com");
        }else{
            respuesta.setMensaje("Numero de personal y/o contraseña incorrectas");
        }
        
        return respuesta;
    }
    
}
