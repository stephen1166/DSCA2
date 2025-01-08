package Classes;

import Util.Utilities;

public class Ingredient {

    private String name; //30 char

    private String texture; // 100 char no num

    private Double abv; //100.00 6 char range 0 - 100

    private int ml;

    public Ingredient(Ingredient ingredient) {
        this.name=ingredient.name;
        this.texture=ingredient.texture;
        this.abv=ingredient.abv;
        ml=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Utilities.truncateString(name,30);
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = Utilities.truncateString(texture,100);
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        if (Utilities.validRange(abv,0,100)) {
            this.abv = abv;
        }
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public Ingredient(String n, String t, Double a){
            name = Utilities.truncateString(n,30);
            texture = Utilities.truncateString(t,100);
        if (Utilities.validRange(a,0.0,100.0)) {
            abv = a;
        }
        else {
            abv = -1.0;
        }
        ml=0;
    }

    //toString TODO set up nicer to string
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", texture='" + texture + '\'' +
                ", abv=" + abv +
                '}';
    }
}

