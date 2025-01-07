package Controller;

import Classes.Drink;
import Classes.Ingredient;
import Util.Hashmap;
import Util.iSerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import java.io.*;

import static Main.MainMenu.stage;

public class MenuView implements iSerializer {

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

    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] { Hashmap.class, Drink.class, Ingredient.class };

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in1 = xstream.createObjectInputStream(new FileReader("Hashmaps.xml"));
        IngredientsView.ingredients = (Hashmap<Ingredient>) in1.readObject();
        DrinksView.drinks = (Hashmap<Drink>) in1.readObject();
        in1.close();
    }

    /**
     * The save method uses the XStream component to write all the objects in the posts ArrayList
     * to the posts.xml file stored on the hard disk.
     *
     * @throws Exception  An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Hashmaps.xml"));
        out.writeObject(IngredientsView.ingredients);
        out.writeObject(DrinksView.drinks);
        out.close();
    }
}