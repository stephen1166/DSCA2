package Controller;

import Classes.Drink;
import Classes.Ingredient;
import Util.Hashmap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

import static Main.MainMenu.stage;
import static Main.MainMenu.mainScene;


public class IngredientsView implements Initializable {

    @FXML
    private TableView<Ingredient> IngredientsList;
    @FXML
    private TextField Name;
    @FXML
    private TextField Texture;
    @FXML
    private TextField ABVfield;
    @FXML
    private TextField imageField;

    @FXML
    private TableColumn<Ingredient, String> nameCol, textureCol, ABVCol;

    private Hashmap<Ingredient> ingredients = new Hashmap<>(100);

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Linking Columns to objects in Drink.java
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        textureCol.setCellValueFactory(new PropertyValueFactory<>("texture"));
        ABVCol.setCellValueFactory(new PropertyValueFactory<>("ABV"));
        for (int i = 0; i <= 100; i++) { // TODO change to fit any hashmap size
            if (ingredients.get(i) != Null) {
                IngredientsList.setItems(ingredients.get(i));
            }
        }
    }


    @FXML
    public void addIngredient(String name, String texture, String ABV) {
        Ingredient newIngrediant = new Ingredient(name, texture, ABV);
        ingredients.insert(newIngrediant);

        System.out.println(ingredients);
    }

    @FXML
    public void onAddIngredient(ActionEvent actionEvent) {
        String name = Name.getText();
        String texture = Texture.getText();
        String ABV = ABVfield.getText();

        addIngredient(name, texture, ABV);

        IngredientsList.refresh();
    }

    @FXML
    protected void Back() {
        stage.setScene(mainScene);
    }
}