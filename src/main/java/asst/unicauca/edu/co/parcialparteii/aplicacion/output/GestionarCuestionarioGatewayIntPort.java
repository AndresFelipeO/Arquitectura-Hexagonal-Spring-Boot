package asst.unicauca.edu.co.parcialparteii.aplicacion.output;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;

import java.util.List;

public interface GestionarCuestionarioGatewayIntPort {
    public boolean existeCuestionarioCodigo(int codigo);
    public boolean existeProductoPorTitulo(String nombre);
    public Cuestionario guardar(Cuestionario cuestionario);
    public List<Cuestionario> Listar();
}
