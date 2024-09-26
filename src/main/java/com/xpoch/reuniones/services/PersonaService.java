package com.xpoch.reuniones.services;

import com.xpoch.reuniones.data.PersonaRepository;
import com.xpoch.reuniones.models.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Persona getById(long id) {
        return personaRepository.findById(id).orElse(null);
    }
}
