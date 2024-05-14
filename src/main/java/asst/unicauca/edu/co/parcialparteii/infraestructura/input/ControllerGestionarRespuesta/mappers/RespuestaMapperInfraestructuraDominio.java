package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.mappers;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.RespuestaDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RespuestaMapperInfraestructuraDominio {
    Respuesta mappearDePeticionARespuesta(RespuestaDTOPeticion peticion);
    RespuestaDTORespuesta mappearDeRespuestaCARespuesta(Respuesta objRespuesta);
    List<RespuestaDTORespuesta> mappearDeRespuestaCARespuesta(List<Respuesta> respuestas);
}
