package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
public class TelefonoDTOPeticion {
    @NotNull(message = "{telefono.tipotelefono.emply}")
    @Size(min = 5, max = 25, message = "{telefono.tipotelefono.size}")
    private String tipoTelefono;

    @NotNull(message = "{telefono.numero.emply}")
    @Size(min = 10, max = 12, message = "{telefono.numero.size}")
    private String numero;

}
