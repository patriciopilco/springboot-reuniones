package com.xpoch.reuniones.services;

import com.xpoch.reuniones.data.ReunionRepository;
import com.xpoch.reuniones.models.Reunion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReunionService {
    private final ReunionRepository reunionRepository;
    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }
    public List<Reunion> getAllReuniones() {
        return reunionRepository.findAll();
    }

    public Optional<Reunion> getById(long id) {
        return reunionRepository.findById(id);
    }
}
