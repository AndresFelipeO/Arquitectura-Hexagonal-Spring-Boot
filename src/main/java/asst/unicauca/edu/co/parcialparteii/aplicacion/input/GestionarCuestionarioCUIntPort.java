package asst.unicauca.edu.co.parcialparteii.aplicacion.input;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;

import java.util.List;

public interface GestionarCuestionarioCUIntPort {
    public Cuestionario crear(Cuestionario cuestionario);
    public List<Cuestionario> listar();
}
