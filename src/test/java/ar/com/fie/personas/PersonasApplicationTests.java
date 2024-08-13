package ar.com.fie.personas;

import ar.com.fie.personas.controllers.PersonaController;
import ar.com.fie.personas.entitys.PersonaEntity;
import ar.com.fie.personas.services.PersonaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonasApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaService personaService;

    @Test
    void testGetPersonas() throws Exception {
        // Crea una persona de prueba en la base de datos
        PersonaEntity persona = new PersonaEntity();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("juan.perez@example.com");
        persona.setPassword("password123");
        personaService.crearPersona(persona);

        // Ejecuta el GET request y verifica el estado 200
        mockMvc.perform(get("/api/listar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
//ramon