package com.example.streamingplatopgave;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class StreamControl3 {

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

    private ObservableList<Movie> list;

    public UseCase useCase = new UseCase();

    public String getEmail(){
        return email;
    }


    public void initialize() {
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

        System.out.println("Fetching movies for: " + email);
        List<Movie> movies = useCase.getFavoriteMoviesByEmail(email);
        list = FXCollections.observableArrayList(movies);

        table1.setItems(null);
        table1.setItems(list);
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
    @FXML
    public void removeFromFavoriteMoviesClicked(ActionEvent event) {
        String removed = useCase.removeFavoriteMovie(table1.getSelectionModel().getSelectedItem().getMovieId());
        List<Movie> movies = useCase.getFavoriteMoviesByEmail(email);
        list = FXCollections.observableArrayList(movies);

        table1.setItems(null);
        table1.setItems(list);
    }
}
