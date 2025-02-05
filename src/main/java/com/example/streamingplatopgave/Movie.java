package com.example.streamingplatopgave;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private double duration;
    private int releaseYear;
    private int rating;

    public Movie(int id, String title, String genre, double duration, int releaseYear, int rating) {
        this.movieId = id;
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


    public List <Movie> getAllMovies(){

    }






}