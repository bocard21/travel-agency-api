package com.exemplo.agenciaviagem.controller;

import com.exemplo.agenciaviagem.model.Destination;
import com.exemplo.agenciaviagem.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    
    @PostMapping
    public ResponseEntity<Destination> addDestination(@RequestBody Destination destination) {
        Destination savedDestination = destinationService.addDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDestination);
    }

    
    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    
    @GetMapping("/search")
    public ResponseEntity<Destination> searchDestination(@RequestParam String nameOrLocation) {
        Optional<Destination> destination = destinationService.findDestinationByNameOrLocation(nameOrLocation);
        return destination.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationDetails(@PathVariable Long id) {
        Optional<Destination> destination = destinationService.getDestinationDetails(id);
        return destination.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    
    @PatchMapping("/{id}/rate")
    public ResponseEntity<Destination> rateDestination(@PathVariable Long id, @RequestParam int rating) {
        Optional<Destination> updatedDestination = destinationService.rateDestination(id, rating);
        return updatedDestination.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        boolean deleted = destinationService.deleteDestination(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
