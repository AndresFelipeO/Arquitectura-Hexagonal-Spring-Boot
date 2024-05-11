package asst.unicauca.edu.co.parcialparteii.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPregunta {
    private  int idtipPregunta;
    private String nombre;
    private String  descripcion;
    private List<Pregunta> pregunta;
}
