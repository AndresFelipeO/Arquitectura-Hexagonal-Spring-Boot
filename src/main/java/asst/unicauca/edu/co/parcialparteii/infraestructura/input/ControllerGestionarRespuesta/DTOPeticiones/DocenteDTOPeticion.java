package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion {
    @NotNull(message = "{docente.iddocente.emply}")
    private int idpersona;
    public DocenteDTOPeticion(){};
}
