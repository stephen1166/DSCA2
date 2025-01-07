module com.example.ca {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;
    requires jdk.jshell;

    exports Classes;
    opens Classes to javafx.base,xstream;
    exports Main;
    opens Main to javafx.fxml,xstream;
    exports Controller;
    opens Controller to javafx.fxml,xstream;
    exports Util;
    opens Util to javafx.fxml, xstream;
}