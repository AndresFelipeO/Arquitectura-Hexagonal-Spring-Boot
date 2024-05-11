package asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso;

import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.RespuestaFormateadorResultadosIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;

import java.util.List;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {
    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados;

    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
                                          RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultados){
        this.objGestionarCuestionarioGateway=objGestionarCuestionarioGateway;
        this.objRespuestaFormateadorResultados=objRespuestaFormateadorResultados;
    }

    @Override
    public Cuestionario crear(Cuestionario cuestionario) {
        Cuestionario objCuestionarioCreado=null;
        if(this.objGestionarCuestionarioGateway.existeCuestionarioCodigo(cuestionario.getIdCuestionario())){
            this.objRespuestaFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un cuestionario con el codigo");
        }else{
            if(this.objGestionarCuestionarioGateway.existeProductoPorTitulo(cuestionario.getTitulo())){
                this.objRespuestaFormateadorResultados.retornarRespuestaErrorReglaDeNegocio("Error, existe ya registrado el cuestionario del cuestionario");
            }
            objCuestionarioCreado=this.objGestionarCuestionarioGateway.guardar(cuestionario);
        }
        return  objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listar() {
        return objGestionarCuestionarioGateway.Listar();
    }
}
