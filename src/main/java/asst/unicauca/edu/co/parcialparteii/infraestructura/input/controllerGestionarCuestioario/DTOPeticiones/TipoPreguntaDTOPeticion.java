package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPreguntaDTOPeticion {
    @NotNull(message = "{tipopregunta.enunciado.emply}")
    private int idtipPregunta;
}
