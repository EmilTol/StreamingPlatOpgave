package com.example.streamingplatopgave;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StreamControl1 {

    private Stage stage;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;

    UseCase useCase = new UseCase();

    @FXML
    private TextField emailField;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setScene2(Scene scene2) {
        this.scene2 = scene2;
    }
    public void setScene3(Scene scene3) {
        this.scene3 = scene3;
    }
    public void setScene4(Scene scene4) {
        this.scene4 = scene4;
    }


    @FXML
    private void switchToScene2() {
        String email = emailField.getText();
        User user = useCase.getUserObject(email);
        System.out.println(user);
        StreamControl2 scene2Controller = (StreamControl2) scene2.getUserData();
        StreamControl4 scene4Controller = (StreamControl4) scene4.getUserData();
        StreamControl3 scene3Controller = (StreamControl3) scene3.getUserData();// Hent eksisterende controller
        scene2Controller.setUserEmail(email);
        scene3Controller.setUserEmail(email);
        scene4Controller.setUserEmail(email);

        stage.setScene(scene4);
        stage.setScene(scene3);
        stage.setScene(scene2);
    }

}
