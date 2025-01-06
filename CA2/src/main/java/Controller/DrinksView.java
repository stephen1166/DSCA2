package Controller;

import Classes.Drink;
import Util.Hashmap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static Main.MainMenu.mainScene;
import static Main.MainMenu.stage;

public class DrinksView implements Initializable {

    @FXML
    private TextField nameField,typeField,originField,descriptionField,imageField;

    @FXML
    private TableView<Drink> drinkView;
    @FXML
    private TableColumn<Drink, String> nameCol,typeCol,originCol,descriptionCol;

    @FXML
    private TableColumn<Drink, String> imageCol;
    @FXML
    public static Hashmap<Drink> drinks=new Hashmap<>(100);

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Linking Columns to objects in Drink.java
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        originCol.setCellValueFactory(new PropertyValueFactory<>("origin"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        for (int i=0;i<100;i++){
            if (drinks.get(i)!=null) {
                drinkView.getItems().add(drinks.get(i));
            }
        }
    }

    @FXML
    public void AddDrink(ActionEvent actionEvent) {
        String name = nameField.getText();
        String type = typeField.getText();
        String origin = originField.getText();
        String description = descriptionField.getText();

        // Default to null if the image URL is invalid
        URL image = null;
        try {
            image = new URL(imageField.getText());
        } catch (Exception e) {
            System.out.println("Invalid image URL");
        }

        Drink newDrink = new Drink(name, type, origin, description, image);
        drinks.insert(newDrink);
        drinkView.getItems().add(drinks.get(drinks.search(newDrink)));
    }

    @FXML
    public void RemoveDrink(ActionEvent actionEvent){
        Drink temp=drinkView.getSelectionModel().getSelectedItem();
        int index=drinkView.getSelectionModel().getSelectedIndex();
        drinkView.getItems().remove(index);
        drinks.remove(drinks.search(temp));
    }

    @FXML
    protected void Back(){
        stage.setScene(mainScene);
    }

    @FXML
    protected void refreshTable(){
        drinkView.refresh();
    }
}