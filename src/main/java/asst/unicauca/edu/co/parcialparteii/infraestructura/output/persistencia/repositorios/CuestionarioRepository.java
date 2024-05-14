package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios;

import asst.unicauca.edu.co.parcialparteii.dominio.modelos.Cuestionario;
import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CuestionarioRepository extends CrudRepository<CuestionarioEntity, Integer> {

    @Query("SELECT count(*) FROM CuestionarioEntity c  WHERE c.idCuestionario=?1")
    Integer existeCuestionarioPorCodigo(int codigo);

    @Query("select count(*) FROM CuestionarioEntity c WHERE c.titulo=?1")
    Integer existeCuestionarioPorTitulo(String titulo);

    //List<CuestionarioEntity> findAllByOrderByIdDesc();
}
