package Classes;

public class Ingredient {
    private String name,texture,abv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public Ingredient(String n,String t,String a){
        name=n;
        texture=t;
        abv=a;
    }
}

