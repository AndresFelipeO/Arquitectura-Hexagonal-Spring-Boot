package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    private int idDepartamento;
    private String nombre;
    private String descripcion;

}
