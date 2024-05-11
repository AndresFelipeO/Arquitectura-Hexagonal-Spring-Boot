package asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso;

import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarDocenteCUIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarDocenteGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.RespuestaFormateadorResultadosIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objGestionarDocenteGateway, RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados) {
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
        this.objRespuestaFormateadorResultados = objRespuestaFormateadorResultados;
    }

    @Override
    public Docente crear(Docente docente) {
        Docente docenteCreado = null;
        if(this.objGestionarDocenteGateway.existeDocenteCodigo(docente.getIdPersona())){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, el docente con el id ya esta registrado");
        }else {
            if(this.objGestionarDocenteGateway.existeIdentificacion(docente.getNumeroIdentificacion())){
                this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, el identificacion ya existe");
            }
            docenteCreado=this.objGestionarDocenteGateway.guardar(docente);
        }
        return docenteCreado;
    }
}
