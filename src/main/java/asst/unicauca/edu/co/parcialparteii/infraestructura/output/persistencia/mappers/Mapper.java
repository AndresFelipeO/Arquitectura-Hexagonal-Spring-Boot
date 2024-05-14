package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper crearMapper(){
        return new ModelMapper();
    }
}
