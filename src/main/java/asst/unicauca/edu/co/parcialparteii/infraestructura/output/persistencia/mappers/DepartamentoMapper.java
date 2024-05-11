package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.mappers;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartamentoMapper {
    @Bean
    public ModelMapper CrearDepartamentoMapper() {return  new ModelMapper();}
}
