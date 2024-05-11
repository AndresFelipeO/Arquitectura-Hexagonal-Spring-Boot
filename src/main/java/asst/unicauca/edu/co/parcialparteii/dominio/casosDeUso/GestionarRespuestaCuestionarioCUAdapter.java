package asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso;

import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarRespuestaCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarRespuestaCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.RespuestaFormateadorResultadosIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;

import java.util.List;

public class GestionarRespuestaCuestionarioCUAdapter implements GestionarRespuestaCuestionarioCUIntPort{

    private final GestionarRespuestaCuestionarioGatewayIntPort objGestionarRespuestaCuestionarioGateway;
    private final RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados;

    public GestionarRespuestaCuestionarioCUAdapter(GestionarRespuestaCuestionarioGatewayIntPort objGestionarRespuestaCuestionarioGateway, RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados) {
        this.objGestionarRespuestaCuestionarioGateway = objGestionarRespuestaCuestionarioGateway;
        this.objRespuestaFormateadorResultados = objRespuestaFormateadorResultados;
    }

    @Override
    public Respuesta crear(Respuesta respuesta) {
        Respuesta respuestaCreada=null;
        if(this.objGestionarRespuestaCuestionarioGateway.existeRespuestaCuestionario(respuesta.getIdRespuesta())){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, existe id de respuesta");
        }else {
            if(this.objGestionarRespuestaCuestionarioGateway.cuestionarioYaRespondido(respuesta)){
                this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, El docente ya respondio el cuestionario");
            }
            respuestaCreada=this.objGestionarRespuestaCuestionarioGateway.guardar(respuesta);
        }
        return respuestaCreada;
    }

    @Override
    public List<Respuesta> verificarRespuesta(Docente docente, Cuestionario cuestionario) {
        List<Respuesta> respuestas=null;
        if(this.objGestionarRespuestaCuestionarioGateway.verificarDocenteCuestionario(docente,cuestionario)){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, el docente no ha respondido el cuestionario");
        }
        respuestas=docente.getRespuestaEntities();
        return respuestas;
    }
}
