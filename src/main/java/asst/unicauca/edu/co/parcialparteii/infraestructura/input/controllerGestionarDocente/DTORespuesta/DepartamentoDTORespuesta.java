package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTORespuesta {
    private int idDepartamento;
    private String nombre;
    private String descripcion;
    public DepartamentoDTORespuesta(){}
}
