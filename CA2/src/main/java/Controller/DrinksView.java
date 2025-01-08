package Controller;

import Classes.Drink;
import Util.Hashmap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.MainMenu.mainScene;
import static Main.MainMenu.stage;
import static java.lang.Double.parseDouble;

public class DrinksView implements Initializable {

    @FXML
    private TextField nameField,typeField,originField,descriptionField,imageField;

    @FXML
    private TableView<Drink> drinkView;

    @FXML
    private TextField SearchPrompt;

    @FXML
    private ComboBox<String> searchOptions;

    @FXML
    private TableColumn<Drink, String> nameCol,typeCol,originCol,descriptionCol;

    @FXML
    private TableColumn<Drink, Double> abvCol;

    @FXML
    private TableColumn<Drink, String> imageCol;
    @FXML
    public static Hashmap<Drink> drinks=new Hashmap<>(100);
    public static Drink viewingDrink;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Linking Columns to objects in Drink.java
        searchOptions.getItems().addAll("Search by Name","Search by Type","Search by Origin","Search by Description");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        originCol.setCellValueFactory(new PropertyValueFactory<>("origin"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        abvCol.setCellValueFactory(new PropertyValueFactory<>("abv"));

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

    public void Recipe(ActionEvent actionEvent) throws IOException {
        viewingDrink=null;
        if(drinkView.getSelectionModel().getSelectedItem()!=null) {
            viewingDrink = drinkView.getSelectionModel().getSelectedItem();
        }
        else{
            System.out.println("1");
            return;
        }
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("recipe-view.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Search(){
        if(searchOptions.getSelectionModel().getSelectedItem().equals("Search by Name")){
            drinkView.getItems().clear();
            for (int i = 0; i < 100; i++) {
                if(drinks.get(i) != null) {
                    if (drinks.get(i).getName().toLowerCase().contains(SearchPrompt.getText().toLowerCase())) {
                        drinkView.getItems().add(drinks.get(i));
                    }
                }
            }
        } else if (searchOptions.getSelectionModel().getSelectedItem().equals("Search by Type")) {
            drinkView.getItems().clear();
            for (int i = 0; i < 100; i++) {
                if(drinks.get(i) != null) {
                    if (drinks.get(i).getType().toLowerCase().contains(SearchPrompt.getText().toLowerCase())) {
                        drinkView.getItems().add(drinks.get(i));
                    }
                }
            }
        } else if (searchOptions.getSelectionModel().getSelectedItem().equals("Search by Origin")) {
            drinkView.getItems().clear();
            for (int i = 0; i < 100; i++) {
                if(drinks.get(i) != null) {
                    if (drinks.get(i).getOrigin().toLowerCase().contains(SearchPrompt.getText().toLowerCase())) {
                        drinkView.getItems().add(drinks.get(i));
                    }
                }
            }
        }
        else if (searchOptions.getSelectionModel().getSelectedItem().equals("Search by Description")) {
            drinkView.getItems().clear();
            for (int i = 0; i < 100; i++) {
                if(drinks.get(i) != null) {
                    if (drinks.get(i).getDescription().toLowerCase().contains(SearchPrompt.getText().toLowerCase())) {
                        drinkView.getItems().add(drinks.get(i));
                    }
                }
            }
        }
        else{
            System.out.println("Invalid Option selected");
        }
    }


}