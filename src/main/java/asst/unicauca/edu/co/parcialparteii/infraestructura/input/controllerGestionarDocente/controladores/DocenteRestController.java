package asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.controladores;


import asst.unicauca.edu.co.parcialparteii.aplicacion.input.GestionarDocenteCUIntPort;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Docente;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTOPeticiones.DocenteDTOPeticion;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class DocenteRestController {
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapper;

    @PostMapping("/docente")
    public ResponseEntity<DocenteDTORespuesta> crear(@Valid @RequestBody DocenteDTOPeticion objDocente) {
        Docente objDocenteCrear=objMapper.mappearDePeticionADocente(objDocente);
        Docente objDocenteCreado=objGestionarDocenteCUInt.crear(objDocenteCrear);
        return new ResponseEntity<DocenteDTORespuesta>(
                objMapper.mappearDeDocenteARespuesta(objDocenteCreado), HttpStatus.CREATED
        );
    }

}
