//src/main/java/ar/com/fie/personas/entitys/PersonaEntity.java
package ar.com.fie.personas.entitys;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    public long id;
    public String nombre;
    public String apellido;
    public String email;
    public String password;



}
