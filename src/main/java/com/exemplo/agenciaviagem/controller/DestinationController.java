package com.exemplo.agenciaviagem.controller;

import com.exemplo.agenciaviagem.dto.DestinationCreateDTO;
import com.exemplo.agenciaviagem.dto.DestinationResponseDTO;
import com.exemplo.agenciaviagem.service.DestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@Tag(name = "Destinations", description = "Gerenciamento de Destinos")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @Operation(summary = "Adiciona um novo destino", description = "Somente administradores podem adicionar destinos.")
    @PostMapping
    public ResponseEntity<DestinationResponseDTO> addDestination(@RequestBody DestinationCreateDTO dto) {
        DestinationResponseDTO response = destinationService.addDestination(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Lista todos os destinos", description = "Usuários autenticados podem listar os destinos.")
    @GetMapping
    public ResponseEntity<List<DestinationResponseDTO>> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }
}
