package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTOPeticiones;

import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.RespuestaDTOPeticion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTOPeticion {

    private int idpregunta;

    @NotNull(message = "{pregunta.enunciado.emply}")
    @Size(min = 3, max = 400, message = "{pregunta.enunciado.size}")
    private String enunciado;

    List<RespuestaDTOPeticion> respuestaEntities;

    @Valid
    private TipoPreguntaDTOPeticion objTipoPreguntaEntity;
}
