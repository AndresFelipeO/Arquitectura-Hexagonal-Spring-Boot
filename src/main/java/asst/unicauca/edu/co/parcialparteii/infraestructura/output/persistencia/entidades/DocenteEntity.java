package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Docentes")
public class DocenteEntity extends PersonaEntity {
    @Column(length = 30,unique = true)
    private String correo;
    @Column(length = 30)
    private String vinculacion;

    @OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "objPersona")
    private TelefonoEntity objTelefonoEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DepartamentoDocentes",
                joinColumns = @JoinColumn(name = "idPersona"),
                inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
    private List<DepartamentoEntity> departamentoEntities;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "objUsuario")
    private List<RespuestaEntity> respuestaEntities;

}
