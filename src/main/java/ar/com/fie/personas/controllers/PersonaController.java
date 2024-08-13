package ar.com.fie.personas.controllers;

import ar.com.fie.personas.entitys.PersonaEntity;
import ar.com.fie.personas.services.PersonaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    // Inyectamos el servicio
    private final PersonaService personaService;

    // Constructor para inyectar el servicio
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/listar")
    public List<PersonaEntity> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PostMapping("/crear")
    public PersonaEntity crearPersona(@RequestBody PersonaEntity persona) {
        return personaService.crearPersona(persona);
    }

    @PutMapping("/actualizar/{id}")
    public PersonaEntity actualizarPersona(@PathVariable Long id, @RequestBody PersonaEntity personaActualizada) {
        return personaService.actualizarPersona(id, personaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }
}
