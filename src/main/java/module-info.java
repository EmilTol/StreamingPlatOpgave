module com.example.streamingplatopgave {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.streamingplatopgave to javafx.fxml;
    exports com.example.streamingplatopgave;
}