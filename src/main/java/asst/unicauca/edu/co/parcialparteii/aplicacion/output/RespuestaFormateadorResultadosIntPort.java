package asst.unicauca.edu.co.parcialparteii.aplicacion.output;

public interface RespuestaFormateadorResultadosIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
