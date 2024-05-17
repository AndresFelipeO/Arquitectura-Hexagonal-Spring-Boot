package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTOPeticion {

    @NotNull(message = "{cuestionario.id.emply}")
    private int idCuestionario;
    public CuestionarioDTOPeticion(){}
}
