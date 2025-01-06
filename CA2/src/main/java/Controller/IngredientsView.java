package Controller;

import Classes.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static Main.MainMenu.stage;
import static Main.MainMenu.mainScene;


public class IngredientsView implements Initializable {

    @FXML
    private TableView<Ingredient> IngredientsList;

    @FXML
    private TableColumn<Ingredient, String> nameCol, textureCol, ABVCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        textureCol.setCellValueFactory(new PropertyValueFactory<>("texture"));
        ABVCol.setCellValueFactory(new PropertyValueFactory<>("ABV"));
    }

    @FXML
    protected void Back() {
        stage.setScene(mainScene);
    }
}