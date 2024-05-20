package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.controladores;


import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarCuestionarioCUIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTOPeticiones.CuestionarioDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta.CuestionarioDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.mappers.CuestionarioMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CuestionarioRestController {
    private final GestionarCuestionarioCUIntPort objGestionarCuestionarioCUInt;
    private final CuestionarioMapperInfraestructuraDominio objMapper;

    @PostMapping("/cuestionario")
    public ResponseEntity<CuestionarioDTORespuesta> crear(@RequestBody CuestionarioDTOPeticion objCuestionario) {
        Cuestionario objCuestionarioCrear=objMapper.mappearDePeticionACuestionario(objCuestionario);
        
        Cuestionario objCuestionarioCreado=objGestionarCuestionarioCUInt.crear(objCuestionarioCrear);
        return new ResponseEntity<CuestionarioDTORespuesta>(
                objMapper.mappearDeCuestionarioARespuesta(objCuestionarioCreado), HttpStatus.CREATED
        );
    }
    @GetMapping("/cuestionario")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar(){
        return new ResponseEntity<List<CuestionarioDTORespuesta>>(
                objMapper.mappearDeCuestionarioARespuesta(this.objGestionarCuestionarioCUInt.listar()),
                HttpStatus.OK
        );
    }
}
