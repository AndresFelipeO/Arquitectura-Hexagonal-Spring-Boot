package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones;

import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.RespuestaDTOPeticion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion {
    private int idpersona;

    @NotNull(message = "{docente.tipoidentificacion.emply}")
    @Size(min = 5, max = 45, message = "{docente.tipoidentificacion.size}")
    private String tipoIdentificacion;

    @NotNull(message = "{docente.numeroidentificacion.emply}")
    @Size(min = 1, max = 10, message = "{docente.numeroidentificacion.size}")
    private String numeroIdentificacion;

    @NotNull(message = "{docente.nombres.emply}")
    @Size(min = 3, max = 20, message = "{docente.nombres.size}")
    private String nombres;

    @NotNull(message = "{docente.apellidos.emply}")
    @Size(min = 3, max = 20, message = "{docente.apellidos.size}")
    private String apellidos;

    @NotNull(message = "{docente.correo.emply}")
    @Size(min = 10, max = 30, message = "{docente.correo.size}")
    private String correo ;

    @NotNull(message = "{docente.vinculacion.emply}")
    @Size(min = 7, max = 30, message = "{docente.vinculacion.size}")
    private String vinculacion;

    @Valid
    private TelefonoDTOPeticion objTelefonoEntity;

    private List<DepartamentoDTOPeticion> departamentoEntities;
}
