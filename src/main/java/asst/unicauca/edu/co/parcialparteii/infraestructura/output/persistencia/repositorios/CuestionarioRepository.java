package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios;

import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface CuestionarioRepository extends CrudRepository<CuestionarioEntity, Integer> {
}
