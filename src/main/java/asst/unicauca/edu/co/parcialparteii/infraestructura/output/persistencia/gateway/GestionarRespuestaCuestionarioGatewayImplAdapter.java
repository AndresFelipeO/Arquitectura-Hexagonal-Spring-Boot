package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.gateway;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarRespuestaCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DocenteEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.RespuestaEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.RespuestaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GestionarRespuestaCuestionarioGatewayImplAdapter implements GestionarRespuestaCuestionarioGatewayIntPort {
    private final RespuestaRepository respuestaRepository;
    private final ModelMapper respuestaModelMapper;;

    public GestionarRespuestaCuestionarioGatewayImplAdapter(RespuestaRepository respuestaRepository, ModelMapper respuestaModelMapper) {
        this.respuestaRepository = respuestaRepository;
        this.respuestaModelMapper = respuestaModelMapper;
    }


    @Override
    public boolean existeRespuestaCuestionario(int codigo) {
        return this.respuestaRepository.existeRespuestaPorCodigo(codigo)==1;
    }

    @Override
    public Respuesta guardar(Respuesta respuesta) {
        RespuestaEntity objRespuestaEntity=respuestaModelMapper.map(respuesta,RespuestaEntity.class);
        RespuestaEntity objRespuestaEntityRegistrada=this.respuestaRepository.save(objRespuestaEntity);
        return this.respuestaModelMapper.map(objRespuestaEntityRegistrada,Respuesta.class);
    }

    @Override
    public boolean verificarDocenteCuestionario(Docente docente, Cuestionario cuestionario) {
        DocenteEntity docenteEntity=respuestaModelMapper.map(docente,DocenteEntity.class);
        CuestionarioEntity cuestionarioEntity=respuestaModelMapper.map(cuestionario,CuestionarioEntity.class);

        List<RespuestaEntity> lista=docenteEntity.getRespuestaEntities();
        for (RespuestaEntity respuestaEntity : lista) {
            if(respuestaEntity.getObjPreguntaEntity().getObjCuestionarioEntity().getIdCuestionario()==cuestionarioEntity.getIdCuestionario()){
                return true;
            }
        }
        return false;

        /*
        return docente.getRespuestaEntities().stream()
                .anyMatch(respuesta -> respuesta.getObjPregunta().getObjCuestionario().getIdCuestionario() == cuestionario.getIdCuestionario());
    */
    }
}
