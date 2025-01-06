module com.example.ca {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;

    exports Classes;
    opens Classes to javafx.base;
    exports Main;
    opens Main to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
}