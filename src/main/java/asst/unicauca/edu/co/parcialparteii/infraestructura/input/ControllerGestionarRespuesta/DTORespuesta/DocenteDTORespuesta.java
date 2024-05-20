package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORespuesta {
    private int idpersona;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo ;
    private String vinculacion;
    private List<RespuestaDTORespuesta> respuestaEntities;

    public DocenteDTORespuesta(){};
}
