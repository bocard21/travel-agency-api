package com.exemplo.agenciaviagem.service;

import com.exemplo.agenciaviagem.model.Destination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {
    private final List<Destination> destinations = new ArrayList<>();

    
    public Destination addDestination(Destination destination) {
        destination.setId((long) (destinations.size() + 1));
        destinations.add(destination);
        return destination;
    }

    
    public List<Destination> getAllDestinations() {
        return destinations;
    }

    
    public Optional<Destination> findDestinationByNameOrLocation(String nameOrLocation) {
        return destinations.stream()
            .filter(d -> d.getName().equalsIgnoreCase(nameOrLocation) || d.getLocation().equalsIgnoreCase(nameOrLocation))
            .findFirst();
    }

   
    public Optional<Destination> getDestinationDetails(Long id) {
        return destinations.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    
    public Optional<Destination> rateDestination(Long id, int rating) {
        Optional<Destination> destinationOptional = getDestinationDetails(id);
        destinationOptional.ifPresent(destination -> destination.addRating(rating));
        return destinationOptional;
    }

    
    public boolean deleteDestination(Long id) {
        return destinations.removeIf(d -> d.getId().equals(id));
    }
}
