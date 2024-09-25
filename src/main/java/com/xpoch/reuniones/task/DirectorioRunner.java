package com.xpoch.reuniones;

import com.xpoch.reuniones.services.PersonaService;
import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DirectorioRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DirectorioRunner.class);

    @Autowired
    private PersonaService personaService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde el runner");
        personaService.getAllPersonas().forEach(persona -> {
            LOG.info("Persona: {}", persona);
        });
        System.out.println("Fin del directorio");
    }
}
