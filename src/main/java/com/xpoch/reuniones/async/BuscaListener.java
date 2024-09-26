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
            Persona persona = personaService.getById(infoBusca.getIdAsistente());
            Reunion reunion = reunionService.getById(infoBusca.getIdReunion());
            LOG.info("{} {} tiene reunion a las {}", persona.getNombre(), persona.getApellido(), reunion.getFecha());
        } catch (JsonProcessingException e) {
            LOG.error("Error al recibir mensaje", e);
        }
    }

}
