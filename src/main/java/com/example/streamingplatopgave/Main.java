package com.example.streamingplatopgave;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //man kan vidst også gøre det med noget der hedder Parent, import javafx.scene.Parent;
        //Parent root = FXMLLoader.load(Main.class.getResource("StreamingScene1.fxml")); ved ikke hvad forskellen er
        FXMLLoader sceneFirst = new FXMLLoader(Main.class.getResource("StreamingScene1.fxml"));
        Scene scene1 = new Scene(sceneFirst.load(), 600, 400);

        FXMLLoader sceneSecond = new FXMLLoader(Main.class.getResource("StreamingScene2.fxml"));
        Scene scene2 = new Scene(sceneSecond.load(), 600, 400);

        FXMLLoader sceneThird = new FXMLLoader(Main.class.getResource("StreamingScene3.fxml"));
        Scene scene3 = new Scene(sceneThird.load(), 600, 400);

        FXMLLoader sceneFourth = new FXMLLoader(Main.class.getResource("StreamingScene4.fxml"));
        Scene scene4 = new Scene(sceneFourth.load(), 600, 400);

        StreamControl1 streamControl1 = sceneFirst.getController();
        StreamControl2 streamControl2 = sceneSecond.getController();
        StreamControl3 streamControl3 = sceneThird.getController();
        StreamControl4 streamControl4 = sceneFourth.getController();

        streamControl1.setStage(stage);
        streamControl1.setScene2(scene2);
        streamControl1.setScene3(scene3);

        streamControl2.setStage(stage);
        streamControl2.setScene1(scene1);
        streamControl2.setScene3(scene3);
        streamControl2.setScene4(scene4);

        scene2.setUserData(streamControl2);

        streamControl3.setStage(stage);
        streamControl3.setScene2(scene2);
        streamControl3.setScene4(scene4);

        scene3.setUserData(streamControl3);

        streamControl4.setStage(stage);
        streamControl4.setScene2(scene2);

        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}