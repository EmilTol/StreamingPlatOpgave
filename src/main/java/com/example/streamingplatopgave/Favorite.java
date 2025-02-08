package com.example.streamingplatopgave;

public class Favorite {

    private int userId;
    private int movieId;

    // Constructor
    public Favorite(int userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    // Getter for userId
    public int getUserId() {
        return userId;
    }

    // Getter for movieId
    public int getMovieId() {
        return movieId;
    }
}
