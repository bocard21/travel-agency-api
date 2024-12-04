package com.exemplo.agenciaviagem.service;

import com.exemplo.agenciaviagem.dto.DestinationCreateDTO;
import com.exemplo.agenciaviagem.dto.DestinationResponseDTO;
import com.exemplo.agenciaviagem.model.Destination;
import com.exemplo.agenciaviagem.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public DestinationResponseDTO addDestination(DestinationCreateDTO dto) {
        Destination destination = new Destination();
        destination.setName(dto.getName());
        destination.setLocation(dto.getLocation());
        destination.setDescription(dto.getDescription());
        destination = destinationRepository.save(destination);
        return mapToResponseDTO(destination);
    }

    public List<DestinationResponseDTO> getAllDestinations() {
        return destinationRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private DestinationResponseDTO mapToResponseDTO(Destination destination) {
        DestinationResponseDTO dto = new DestinationResponseDTO();
        dto.setId(destination.getId());
        dto.setName(destination.getName());
        dto.setLocation(destination.getLocation());
        return dto;
    }
}
