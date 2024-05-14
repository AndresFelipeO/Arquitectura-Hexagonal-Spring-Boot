package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cuestionarios")
public class CuestionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuestionario")
    private int idCuestionario;

    @Column(name = "titulo",length = 30)
    private String titulo;

    @Column(name = "descripcion",length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER, mappedBy = "objCuestionarioEntity")
    private List<PreguntaEntity> preguntaEntities;
}
