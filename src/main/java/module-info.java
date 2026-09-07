module com.example.de25_27antonov {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.de25_27antonov to javafx.fxml;
    exports com.example.de25_27antonov;
}