package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTORespuesta {
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    public CuestionarioDTORespuesta(){};
}
