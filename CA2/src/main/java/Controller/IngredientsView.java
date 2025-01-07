package Controller;

import Classes.Ingredient;
import Util.Hashmap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import static Main.MainMenu.stage;
import static Main.MainMenu.mainScene;
import static java.lang.Double.parseDouble;


public class IngredientsView implements Initializable {

    @FXML
    private TextField nameField,textureField,abvField;

    @FXML
    private TextField SearchPrompt;

    @FXML
    private TableView<Ingredient> ingredientView;

    @FXML
    private TableColumn<Ingredient, String> nameCol, textureCol, abvCol;

    @FXML
    private ComboBox<String> searchOptions;

    public static Hashmap<Ingredient> ingredients=new Hashmap<>(100);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchOptions.getItems().addAll("Search by Name","Search by Texture","Search by Abv");
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
        double abv;
        try {
             abv = Double.parseDouble(abvField.getText());
        }catch (NumberFormatException e){
             abv = -1.0;
        }


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

    @FXML
    public void Search(){
        if(searchOptions.getSelectionModel().getSelectedItem().equals("Search by Name")){
            ingredientView.getItems().clear();
            for (int i = 0; i < 100; i++) {
                if(ingredients.get(i) != null) {
                    if (ingredients.get(i).getName().toLowerCase().contains(SearchPrompt.getText().toLowerCase())) {
                        ingredientView.getItems().add(ingredients.get(i));
                    }
                }
            }
        } else if (searchOptions.getSelectionModel().getSelectedItem().equals("Search by Texture")) {
            ingredientView.getItems().clear();
            for (int i = 0; i < 100; i++) {
                if(ingredients.get(i) != null) {
                    if (ingredients.get(i).getTexture().toLowerCase().contains(SearchPrompt.getText().toLowerCase())) {
                        ingredientView.getItems().add(ingredients.get(i));
                    }
                }
            }
        } else if (searchOptions.getSelectionModel().getSelectedItem().equals("Search by Abv")) {
                ingredientView.getItems().clear();
                for (int i = 0; i < 100; i++) {
                    if(ingredients.get(i) != null) {
                        if (ingredients.get(i).getAbv() == parseDouble(SearchPrompt.getText())) {
                            ingredientView.getItems().add(ingredients.get(i));
                        }
                    }
                }
        }
        else{
            System.out.println("Invalid Option selected");
        }
    }
}