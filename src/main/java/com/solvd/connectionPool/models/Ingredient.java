package com.solvd.connectionPool.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "Ingredients")
public class Ingredient extends BaseModel {
    private String name;
    private String description;
    private double price;
    private List<MenuHasIngredients> menuHasIngredients;


    public Ingredient() {}

    public Ingredient(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuHasIngredients = new ArrayList<>();
    }

    public Ingredient(Long id, String name, String description, double price) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.menuHasIngredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
