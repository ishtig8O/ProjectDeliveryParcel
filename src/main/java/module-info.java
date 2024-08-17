module com.example.project2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.project2 to javafx.fxml;
    opens com.example.project2.Table to javafx.fxml;
    opens com.example.project2.Model to javafx.fxml;
    opens com.example.project2.Controller to javafx.fxml;
    exports com.example.project2;
    exports com.example.project2.Table;
    exports com.example.project2.Controller;
    exports com.example.project2.Model;
}