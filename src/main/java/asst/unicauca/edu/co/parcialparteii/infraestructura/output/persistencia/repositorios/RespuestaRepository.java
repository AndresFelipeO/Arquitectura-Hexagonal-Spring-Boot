package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios;

import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.RespuestaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RespuestaRepository extends CrudRepository<RespuestaEntity, Integer> {
    @Query("SELECT count(*) FROM RespuestaEntity r  WHERE r.idRespuesta=?1")
    Integer existeRespuestaPorCodigo(int codigo);
}
