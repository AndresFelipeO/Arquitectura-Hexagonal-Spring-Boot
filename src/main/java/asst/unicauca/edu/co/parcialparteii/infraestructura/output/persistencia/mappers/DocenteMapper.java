package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocenteMapper {
    @Bean
    public ModelMapper CrearDocenteMapper() {return new ModelMapper();}
}
