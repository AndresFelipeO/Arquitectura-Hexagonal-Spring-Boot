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
@Table(name = "TipoPregunta")
public class TipoPreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipPregunta")
    private  int idtipPregunta;
    @Column(name = "nombre",length = 30)
    private String nombre;
    @Column(name = "descripcion",length = 30)
    private String  descripcion;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "objTipoPreguntaEntity")
    private List<PreguntaEntity> preguntaEntity;
}
