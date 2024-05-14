package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.mappers;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTOPeticiones.CuestionarioDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta.CuestionarioDTORespuesta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfraestructuraDominio {
    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);

    CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario objCuestionario);

    List<CuestionarioDTORespuesta> mappearDeCuestionarioARespuesta(List<Cuestionario> cuestionarios);
}
