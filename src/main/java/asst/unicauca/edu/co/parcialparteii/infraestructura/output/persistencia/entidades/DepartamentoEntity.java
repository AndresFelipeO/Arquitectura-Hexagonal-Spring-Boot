package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Departamentos")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartamento")
    private int idDepartamento;
    @Column(name = "nombreDep",length = 30)
    private String nombre;
    @Column(name = "descripcion",length = 30)
    private String descripcion;

}
