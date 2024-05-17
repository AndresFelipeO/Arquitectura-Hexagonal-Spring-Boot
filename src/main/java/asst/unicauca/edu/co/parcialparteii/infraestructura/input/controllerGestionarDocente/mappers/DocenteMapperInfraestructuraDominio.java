package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.mappers;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones.DocenteDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);
    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente objDocente);
    List<DocenteDTORespuesta> mappearDeDocenteARespuesta(List<Docente> docentes);

}
