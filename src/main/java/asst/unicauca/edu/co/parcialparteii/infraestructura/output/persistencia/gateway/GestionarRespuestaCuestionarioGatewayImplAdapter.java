package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.gateway;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarRespuestaCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DocenteEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.PreguntaEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.RespuestaEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.DocenteRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.PreguntaRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.RespuestaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GestionarRespuestaCuestionarioGatewayImplAdapter implements GestionarRespuestaCuestionarioGatewayIntPort {
    private final RespuestaRepository respuestaRepository;
    private final PreguntaRepository preguntaRepository;
    private final DocenteRepository docenteRepository;
    private final CuestionarioRepository cuestionarioRepository;
    private final ModelMapper respuestaModelMapper;

    public GestionarRespuestaCuestionarioGatewayImplAdapter(RespuestaRepository respuestaRepository,
                                                            ModelMapper respuestaModelMapper,
                                                            CuestionarioRepository cuestionarioRepository,
                                                            PreguntaRepository preguntaRepository,
                                                            DocenteRepository docenteRepository) {
        this.respuestaRepository = respuestaRepository;
        this.docenteRepository = docenteRepository;
        this.preguntaRepository = preguntaRepository;
        this.cuestionarioRepository = cuestionarioRepository;
        this.respuestaModelMapper = respuestaModelMapper;
    }


    @Override
    public boolean existeRespuestaCuestionario(int codigo) {
        return this.respuestaRepository.existeRespuestaPorCodigo(codigo)==1;
    }

    @Override
    public Pregunta guardar(Pregunta pregunta, Cuestionario cuestionario, Docente docente) {
        Optional<PreguntaEntity> objPreguntaEntity = this.preguntaRepository.findById(pregunta.getIdpregunta());
        Optional<DocenteEntity> objDocenteEntity=this.docenteRepository.findById(docente.getIdPersona());
        List<RespuestaEntity> lista=objDocenteEntity.get().getRespuestaEntities();        
        for(Respuesta respuesta:pregunta.getRespuestaEntities()){
            RespuestaEntity respuestaEntity=this.respuestaModelMapper.map(respuesta,RespuestaEntity.class);
            respuestaEntity.setObjPreguntaEntity(objPreguntaEntity.get());
            respuestaEntity.setObjUsuario(objDocenteEntity.get());
            lista.add(respuestaEntity);
        }
        objDocenteEntity.get().setRespuestaEntities(lista);

        this.respuestaRepository.saveAll(lista);
        return this.respuestaModelMapper.map(objPreguntaEntity.get(),Pregunta.class);
    }

    @Override
    public boolean verificarDocenteCuestionario(Docente docente, Cuestionario cuestionario) {
        Optional<DocenteEntity> docenteEntity=this.docenteRepository.findById(docente.getIdPersona());
        Optional<CuestionarioEntity> cuestionarioEntity=this.cuestionarioRepository.findById(cuestionario.getIdCuestionario());
        List<RespuestaEntity> lista=docenteEntity.get().getRespuestaEntities();
        for (RespuestaEntity respuestaEntity : lista) {

            if(respuestaEntity.getObjPreguntaEntity().getObjCuestionarioEntity().getIdCuestionario()==cuestionarioEntity.get().getIdCuestionario()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Docente obtenerDocentesCuestionario(int codigo) {
        Optional<DocenteEntity> docenteEntity=this.docenteRepository.findById(codigo);
        return this.respuestaModelMapper.map(docenteEntity.get(),Docente.class);
    }

    @Override
    public boolean existeCuestionarioDocente(int codigo) {
        DocenteEntity objDocenteEntity=this.docenteRepository.findById(codigo).get();
        if(objDocenteEntity.getRespuestaEntities().size()<=0)
            return false;
        return true;
    }


    @Override
    public boolean verificarPreguntaCuestionario(Cuestionario cuestionario, Pregunta pregunta) {
        Optional<CuestionarioEntity> cuestionarioEntity=this.cuestionarioRepository.findById(cuestionario.getIdCuestionario());
        for(PreguntaEntity objPreguntaEntity:cuestionarioEntity.get().getPreguntaEntities()){
            if(objPreguntaEntity.getIdpregunta()==pregunta.getIdpregunta()){
                return true;
            }
        }
        return false;
    }
}