package Controller;

import Classes.Drink;
import Classes.Ingredient;
import Util.Hashmap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Controller.IngredientsView.ingredients;
import static Main.MainMenu.*;
import static Controller.DrinksView.viewingDrink;

public class RecipeView implements Initializable {

    @FXML
    private TextField mlField;

    @FXML
    private ComboBox ingredientOptions;

    @FXML
    private TableView<Ingredient> ingredientView;

    @FXML
    private TableColumn<Ingredient,String> nameCol,textureCol,abvCol,mlCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=0;i<ingredients.getSize();i++){
            if(ingredients.get(i)!=null) {
                ingredientOptions.getItems().add(ingredients.get(i).getName());
            }
        }
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        textureCol.setCellValueFactory(new PropertyValueFactory<>("texture"));
        abvCol.setCellValueFactory(new PropertyValueFactory<>("abv"));
        mlCol.setCellValueFactory(new PropertyValueFactory<>("ml"));
        for (int i = 0; i < viewingDrink.getIngredients().getSize(); i++) { // TODO change to fit any hashmap size
            if (viewingDrink.getIngredients().get(i)!=null){
                ingredientView.getItems().add(viewingDrink.getIngredients().get(i));
            }
        }
    }

    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("drinks-view.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void Home(ActionEvent actionEvent) {
        stage.setScene(mainScene);
        stage.show();
    }

    public double getABV(Hashmap<Ingredient> hashmap){
        double temp=0;
        double ml=0;
        for (int i=0;i<viewingDrink.getIngredients().getSize();i++){
            if (viewingDrink.getIngredients().get(i)!=null){
                Ingredient tempIngred=viewingDrink.getIngredients().get(i);
                temp+=tempIngred.getAbv()*tempIngred.getMl();
                ml+=tempIngred.getMl();
            }
        }
        System.out.println(temp);
        System.out.println(ml);
        return Math.round((temp/ml)*100)/100;
    }


    public void Add(ActionEvent actionEvent){
        Ingredient temp = null;
        for(int i=0;i<ingredients.getSize();i++) {
            if(ingredients.get(i)!=null) {
                if (ingredients.get(i).getName() == ingredientOptions.getSelectionModel().getSelectedItem()) {
                    temp = new Ingredient(ingredients.get(i));
                    temp.setMl(Integer.parseInt(mlField.getText()));
                    viewingDrink.getIngredients().insert(temp);
                    ingredientView.getItems().add(temp);
                    viewingDrink.setAbv(getABV(viewingDrink.getIngredients()));
                    return;
                }
            }
        }
    }

    public void Remove(ActionEvent actionEvent) {
        Ingredient temp=ingredientView.getSelectionModel().getSelectedItem();
        int index=ingredientView.getSelectionModel().getSelectedIndex();
        ingredientView.getItems().remove(index);
        viewingDrink.getIngredients().remove(viewingDrink.getIngredients().search(temp));
        viewingDrink.setAbv(getABV(viewingDrink.getIngredients()));
    }
}
