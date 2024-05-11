package asst.unicauca.edu.co.parcialparteii.aplicacion.input;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;

import java.util.List;

public interface GestionarRespuestaCuestionarioCUIntPort {
    public Respuesta crear(Respuesta respuesta);
    public List<Respuesta> verificarRespuesta(Docente docente, Cuestionario cuestionario);
}