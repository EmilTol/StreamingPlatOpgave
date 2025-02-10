package com.example.streamingplatopgave;

import javafx.beans.property.*;

import java.util.List;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private double duration;
    private int releaseYear;
    private int rating;

    public Movie(int movieId, String title, String genre, double duration, int releaseYear, int rating) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public int getMovieId(){
        return movieId;
    }
    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return  genre;
    }
    public double getDuration(){
        return duration;
    }
    public int getReleaseYear(){
        return releaseYear;
    }
    public int getRating(){
        return rating;
    }
    @Override
    public String toString() {
        return("Movie: " + title + ". Rated " + rating + ". Realeased in " + releaseYear + ". Duration: " + String.format("%.0f", duration) + " minutes. Genre: " + genre);
    }

}
