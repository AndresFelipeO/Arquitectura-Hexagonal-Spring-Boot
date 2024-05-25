package asst.unicauca.edu.co.parcialparteii.aplicacion.output;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;

public interface GestionarRespuestaCuestionarioGatewayIntPort {
    public boolean existeRespuestaCuestionario(int codigo);
    public Pregunta guardar(Pregunta pregunta, Cuestionario cuestionario, Docente docente);
    public boolean verificarDocenteCuestionario(Docente docente, Cuestionario cuestionario);
    public Docente obtenerDocentesCuestionario(int codigo);
    public boolean existeCuestionarioDocente(int codigo);
}
