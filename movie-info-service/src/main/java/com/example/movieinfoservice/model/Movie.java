package com.example.movieinfoservice.model;

public class Movie {
    private Long movieId;
    private String name;

    public Long getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Movie(Long movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }
    
}
