package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor 
@NoArgsConstructor
public class Docente extends Persona {
    private String correo;
    private String vinculacion;
    private Telefono objTelefonoEntity;
    private List<Departamento> departamentoEntities;
    private List<Respuesta> respuestaEntities;

}
