package asst.unicauca.edu.co.parcialparteii.aplicacion.input;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;

public interface GestionarRespuestaCuestionarioCUIntPort {
    public Respuesta crear(Respuesta respuesta);
    public Respuesta verificarRespuesta(Respuesta respuesta);
}