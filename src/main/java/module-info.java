module com.example.trabalhocrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.trabalhocrud to javafx.fxml;
    exports com.example.trabalhocrud;
}