package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.mappers;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.CuestionarioDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.DocenteDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.PreguntaDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.DocenteDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.PreguntaDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RespuestaMapperInfraestructuraDominio {
    Pregunta mappearDePeticionARespuesta(PreguntaDTOPeticion peticion);
    PreguntaDTORespuesta mappearDeRespuestaCARespuesta(Pregunta objPregunta);
    DocenteDTORespuesta mappearDeRespuestaCARespuesta(Docente objDocente);
    List<RespuestaDTORespuesta> mappearDeRespuestaCARespuesta(List<Respuesta> respuestas);
    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);

     @Mappings({
        @Mapping(source = "idpersona", target = "idPersona")
    })
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);
}
