package com.exemplo.agenciaviagem.dto;

import jakarta.validation.constraints.NotBlank;

public class DestinationCreateDTO {
	@NotBlank
    private String name;
	@NotBlank
    private String location;
    private String description;
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
