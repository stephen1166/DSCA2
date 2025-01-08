package Classes;

import jdk.jshell.execution.Util;
import Util.*;
import java.net.URL;

public class Drink {

    private String name; // 25 char max
    private String type; // 15 char alphabet only
    private String origin; // 30 char alphabet only
    private String description; // 500 char
    private URL image;
    private double abv;
    private Hashmap<Ingredient> ingredients;

    //Constructor
    public Drink(String name, String type, String origin, String description, URL image) {
        this.name = Utilities.truncateString(name, 25);
        this.type = Utilities.truncateString(type, 15);
        this.origin = Utilities.truncateString(origin, 30);
        this.description = Utilities.truncateString(description, 500);
        this.image = image;
        abv=0;
        ingredients=new Hashmap<>(10);
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDescription() {
        return description;
    }

    public double getAbv() {
        return abv;
    }

    public URL getImage() {
        return image;
    }

    public Hashmap<Ingredient> getIngredients() {
        return ingredients;
    }



    //Setters
    public void setName(String name) {
        this.name = Utilities.truncateString(name, 25);
    }

    public void setType(String type) {
        this.type = Utilities.truncateString(type, 15);
    }

    public void setOrigin(String origin) {
        this.origin = Utilities.truncateString(origin, 30);
    }

    public void setDescription(String description) {
        this.description = Utilities.truncateString(description, 500);
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public void setIngredients(Hashmap<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    //toString TODO set up nicer to string
    @java.lang.Override
    public java.lang.String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
