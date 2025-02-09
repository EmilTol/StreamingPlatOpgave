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


public class StreamControl2 implements Initializable {

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

    private DatabaseConnection dc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dc = new DatabaseConnection();
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
        String query = "SELECT first_name, subscription_type FROM users WHERE email =?";
        System.out.println("loading username for email: " + email);
        try (Connection conn = dc.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("first_name");
                String sub = rs.getString("subscription_type");
                System.out.println("user found: " + username);
                System.out.println("subscription found: " + sub);
//                System.out.println("Label: " + nameId);
                nameId.setText(username);
                nameIdd.setText(username);
                subscription.setText(sub);
//                Platform.runLater(() -> nameId.setText(username));
            } else {
                nameId.setText("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            nameId.setText("Error loading user");
        }

    }
    @FXML
    private void switchToScene1() {
        stage.setScene(scene1);
    }
    @FXML
    private void switchToScene3() {
        stage.setScene(scene3);
    }
    @FXML
    private void switchToScene4() {
        stage.setScene(scene4);
    }
}