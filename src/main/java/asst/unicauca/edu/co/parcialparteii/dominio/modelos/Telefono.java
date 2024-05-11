package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    private Docente objPersona;

}
