package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docente extends Persona {
    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Departamento> departamentoEntities;
    private List<Respuesta> respuestaEntities;

}
