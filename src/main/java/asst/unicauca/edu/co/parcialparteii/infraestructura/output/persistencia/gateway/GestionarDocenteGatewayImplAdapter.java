package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.gateway;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarDocenteGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DepartamentoEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DocenteEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.TelefonoEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.DepartamentoRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.DocenteRepository;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios.TelefonoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {
    private final DocenteRepository docenteRepository;
    private final TelefonoRepository telefonoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepository docenteRepository,
                                              TelefonoRepository telefonoRepository,
                                              DepartamentoRepository departamentoRepository,
                                              ModelMapper docenteModelMapper) {
        this.docenteRepository = docenteRepository;
        this.telefonoRepository = telefonoRepository;
        this.departamentoRepository = departamentoRepository;
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
        TelefonoEntity telefono=objDocenteEntity.getObjTelefonoEntity();
        telefono.setObjPersona(objDocenteEntity);

        List<DepartamentoEntity> lista=new ArrayList<>();
        for(DepartamentoEntity departamento: objDocenteEntity.getDepartamentoEntities()){
            Optional<DepartamentoEntity> departamentoEntity=this.departamentoRepository.findById(departamento.getIdDepartamento());
            lista.add(departamentoEntity.get());
        }

        objDocenteEntity.setDepartamentoEntities(lista);
        DocenteEntity objDocenteEntityRegistrado=this.docenteRepository.save(objDocenteEntity);
        return this.docenteModelMapper.map(objDocenteEntityRegistrado,Docente.class);   
        
    }
}
