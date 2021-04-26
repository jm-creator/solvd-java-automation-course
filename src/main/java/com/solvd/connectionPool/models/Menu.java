package com.solvd.connectionPool.models;

import java.util.ArrayList;
import java.util.List;

public class Menu extends BaseModel{
    private String name;
    private Restaurant restaurant;
    private List<Order> orders;
    private List<Rating> ratings;
    private List<MenuHasIngredients> menuHasIngredients;

    public Menu() {}

    public Menu(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
         this.orders = new ArrayList<>();
         this.ratings = new ArrayList<>();
         this.menuHasIngredients = new ArrayList<>();
    }

    public Menu(Long id, String name) {
        super(id);
        this.name = name;
        this.restaurant = new Restaurant();
        this.orders = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.menuHasIngredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<MenuHasIngredients> getMenuHasIngredients() {
        return menuHasIngredients;
    }

    public void setMenuHasIngredients(List<MenuHasIngredients> menuHasIngredients) {
        this.menuHasIngredients = menuHasIngredients;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}
