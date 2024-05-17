package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTOPeticion {
    @NotNull(message = "{pregunta.id.emply}")
    private int idpregunta;

    @NotNull(message = "{cuestionario.preguntas.emply}")
    private List<RespuestaDTOPeticion> respuestaEntities;
    public PreguntaDTOPeticion(){}
}
