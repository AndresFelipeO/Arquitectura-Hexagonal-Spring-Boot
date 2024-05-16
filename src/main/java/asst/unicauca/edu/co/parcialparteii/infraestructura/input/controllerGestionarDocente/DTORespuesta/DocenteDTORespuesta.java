package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    private TelefonoDTORespuesta objTelefonoEntity;
    private List<DepartamentoDTORespuesta> departamentoEntities;

    public DocenteDTORespuesta(){};
}
