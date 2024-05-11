package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios;

import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DepartamentoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository<DepartamentoEntity, Integer> {
}
