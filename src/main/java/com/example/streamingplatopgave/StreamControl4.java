package com.example.streamingplatopgave;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class StreamControl4 {
//    StreamControl1 streamControl1 = new StreamControl1();

    private Stage stage;
    private Scene scene2;
    private String email;

    UseCase useCase = new UseCase();

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @FXML
    private TableView<Movie> table2;

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


//    public void setStreamControl3(StreamControl3 streamControl3) {
//        this.streamControl3 = streamControl3;
//    }

    private ObservableList<Movie> list;

    public void setUserEmail(String email) {
        this.email = email;
        System.out.println("Email received in Scene3: " + email);

        Platform.runLater(this::loadFromDatabase);
    }

    @FXML
    private void loadFromDatabase() {
        System.out.println("Fetching movies for: " + email);
        List <Movie> movies = useCase.getMoviesSortedByRating();
        list = FXCollections.observableArrayList(movies);

        movieId.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));

        table2.setItems(null);
        table2.setItems(list);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setScene2(Scene scene2) {
        this.scene2 = scene2;
    }
    @FXML
    private void switchToScene2() {
        stage.setScene(scene2);
    }
    @FXML
    public void addToListClicked(ActionEvent event) {
        int movieId = table2.getSelectionModel().getSelectedItem().getMovieId();
        System.out.println(movieId);
//        System.out.println(email);
        String added = useCase.addFavoriteMovie(movieId);
        System.out.println(added);
    }
}
