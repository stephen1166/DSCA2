package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {

    public static Stage stage;
    public static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("menu-view.fxml"));
        mainScene = new Scene(fxmlLoader.load());
        stage.setTitle("Drinks Info System");
        stage.setScene(mainScene);
        stage.show();
        this.stage=stage;
    }

    public static void main(String[] args) {
        launch();
    }
}