package Classes;

import Util.Utilities;

public class Ingredient {

    private String name; //30 char

    private String texture; // 100 char no num

    private Double abv; //100.00 6 char range 0 - 100

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

    public Ingredient(String n,String t,Double a){
        if (Utilities.validateStringLength(n,30)) {
            name = n;
        }
        if (Utilities.validateStringLength(t,100)) {
            texture = t;
        }
        if (Utilities.validRange(a,0,100)) {
            abv = a;
        }
        else {
            abv = (double) -1;
        }
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

