package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.gateway;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO: ver error del constructor y verificar como funciona el listar

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort {
    private final CuestionarioRepository cuestionarioRepository;
    private final ModelMapper cuestionarioModelMapper;

    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepository cuestionarioRepository,
                                                   ModelMapper cuestionarioModelMapper) {
        this.cuestionarioRepository = cuestionarioRepository;
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
        CuestionarioEntity objCuestionarioEntityRegistrado=this.cuestionarioRepository.save(objCuestionarioaEntity);



        return this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);
    }

    @Override
    public List<Cuestionario> Listar() {
        Iterable<CuestionarioEntity> lista=this.cuestionarioRepository.findAll();
        return this.cuestionarioModelMapper.map(lista,new TypeToken<List<Cuestionario>>(){}.getType());
    }
}
