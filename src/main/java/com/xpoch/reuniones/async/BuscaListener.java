package com.xpoch.reuniones.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpoch.reuniones.models.Persona;
import com.xpoch.reuniones.models.Reunion;
import com.xpoch.reuniones.services.PersonaService;
import com.xpoch.reuniones.services.ReunionService;
import com.xpoch.reuniones.task.AgendaRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscaListener {
    private static final Logger LOG = LoggerFactory.getLogger(BuscaListener.class);

    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }

    public void recibirMensaje(String mensaje) {
        try {
            InfoBusca infoBusca = mapper.readValue(mensaje, InfoBusca.class);
            Optional<Persona> persona = personaService.getById(infoBusca.getIdAsistente());

            if( persona.isEmpty() ){
                LOG.error("No se ha encontrado la persona con id {}", infoBusca.getIdAsistente());
                return;
            }

            Optional<Reunion> reunion = reunionService.getById(infoBusca.getIdReunion());

            if (reunion.isEmpty()) {
                LOG.error("No se ha encontrado la reunion con id {}", infoBusca.getIdReunion());
                return;
            }

            if (persona.isPresent() && reunion.isPresent())
            {
                LOG.info("{} {} tiene reunion a las {}", persona.get().getNombre(), persona.get().getApellido(), reunion.get().getFecha());
            }

        } catch (JsonProcessingException e) {
            LOG.error("Error al recibir mensaje", e);
        }
    }

}
