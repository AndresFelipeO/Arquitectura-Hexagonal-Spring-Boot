package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Personas")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idPersona")
    private int idPersona;
    @Column(name = "tipoIdentificacion",length = 30)
    private String tipoIdentificacion;
    @Column(name = "numeroIdentificacion",length = 30,unique = true)
    private String numeroIdentificacion;
    @Column(name = "nombres",length = 30)
    private String nombres;
    @Column(name = "apellidos",length = 30)
    private String apellidos;

}
