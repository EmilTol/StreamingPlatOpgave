module com.example.streamingplatopgave {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.streamingplatopgave to javafx.fxml;
    exports com.example.streamingplatopgave;
}