package com.example.streamingplatopgave;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StreamControl3 implements Initializable{

    private Stage stage;
    private Scene scene2;
    private Scene scene4;
    private String email;

    @FXML
    private TableView<Movie> table1;

    @FXML
    private TableColumn <Movie, Integer> movieId;

    @FXML
    private TableColumn<Movie, String> title;

    @FXML
    private TableColumn<Movie, String> genre;

    @FXML
    private TableColumn<Movie, Double> duration;

    @FXML
    private TableColumn<Movie, Integer> releaseYear;

    @FXML
    private TableColumn<Movie, Integer> rating;


//    ObservableList<Movie> list2 = FXCollections.observableArrayList(
//            new Movie(10, "deadpooool","comedy", 120, 2020, 10)
//    );

//    @FXML
//    private void loadFromDatabase(ActionEvent event) {
//        DatabaseHandler databaseHandler = new DatabaseHandler();
//        databaseHandler.getFavoriteMovies(String);
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        movieId.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("movieId"));
//        title.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
//        genre.setCellValueFactory(new PropertyValueFactory<Movie, String>("genre"));
//        duration.setCellValueFactory(new PropertyValueFactory<Movie, Double>("duration"));
//        releaseYear.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("releaseYear"));
//        rating.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("rating"));
//
//        table1.setItems(list2);
//    }
//    public TableView<Movie> getTable() {
//        return table1;
//    }

    private ObservableList<Movie> list;
    private DatabaseConnection dc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dc = new DatabaseConnection();

        // Tjek om table1 er null
        System.out.println("table1: " + table1);

        movieId.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
    }

    public void setUserEmail(String email) {
        this.email = email;
        System.out.println("Email received in Scene3: " + email);

        Platform.runLater(this::loadFromDatabase);
    }

    @FXML
    private void loadFromDatabase() {
        String query = "SELECT movies.movie_id, movies.title, movies.genre, movies.duration, movies.release_year, movies.rating FROM movies " +
                "JOIN favorites ON movies.movie_id = favorites.movie_id " +
                "JOIN users ON favorites.user_id = users.user_id " +
                "WHERE users.email = ?;";

        System.out.println("Fetching movies for: " + email);
        list = FXCollections.observableArrayList();

        try (Connection conn = dc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("movie_id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                Double duration = rs.getDouble("duration");
                int releaseYear = rs.getInt("release_year");
                int rating = rs.getInt("rating");

                Movie movie = new Movie(id, title, genre, duration, releaseYear, rating);
                list.add(movie);
            }


            table1.setItems(null);
            table1.setItems(list);

        } catch (SQLException e) {
            System.err.println("Error loading movies: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setScene2(Scene scene2) {
        this.scene2 = scene2;
    }
    public void setScene4(Scene scene4) {
        this.scene4 = scene4;
    }
    @FXML
    private void switchToScene2() {
        stage.setScene(scene2);
    }
    @FXML
    private void switchToScene4() {
        stage.setScene(scene4);
    }
}
