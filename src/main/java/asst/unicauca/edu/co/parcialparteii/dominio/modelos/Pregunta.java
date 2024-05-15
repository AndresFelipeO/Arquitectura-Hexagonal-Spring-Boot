package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
    private int idpregunta;
    private String enunciado;
    private TipoPregunta objTipoPreguntaEntity;
    private Cuestionario objCuestionario;
    private List<Respuesta> respuestaEntities;
}
