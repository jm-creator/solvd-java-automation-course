package enums;

import java.util.Random;

public enum Categories {

    BASE("BASE", 150f),
    MEDIUM("MEDIUM", 270f),
    PRO("PRO", 360f);


    private String name;
    private Float price;

    Categories(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setName(String name) { this.name = name; }

    public void setPrice(Float price) { this.price = price; }

    public static Categories randomCategory() {
        return Categories.values()[new Random().nextInt(Categories.values().length)];
    }
}
