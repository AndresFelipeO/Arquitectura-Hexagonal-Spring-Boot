package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTOPeticion {
    @NotNull(message = "{departamento.iddepartamento.emply}")
    private int idDepartamento;
    public DepartamentoDTOPeticion(){}
}
