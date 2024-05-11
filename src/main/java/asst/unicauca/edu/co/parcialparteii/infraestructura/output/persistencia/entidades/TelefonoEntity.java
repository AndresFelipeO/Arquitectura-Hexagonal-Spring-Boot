package asst.unicauca.edu.co.parcialparteii.infraestructura.output.persistencia.entidades;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Telefono")
public class TelefonoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTelefono")
    private int idTelefono;
    @Column(name = "tipoTelefono",length = 30)
    private String tipoTelefono;
    @Column(name = "numero",length = 30)
    private String numero;

    @OneToOne(cascade = {CascadeType.PERSIST })
    @JoinColumn(name = "idPersona")
    private DocenteEntity objPersona;

}
