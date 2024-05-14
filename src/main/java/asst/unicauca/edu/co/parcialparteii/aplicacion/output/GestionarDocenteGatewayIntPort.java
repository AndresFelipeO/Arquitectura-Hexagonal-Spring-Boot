package asst.unicauca.edu.co.parcialparteii.aplicacion.output;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {
    public boolean existeDocenteCodigo(int codigo);
    public boolean existeIdentificacion(String identificacion);
    public boolean existeCorreo(String correo);
    public Docente guardar(Docente docente);

}
