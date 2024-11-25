package com.exemplo.agenciaviagem.model;

public class Destination {
    private Long id;
    private String name;
    private String location;
    private String description;
    private double rating;
    private int ratingCount;

    public Destination() {}

    
    public Destination(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    
    public void addRating(int newRating) {
        this.rating = ((this.rating * this.ratingCount) + newRating) / (this.ratingCount + 1);
        this.ratingCount++;
    }
}
