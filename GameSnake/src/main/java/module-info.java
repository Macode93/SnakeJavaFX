module com.example.gamesnake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamesnake to javafx.fxml;
    exports com.example.gamesnake;
}