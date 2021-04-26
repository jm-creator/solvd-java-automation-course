package com.solvd.connectionPool.models;

public class Order extends BaseModel {
    private double amount;
    private Customer customer;
    private Restaurant restaurant;
    private TransactionStatus status;
    private Menu menu;

    public Order() {}

    public Order(double amount, Customer customer, Restaurant restaurant, TransactionStatus status, Menu menu) {
        this.amount = amount;
        this.customer = customer;
        this.restaurant = restaurant;
        this.status = status;
        this.menu = menu;
    }

    public Order(Long id, double amount) {
        super(id);
        this.amount = amount;
        this.customer = new Customer();
        this.restaurant = new Restaurant();
        this.status = new TransactionStatus();
        this.menu = new Menu();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
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
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", status=" + status +
                ", menu=" + menu +
                '}';
    }
}
