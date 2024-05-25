package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORespuesta {
    private int idpregunta;
    private String enunciado;
    private TipoPreguntaDTORespuesta objTipoPreguntaEntity;
    
}
