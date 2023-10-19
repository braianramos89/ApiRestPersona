//src/main/java/ar/com/fie/personas/services/PersonaService.java
package ar.com.fie.personas.services;

import ar.com.fie.personas.entitys.PersonaEntity;
import ar.com.fie.personas.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Método para listar todas las personas
    public List<PersonaEntity> listarPersonas() {
        return personaRepository.findAll();
    }

    // Método para crear una nueva persona
    public PersonaEntity crearPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    // Método para buscar una persona por ID
    public Optional<PersonaEntity> buscarPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    // Método para actualizar una persona existente
    public PersonaEntity actualizarPersona(Long id, PersonaEntity personaActualizada) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaActualizada.getNombre());
                    persona.setApellido(personaActualizada.getApellido());
                    persona.setEmail(personaActualizada.getEmail());
                    persona.setPassword(personaActualizada.getPassword());
                    return personaRepository.save(persona);
                })
                .orElse(null);
    }

    // Método para eliminar una persona por ID
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

}
