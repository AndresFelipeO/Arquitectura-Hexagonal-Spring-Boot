package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.controladores;


import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarDocenteCUIntPort;
import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarRespuestaCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Respuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.RespuestaDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.mappers.RespuestaMapperInfraestructuraDominio;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTOPeticiones.CuestionarioDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta.CuestionarioDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.mappers.CuestionarioMapperInfraestructuraDominio;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones.DocenteDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RespuestaRestController {

    private final GestionarRespuestaCuestionarioCUIntPort objGestionarRespuestaCuestionarioCUInt;
    private final RespuestaMapperInfraestructuraDominio objMapperR;
    private final CuestionarioMapperInfraestructuraDominio objMapperC;
    private final DocenteMapperInfraestructuraDominio objMapperD;

    @PostMapping("/respuesta")
    public ResponseEntity<RespuestaDTORespuesta> crear(@RequestBody DocenteDTOPeticion objDocente,
                                                       CuestionarioDTOPeticion objCuestionario, RespuestaDTOPeticion objRespuesta) {
        Respuesta objCRespuestaCrear=objMapperR.mappearDePeticionARespuesta(objRespuesta);
        Cuestionario objCuestionarioCrear=objMapperC.mappearDePeticionACuestionario(objCuestionario);
        Docente objDocenteCrear=objMapperD.mappearDePeticionADocente(objDocente);
        Respuesta objRespuestaCreado=objGestionarRespuestaCuestionarioCUInt.crear(objDocenteCrear,objCuestionarioCrear,objCRespuestaCrear);

        return new ResponseEntity<RespuestaDTORespuesta>(
                objMapperR.mappearDeRespuestaCARespuesta(objRespuestaCreado), HttpStatus.CREATED
        );
    }

    @GetMapping("/respuesta")
    public ResponseEntity<List<RespuestaDTORespuesta>> listar(@RequestBody DocenteDTOPeticion objDocente){
        Docente objDocenteCrear=objMapperD.mappearDePeticionADocente(objDocente);
        return new ResponseEntity<List<RespuestaDTORespuesta>>(
                objMapperR.mappearDeRespuestaCARespuesta(this.objGestionarRespuestaCuestionarioCUInt.listar(objDocenteCrear)),
                HttpStatus.OK
        );
    }
}
