package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelefonoMapper {
    @Bean
    public ModelMapper CrearTelefonoMapper() {return new ModelMapper();}
}
