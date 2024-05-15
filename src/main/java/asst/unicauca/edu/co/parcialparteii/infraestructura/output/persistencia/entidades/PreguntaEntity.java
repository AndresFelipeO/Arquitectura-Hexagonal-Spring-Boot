package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Preguntas")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPregunta")
    private int idpregunta;

    @Column(name = "enunciado",length = 30)
    private String enunciado;

    @ManyToOne(cascade = {CascadeType.PERSIST })
    @JoinColumn(name = "idtipPregunta")
    private TipoPreguntaEntity objTipoPreguntaEntity;

    @ManyToOne
    @JoinColumn(name="idCuestionario", nullable=false)
    private CuestionarioEntity objCuestionarioEntity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "objPreguntaEntity")
    private List<RespuestaEntity> respuestaEntities;
}
