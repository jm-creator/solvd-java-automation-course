package com.solvd.connectionPool.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Order")
public class Order extends BaseModel {
    private double amount;
    private Restaurant restaurant;
    private Menu menu;

    public Order() {}

    public Order(double amount, Restaurant restaurant, TransactionStatus status, Menu menu) {
        this.amount = amount;

        this.restaurant = restaurant;

        this.menu = menu;
    }

    public Order(Long id, double amount) {
        super(id);
        this.amount = amount;

        this.restaurant = new Restaurant();

        this.menu = new Menu();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +

                ", restaurant=" + restaurant +

                ", menu=" + menu +
                '}';
    }
}
