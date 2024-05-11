package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuesta")
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRespuesta")
    private int idRespuesta;

    @Column(name = "descripcion",length = 30)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private DocenteEntity objUsuario;

    @ManyToOne
    @JoinColumn(name = "idpregunta",nullable = false)
    private PreguntaEntity objPreguntaEntity;
}