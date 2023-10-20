//src/main/java/ar/com/fie/personas/controllers/PersonaController.java
package ar.com.fie.personas.controllers;

import ar.com.fie.personas.entitys.PersonaEntity;
import ar.com.fie.personas.repositories.PersonaRepository;

import ar.com.fie.personas.services.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    private final PersonaService personaService;

    // Constructor para inyectar el repositorio

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/listar")
    public List<PersonaEntity> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPersona(@RequestBody PersonaEntity persona) {
        PersonaEntity Persona =  personaService.crearPersona(persona);
        return ResponseEntity.ok("Creación exitosa. ID de la nueva persona: " + Persona.getId());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarPersona(@PathVariable Long id, @RequestBody PersonaEntity personaActualizada) {

        if (!personaService.buscarPersonaPorId(id).isPresent()) {
            return ResponseEntity.badRequest().body("No se encontro la persona con el id: " + id);
        }

        return ResponseEntity.ok("Actualización exitosa. ID de la persona actualizada: "
                + personaService.actualizarPersona(id, personaActualizada).getId());

    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }


}
