package Classes;

import java.net.URL;

public class Drink {

    private String name;
    private String type;
    private String origin;
    private String description;
    private URL image;

    //Constructor
    public Drink(String name, String type, String origin, String description, URL image) {
        this.name = name;
        this.type = type;
        this.origin = origin;
        this.description = description;
        this.image = image;
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

    public URL getImage() {
        return image;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    //toString
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
