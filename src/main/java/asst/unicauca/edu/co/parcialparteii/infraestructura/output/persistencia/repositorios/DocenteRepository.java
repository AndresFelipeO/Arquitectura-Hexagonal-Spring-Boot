package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios;

import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.repository.CrudRepository;

public interface DocenteRepository extends CrudRepository<DocenteEntity, Integer> {
}
