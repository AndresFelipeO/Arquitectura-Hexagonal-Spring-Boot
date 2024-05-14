package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuestionario {
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntaEntities;
}
