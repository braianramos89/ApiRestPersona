//src/main/java/ar/com/fie/personas/repositories/PersonaRepository.java
package ar.com.fie.personas.repositories;

import ar.com.fie.personas.entitys.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
