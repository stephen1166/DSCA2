package Controller;

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
    private TextField nameField,textureField,abvField;

    @FXML
    private TableView<Ingredient> ingredientView;

    @FXML
    private TableColumn<Ingredient, String> nameCol, textureCol, abvCol;

    public static Hashmap<Ingredient> ingredients=new Hashmap<>(100);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        textureCol.setCellValueFactory(new PropertyValueFactory<>("texture"));
        abvCol.setCellValueFactory(new PropertyValueFactory<>("abv"));
        for (int i = 0; i < 100; i++) { // TODO change to fit any hashmap size
            if (ingredients.get(i) != null) {
                ingredientView.getItems().add(ingredients.get(i));
            }
        }
    }

    @FXML
    public void AddIngredient(ActionEvent actionEvent) {
        String name = nameField.getText();
        String texture = textureField.getText();
        String abv = abvField.getText();

        Ingredient newIngredient = new Ingredient(name,texture,abv);
        ingredients.insert(newIngredient);
        ingredientView.getItems().add(ingredients.get(ingredients.search(newIngredient)));
    }

    @FXML
    public void RemoveIngredient(ActionEvent actionEvent){
        Ingredient temp=ingredientView.getSelectionModel().getSelectedItem();
        int index=ingredientView.getSelectionModel().getSelectedIndex();
        ingredientView.getItems().remove(index);
        ingredients.remove(ingredients.search(temp));
    }

    @FXML
    protected void Back() {
        stage.setScene(mainScene);
    }

    public void refreshIngredient(){
        for (int i = 0; i < 100; i++) { // TODO change to fit any hashmap size
            if (ingredients.get(i) != null) {
                ingredientView.getItems().add(ingredients.get(i));
            }
        }
    }
}