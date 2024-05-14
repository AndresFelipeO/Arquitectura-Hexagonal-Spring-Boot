package asst.unicauca.edu.co.parcialparteii.infraestructura.output.formateador;

import asst.unicauca.edu.co.parcialparteii.aplicacion.output.RespuestaFormateadorResultadosIntPort;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import org.springframework.stereotype.Service;

@Service
public class CuestionarioFormateadorResultadosImplAdapter implements RespuestaFormateadorResultadosIntPort {
    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}
