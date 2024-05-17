package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta;


import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaDTORespuesta {
    private int idRespuesta;
    private String descripcion;
    private PreguntaDTORespuesta objPreguntaEntity;
}
