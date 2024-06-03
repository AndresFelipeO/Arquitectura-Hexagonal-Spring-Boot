package asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.controladores;

import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarRespuestaCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTOPeticiones.PeticionDTO;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.DocenteDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.DTORespuesta.PreguntaDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.ControllerGestionarRespuesta.mappers.RespuestaMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RespuestaRestController {

    private final GestionarRespuestaCuestionarioCUIntPort objGestionarRespuestaCuestionarioCUInt;
    private final RespuestaMapperInfraestructuraDominio objMapper;

    @PostMapping("/respuesta")
    public ResponseEntity<PreguntaDTORespuesta> crear(@RequestBody PeticionDTO peticionDTO) 
    {
        Pregunta objCRespuestaCrear=objMapper.mappearDePeticionARespuesta(peticionDTO.getPreguntaDTO());
        Cuestionario objCuestionarioCrear=objMapper.mappearDePeticionACuestionario(peticionDTO.getCuestionarioDTO());
        Docente objDocenteCrear=objMapper.mappearDePeticionADocente(peticionDTO.getDocenteDTO());
        Pregunta objPreguntaCreado=objGestionarRespuestaCuestionarioCUInt.crear(objDocenteCrear,objCuestionarioCrear,objCRespuestaCrear);
        
        return new ResponseEntity<PreguntaDTORespuesta>(
                objMapper.mappearDeRespuestaCARespuesta(objPreguntaCreado), HttpStatus.CREATED
        );
    }

    @GetMapping("/respuesta")
    public ResponseEntity<DocenteDTORespuesta> listar(@RequestParam int id){
        return new ResponseEntity<DocenteDTORespuesta>(
                objMapper.mappearDeRespuestaCARespuesta(this.objGestionarRespuestaCuestionarioCUInt.listar(id)),
                HttpStatus.OK
        );
    }
}
