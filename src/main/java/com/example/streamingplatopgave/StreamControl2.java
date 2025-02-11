package com.example.streamingplatopgave;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class StreamControl2{

    private Stage stage;
    private Scene scene1;
    private Scene scene3;
    private Scene scene4;

    @FXML
    private Label nameId;

    @FXML
    private Label nameIdd;

    @FXML
    private Label subscription;

    private String email;

    public UseCase useCase = new UseCase();
    public String getEmail(){
        return email;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setScene1(Scene scene1) {
        this.scene1 = scene1;
    }
    public void setScene3(Scene scene3) {
        this.scene3 = scene3;
    }
    public void setScene4(Scene scene4) {
        this.scene4 = scene4;
    }
    public void setUserEmail(String email) {
        this.email = email;
        System.out.println("Email received in Scene2:" + email);
        loadUsername();
    }
    private void loadUsername() {
        useCase.getUserObject(email);
    }

    @FXML
    private void switchToScene1() {
        stage.setScene(scene1);
    }
    @FXML
    private void switchToScene3() {
        stage.setScene(scene3);
        stage.show();
    }
    @FXML
    private void switchToScene4() {
        stage.setScene(scene4);
    }
}