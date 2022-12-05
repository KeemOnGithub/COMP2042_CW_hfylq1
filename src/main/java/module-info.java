module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.game to javafx.fxml;
    exports com.example.game;
}