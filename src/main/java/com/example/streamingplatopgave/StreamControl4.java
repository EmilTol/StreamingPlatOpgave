package com.example.streamingplatopgave;

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
import java.util.ResourceBundle;

public class StreamControl4 implements Initializable{
//    StreamControl3 streamControl3 = new StreamControl3();

    private Stage stage;
    private Scene scene2;

//    private StreamControl3 streamControl3;

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
    private DatabaseConnection dc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dc = new DatabaseConnection();
    }

    @FXML
    private void loadFromDatabase(ActionEvent event) {
        try {
            Connection conn = dc.getConnection();
            list = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT * FROM movies");
            while(rs.next()) {
                list.add(new Movie(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getDouble(4),rs.getInt(5),rs.getInt(6)));
            }
        }
        catch (SQLException e){
            System.err.println("Error"+e);
        }
        movieId.setCellValueFactory(new PropertyValueFactory<>("movieId"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));

        table2.setItems(null);
        table2.setItems(list);
    }


//    ObservableList<Movie> list1 = FXCollections.observableArrayList(
//            new Movie(10, "deadpool","comedy", 120, 2020, 10)
//    );
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
//        table2.setItems(list1);
//    }

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
//    @FXML
//    void addButton(ActionEvent event) {
//        // Hent det valgte element fra table2
//        Movie selectedItem = table2.getSelectionModel().getSelectedItem();
//
//        if (selectedItem != null && streamControl3 != null) {
//            // Tilføj til table1 i StreamControl3
//            streamControl3.getTable().getItems().add(selectedItem);
//        }
//    }
//    @FXML
//    void addButton(ActionEvent event) {
//        Object selectedItem = table2.getSelectionModel().getSelectedItem();
//
//        if (selectedItem != null) {
//            // Tilføj det valgte element til table1s data
//            streamControl3.getTable.getItems().add(selectedItem);
//        }
//    }
//    @FXML
//    void addButton(ActionEvent event) {
//       int selectedId = table2.getSelectionModel().getSelectedIndex();
//        Movie selectedId = table2.getSelectionModel().getSelectedItem();
//        streamControl3.getTable().getItems().add(selectedId);
//    }
}
