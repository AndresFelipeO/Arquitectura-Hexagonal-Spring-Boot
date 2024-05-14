package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.gateway;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarDocenteGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DocenteEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.DocenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {
    private final DocenteRepository docenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepository docenteRepository, ModelMapper docenteModelMapper) {
        this.docenteRepository = docenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }


    @Override
    public boolean existeDocenteCodigo(int codigo) {
        return this.docenteRepository.existeDocentePorCodigo(codigo)==1;
    }

    @Override
    public boolean existeIdentificacion(String identificacion) {
        return this.docenteRepository.existeDocentePorIdentificacion(identificacion)==1;
    }

    @Override
    public boolean existeCorreo(String correo) {
        return this.docenteRepository.existeDocentePorCorreo(correo)==1;
    }

    @Override
    public Docente guardar(Docente docente) {
        DocenteEntity objDocenteEntity=docenteModelMapper.map(docente, DocenteEntity.class);
        DocenteEntity objDocenteEntityRegistrado=this.docenteRepository.save(objDocenteEntity);
        return this.docenteModelMapper.map(objDocenteEntityRegistrado,Docente.class);
    }
}
