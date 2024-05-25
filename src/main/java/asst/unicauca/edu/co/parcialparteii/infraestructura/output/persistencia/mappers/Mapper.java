package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.mappers;

import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta.PreguntaDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Pregunta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.input.controllerGestionarCuestioario.DTORespuesta.CuestionarioDTORespuesta;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.PreguntaEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper crearMapper(){
        ModelMapper objMapper = new ModelMapper();
        
        //mappers de cuestionario
        TypeMap<CuestionarioEntity, Cuestionario> typeMapCuestToEntyCuest= objMapper.createTypeMap(CuestionarioEntity.class, Cuestionario.class);
        typeMapCuestToEntyCuest.addMappings(mapper -> mapper.skip(Cuestionario::setPreguntaEntities)).implicitMappings();

        TypeMap<Cuestionario, CuestionarioDTORespuesta> typeMapCuestToCuestDTO = objMapper.createTypeMap(Cuestionario.class, CuestionarioDTORespuesta.class);
        typeMapCuestToCuestDTO.addMappings(mapper -> mapper.skip(CuestionarioDTORespuesta::setPreguntaEntities)).implicitMappings();

        //mappers de Pregunta
        TypeMap<PreguntaEntity, Pregunta>typeMapPreEntToPre=objMapper.createTypeMap(PreguntaEntity.class,Pregunta.class);
        typeMapPreEntToPre.addMappings(mapper->mapper.skip(Pregunta::setObjTipoPreguntaEntity)).implicitMappings();

        TypeMap<Pregunta, PreguntaDTORespuesta> typeMapPreToPreDTO= objMapper.createTypeMap(Pregunta.class,PreguntaDTORespuesta.class);
        typeMapPreToPreDTO.addMappings(mapper->mapper.skip(PreguntaDTORespuesta::setObjTipoPreguntaEntity)).implicitMappings();


        return new ModelMapper();
    }
}
