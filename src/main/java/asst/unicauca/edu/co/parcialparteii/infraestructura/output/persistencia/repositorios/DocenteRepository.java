package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.repositorios;

import asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DocenteRepository extends CrudRepository<DocenteEntity, Integer> {
    @Query("SELECT count(*) FROM DocenteEntity d  WHERE d.idPersona=?1")
    Integer existeDocentePorCodigo(int codigo);

    @Query("SELECT count(*) FROM DocenteEntity d  WHERE d.numeroIdentificacion=?1")
    Integer existeDocentePorIdentificacion(String identificacion);

    @Query("SELECT count(*) FROM DocenteEntity d  WHERE d.correo=?1")
    Integer existeDocentePorCorreo(String correo);

}
