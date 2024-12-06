package com.exemplo.agenciaviagem.repository;

import com.exemplo.agenciaviagem.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    boolean existsByNameAndLocation(String name, String location);
}
