package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTORespuesta {
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    private List<PreguntaDTORespuesta> preguntaEntities;

    public CuestionarioDTORespuesta(){}
}
