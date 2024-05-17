package asst.unicauca.edu.co.parcialparteii.aplicacion.input;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;

import java.util.List;

public interface GestionarRespuestaCuestionarioCUIntPort {
    public Pregunta crear(Docente docente, Cuestionario cuestionario, Pregunta respuesta);
    public Docente listar(int idDocente);
}