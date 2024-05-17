package asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso;

import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarRespuestaCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarRespuestaCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.RespuestaFormateadorResultadosIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.PreguntaEntity;

import java.util.List;
import java.util.function.Predicate;

public class GestionarRespuestaCuestionarioCUAdapter implements GestionarRespuestaCuestionarioCUIntPort{

    private final GestionarRespuestaCuestionarioGatewayIntPort objGestionarRespuestaCuestionarioGateway;
    private final RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados;

    public GestionarRespuestaCuestionarioCUAdapter(GestionarRespuestaCuestionarioGatewayIntPort objGestionarRespuestaCuestionarioGateway, RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados) {
        this.objGestionarRespuestaCuestionarioGateway = objGestionarRespuestaCuestionarioGateway;
        this.objRespuestaFormateadorResultados = objRespuestaFormateadorResultados;
    }

    @Override
    public Pregunta crear(Docente docente, Cuestionario cuestionario, Pregunta pregunta) {
        Pregunta preguntaCreada=null;

        if(this.objGestionarRespuestaCuestionarioGateway.verificarDocenteCuestionario(docente,cuestionario)){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, El docente ya respondio el cuestionario");
        }
        preguntaCreada=this.objGestionarRespuestaCuestionarioGateway.guardar(pregunta,cuestionario,docente);

        return preguntaCreada;
    }

    @Override
    public Docente listar(int idDocente) {
        return this.objGestionarRespuestaCuestionarioGateway.obtenerDocentesCuestionario(idDocente);
    }
}