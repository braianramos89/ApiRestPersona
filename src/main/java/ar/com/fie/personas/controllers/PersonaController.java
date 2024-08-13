//src/main/java/ar/com/fie/personas/controllers/PersonaController.java
package ar.com.fie.personas.controllers;

import ar.com.fie.personas.entitys.PersonaEntity;
import ar.com.fie.personas.repositories.PersonaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    // Inyectamos el repositorio
    private final PersonaRepository personaRepository;

    // Constructor para inyectar el repositorio
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping("/listar")
    public List<PersonaEntity> listarPersonas() {
        return personaRepository.findAll();
    }

    @PostMapping("/crear")
    public PersonaEntity crearPersona(@RequestBody PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/actualizar/{id}")
    public PersonaEntity actualizarPersona(@PathVariable Long id, @RequestBody PersonaEntity personaActualizada) {
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

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }


}
