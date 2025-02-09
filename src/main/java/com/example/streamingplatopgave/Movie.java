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


//    public List <Movie> getAllMovies(){
//
//    }


//import javafx.beans.property.*;
//
//import java.util.List;
//
//    public class Movie {
//        private final IntegerProperty movieId;
//        private final StringProperty title;
//        private final StringProperty genre;
//        private final DoubleProperty duration;
//        private final IntegerProperty releaseYear;
//        private final IntegerProperty rating;
//
//        public Movie(int movieId, String title, String genre, double duration, int releaseYear, int rating) {
//            this.movieId = new SimpleIntegerProperty(movieId);
//            this.title = new SimpleStringProperty(title);
//            this.genre = new SimpleStringProperty(genre);
//            this.duration = new SimpleDoubleProperty(duration);
//            this.releaseYear = new SimpleIntegerProperty(releaseYear);
//            this.rating = new SimpleIntegerProperty(rating);
//        }
//
//        public int getMovieId() {
//            return movieId.get();
//        }
//
//        public String getTitle() {
//            return title.get();
//        }
//
//        public String getGenre() {
//            return genre.get();
//        }
//
//        public double getDuration() {
//            return duration.get();
//        }
//
//        public int getReleaseYear() {
//            return releaseYear.get();
//        }
//
//        public int getRating() {
//            return rating.get();
//        }
//        public void setMovieId(int value) {
//            movieId.set(value);
//        }
//        public void setTitle(String value) {
//            title.set(value);
//        }
//        public void setGenre(String value) {
//            genre.set(value);
//        }
//        public void setDuration(Double value) {
//            duration.set(value);
//        }
//        public void setReleaseYear(int value) {
//            releaseYear.set(value);
//        }
//        public void setRating(int value) {
//            rating.set(value);
//        }
//        public List<Movie> getAllMovies() {
//            return getAllMovies();
//        }
//
//        //Property stufff
//        public IntegerProperty movieIdProperty() {
//            return movieId;
//        }
//        public StringProperty titleProperty() {
//            return title;
//        }
//        public StringProperty genreProperty() {
//            return genre;
//        }
//        public DoubleProperty durationProperty(){
//            return duration;
//        }
//        public IntegerProperty releaseYearProperty() {
//            return releaseYear;
//        }
//        public IntegerProperty ratingProperty() {
//            return rating;
//        }
//
//    }
//


}