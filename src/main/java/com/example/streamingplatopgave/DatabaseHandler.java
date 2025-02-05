package com.example.streamingplatopgave;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    public DatabaseHandler() {}
    public String createUserObject(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, subscription_type) VALUES (?,?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSubscriptionType());
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted > 0) {
                return "User created successfully";
            }
            else {
                return "User creation failed";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "User creation failed";
    }
    public User getUserObject(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int userId = resultSet.getInt("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
//                String email = resultSet.getString("email");
                String subscriptionType = resultSet.getString("subscription_type");
                User user = new User(userId, firstName, lastName, email, subscriptionType);
                return user;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public String updateUserObject(User user) {
        String sql = "UPDATE user SET first_name = ?, SET last_name = ?, email = ?, subscription_type = ? WHERE user_id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSubscriptionType());
            preparedStatement.setInt(5, user.getUserId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated > 0) {
                return "User updated successfully";
            }
            else {
                return "User update failed";
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return "User update failed";
    }
    public String deleteUserObject(String email) {
        String sql = "DELETE FROM users WHERE email = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            int rowsDeleted= preparedStatement.executeUpdate();
            if(rowsDeleted > 0) {
                return "User deleted successfully";
            }
            else {
                return "User delete failed";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "User delete failed";
    }

    public List<Movie> getFavoriteMovies(String email) {
        String sql = "SELECT movies.movie_id, movies.title, movies.genre, movies.duration, movies.release_year, movies.rating FROM movies\n" +
                "JOIN favorites \n" +
                "ON movies.movie_id = favorites.movie_id\n" +
                "JOIN users\n" +
                "ON favorites.user_id = users.user_id\n" +
                "WHERE users.email = \"snabelA\"\n" +
                ";";
        List<Movie> favoriteMovies = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("movie_id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                Double duration = resultSet.getDouble("duration");
                int releaseYear = resultSet.getInt("release_year");
                int rating = resultSet.getInt("rating");
                Movie movie = new Movie(id, title, genre, duration, releaseYear, rating);
                favoriteMovies.add(movie);
            }
            return favoriteMovies;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public String addFavoriteMovie(User user, Movie movie) {
        String sql = "INSERT INTO favorites (user_id, movie_id) VALUES (?, ?)";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, movie.getMovieId());
            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted > 0) {
                return "Favorite movie added successfully";
            }
            else {
                return "Favorite movie failed";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Favorite movie not added";
    }
    //Vise film sorteret efter rating
    //Tilføje favorit
}
