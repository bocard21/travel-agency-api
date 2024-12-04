package com.exemplo.agenciaviagem.controller;

import com.exemplo.agenciaviagem.dto.DestinationCreateDTO;
import com.exemplo.agenciaviagem.dto.DestinationResponseDTO;
import com.exemplo.agenciaviagem.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    public ResponseEntity<DestinationResponseDTO> addDestination(@RequestBody DestinationCreateDTO dto) {
        DestinationResponseDTO response = destinationService.addDestination(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DestinationResponseDTO>> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
