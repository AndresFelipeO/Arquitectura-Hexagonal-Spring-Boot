package asst.unicauca.edu.co.parcialparteii.aplicacion.output;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;

import java.util.List;

public interface GestionarRespuestaCuestionarioGatewayIntPort {
    public boolean existeRespuestaCuestionario(int codigo);
    public Pregunta guardar(Pregunta pregunta, Cuestionario cuestionario, Docente docente);
    public boolean verificarDocenteCuestionario(Docente docente, Cuestionario cuestionario);
    public Docente obtenerDocentesCuestionario(int codigo);
}
