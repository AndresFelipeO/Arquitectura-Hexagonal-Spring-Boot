package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PeticionDTO {
    @NotNull(message = "{Error informacion del docente vacio}")
    DocenteDTOPeticion docenteDTO;
    @NotNull(message = "{Error informacion del cuestionario vacio}")
    CuestionarioDTOPeticion cuestionarioDTO;
    @NotNull(message = "{Error informacion de la pregunta vacio}")
    PreguntaDTOPeticion preguntaDTO;
    public PeticionDTO(){}
}
