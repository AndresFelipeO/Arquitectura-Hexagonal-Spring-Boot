package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelefonoDTORespuesta {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    public TelefonoDTORespuesta(){}
}
