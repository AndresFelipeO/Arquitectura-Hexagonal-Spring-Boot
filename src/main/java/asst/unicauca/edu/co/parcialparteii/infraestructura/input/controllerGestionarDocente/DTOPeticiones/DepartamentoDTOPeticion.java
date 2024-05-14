package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTOPeticion {
    @NotNull(message = "{departamento.iddepartamento.emply}")
    private int iddepartamento;

    @NotNull(message = "{departamento.nombre.emply}")
    @Size(min = 5, max = 25, message = "{departamento.nombre.size}")
    private String nombre;

    @NotNull(message = "{departamento.descripcion.emply}")
    @Size(min = 5, max = 35, message = "{departamento.descripcion.size}")
    private String descripcion;
}
