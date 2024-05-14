package asst.unicauca.edu.co.parcialparteii.infraestructura.configuracion;


import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarDocenteGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.GestionarRespuestaCuestionarioGatewayIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.output.RespuestaFormateadorResultadosIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso.GestionarCuestionarioCUAdapter;
import asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso.GestionarDocenteCUAdapter;
import asst.unicauca.edu.co.parcialparteii.dominio.casosDeUso.GestionarRespuestaCuestionarioCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarCuestionarioCUAdapter crearGestionarCuestionarioCUInt(GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
                                                                          RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultadosIntPort
    ) {
        return new GestionarCuestionarioCUAdapter(
                objGestionarCuestionarioGateway,objRespuestaFormateadorResultadosIntPort
        );
    }

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(GestionarDocenteGatewayIntPort objGestionarDocenteGatewayIntPort,
                                                                RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultadosIntPort){
        return new GestionarDocenteCUAdapter(objGestionarDocenteGatewayIntPort,objRespuestaFormateadorResultadosIntPort);
    }

    @Bean
    public GestionarRespuestaCuestionarioCUAdapter crearGestionarRespuestaCuestionarioCUInt(GestionarRespuestaCuestionarioGatewayIntPort objGestionarRespuestaCuestionarioGateway,
                                                                                            RespuestaFormateadorResultadosIntPort objRespuestaFormateadorResultadosIntPort){
        return new GestionarRespuestaCuestionarioCUAdapter(objGestionarRespuestaCuestionarioGateway,objRespuestaFormateadorResultadosIntPort);
    }
}
