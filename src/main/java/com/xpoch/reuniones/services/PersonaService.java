package com.xpoch.reuniones.services;

import com.xpoch.reuniones.data.PersonaRepository;
import com.xpoch.reuniones.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasService {

    private final PersonaRepository personaRepository;

    public PersonasService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
}
