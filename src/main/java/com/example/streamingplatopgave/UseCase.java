package com.example.streamingplatopgave;

import java.util.List;

public class UseCase {

    String email;
    User user;
    private static final DatabaseHandler db = new DatabaseHandler();

    public String createUser(String firstName, String lastName, String email, String subscriptionType){
        User user = new User(0, firstName, lastName, email, subscriptionType);
        return db.createUserObject(user);
    }

    public String updateUser(int userId, String firstName, String lastName, String email, String subscriptionType) {
        User user = new User(userId, firstName, lastName, email, subscriptionType);
        return db.updateUserObject(user);
    }

    public String deleteUser(String email) {
        if (email == null || email.isEmpty()) {
            return "Skal inkludere email";
        }
        return db.deleteUserObject(email);
    }

    public List<User> getAllUsers() {

        return db.getAllUsers();
    }

    public User getUserObject(String email) {
        user = db.getUserObject(email);
        return user;
    }

    public List<Movie> getMoviesSortedByRating(){
        return db.showMoviesByRating();
    }

    public List<Movie> getFavoriteMoviesByEmail(String email){
        return db.getFavoriteMovies(email);
    }

    public String addFavoriteMovie(String email, int movieID) {
        user = getUserObject(email);
        System.out.println(user.getUserId());
        int userId = user.getUserId();
        return db.addFavoriteMovie(userId, movieID);
    }
    public String removeFavoriteMovie(int movieId){
        String removed = db.removeFromFavoriteMovie(movieId);
        return removed;
    }

}
