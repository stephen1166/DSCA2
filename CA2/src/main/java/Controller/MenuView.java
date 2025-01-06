package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.MainMenu.stage;

public class MenuView {

    private FXMLLoader drinksLoader=new FXMLLoader(getClass().getResource("drinks-view.fxml"));
    private FXMLLoader ingredientsLoader=new FXMLLoader(getClass().getResource("ingredients-view.fxml"));
    private Scene drinksScene;
    private Scene ingredientsScene;



    public MenuView() throws IOException {
        drinksScene=new Scene(drinksLoader.load());
        ingredientsScene=new Scene(ingredientsLoader.load());
    }

    @FXML
    protected void Drinks() throws IOException {
        stage.setScene(drinksScene);
    }

    @FXML
    protected void Ingredients() throws IOException {
        stage.setScene(ingredientsScene);
    }
}