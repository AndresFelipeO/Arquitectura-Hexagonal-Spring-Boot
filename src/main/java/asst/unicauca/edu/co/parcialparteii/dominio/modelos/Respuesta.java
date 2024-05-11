package asst.unicauca.edu.co.parcialparteii.dominio.modelos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private int idRespuesta;
    private String descripcion;
    private Docente objUsuario;
    private Pregunta objPregunta;
}