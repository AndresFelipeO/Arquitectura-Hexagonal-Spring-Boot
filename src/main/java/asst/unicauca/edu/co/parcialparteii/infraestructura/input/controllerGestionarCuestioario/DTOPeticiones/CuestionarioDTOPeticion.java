package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTOPeticiones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuestionarioDTOPeticion {
    private int idCuestionario;
    @NotNull(message = "{cuestionario.titulo.emply}")
    @Size(min = 3, max = 100, message = "{cuestionario.titulo.size}")
    private String titulo;

    @NotNull(message = "{cuestionario.descripcion.emply}")
    @Size(min = 3, max = 400, message = "{cuestionario.descripcion.size}")
    private String descripcion;

    @Valid
    List<PreguntaDTOPeticion> preguntaEntities;

}
