package com.solvd.connectionPool.models;

import javax.xml.bind.annotation.XmlRootElement;


public class MenuHasIngredients extends BaseModel{
    private int quantity;
    private Menu menu;
    private Ingredient ingredient;

    public MenuHasIngredients() {}
    
    public MenuHasIngredients( int quantity) {
        this.menu = new Menu();
        this.ingredient = new Ingredient();
        this.quantity = quantity;
    }

    public MenuHasIngredients(Long id, int quantity) {
        super(id);
        this.menu = new Menu();
        this.ingredient = new Ingredient();
        this.quantity = quantity;


    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "menuHasIngredients{" +
                "menu=" + menu +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}
