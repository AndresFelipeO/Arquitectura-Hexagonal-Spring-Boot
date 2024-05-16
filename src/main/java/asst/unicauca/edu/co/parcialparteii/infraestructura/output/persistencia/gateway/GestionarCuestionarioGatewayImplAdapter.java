package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.gateway;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.PreguntaEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.TipoPreguntaEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.PreguntaRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.TipoPreguntaRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO: ver error del constructor y verificar como funciona el listar

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort {
    private final CuestionarioRepository cuestionarioRepository;
    private final PreguntaRepository preguntaRepository;
    private final TipoPreguntaRepository tipoPreguntaRepository;
    private final ModelMapper cuestionarioModelMapper;

    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepository cuestionarioRepository, PreguntaRepository preguntaRepository,
                                                    TipoPreguntaRepository tipoPreguntaRepository,ModelMapper cuestionarioModelMapper) {
        this.cuestionarioRepository = cuestionarioRepository;
        this.preguntaRepository=preguntaRepository;
        this.tipoPreguntaRepository=tipoPreguntaRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }


    @Override
    public boolean existeCuestionarioCodigo(int codigo) {
        return this.cuestionarioRepository.existeCuestionarioPorCodigo(codigo)==1;
    }

    @Override
    public boolean existeProductoPorTitulo(String nombre) {
        return this.cuestionarioRepository.existeCuestionarioPorTitulo(nombre)==1;
    }

    @Override
    public Cuestionario guardar(Cuestionario cuestionario) {
        CuestionarioEntity objCuestionarioaEntity=this.cuestionarioModelMapper.map(cuestionario, CuestionarioEntity.class);
        List<PreguntaEntity> lista=new ArrayList<>();
        for(PreguntaEntity preguntas:objCuestionarioaEntity.getPreguntaEntities()){
            Optional<TipoPreguntaEntity> tipoPregunta=tipoPreguntaRepository.findById(preguntas.getObjTipoPreguntaEntity().getIdtipPregunta());
            preguntas.setObjTipoPreguntaEntity(tipoPregunta.get());
            List<PreguntaEntity> existingPreguntas = tipoPregunta.get().getPreguntaEntity();
            existingPreguntas.add(preguntas);
            tipoPregunta.get().setPreguntaEntity(existingPreguntas);
            preguntas.setObjCuestionarioEntity(objCuestionarioaEntity);
            lista.add(preguntas);
        }
        objCuestionarioaEntity.setPreguntaEntities(lista);
        CuestionarioEntity objCuestionarioEntityRegistrado=this.cuestionarioRepository.save(objCuestionarioaEntity);
        return this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);
        //return cuestionario;
    }

    @Override
    public List<Cuestionario> Listar() {
        Iterable<CuestionarioEntity> lista=this.cuestionarioRepository.findAll();
        return this.cuestionarioModelMapper.map(lista,new TypeToken<List<Cuestionario>>(){}.getType());
    }
}
