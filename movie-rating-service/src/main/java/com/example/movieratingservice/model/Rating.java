package com.example.movieratingservice.model;

public class Rating {
    private String movieId;
    private int reating;

    public String getMovieId() {
        return movieId;
    }

    public int getReating() {
        return reating;
    }

    public void setReating(int reating) {
        this.reating = reating;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Rating(String movieId, int reating) {
        this.movieId = movieId;
        this.reating = reating;
    }
}
