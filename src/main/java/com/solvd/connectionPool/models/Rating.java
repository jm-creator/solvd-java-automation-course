package com.solvd.connectionPool.models;

import java.util.Date;

public class Rating extends BaseModel {
    private Date date;
    private int score;
    private String comment;
    private Customer customer;
    private Menu menu;
    private Restaurant restaurant;

    public Rating() {}

    public Rating(Date date, int score, String comment, Customer customer, Menu menu, Restaurant restaurant) {
        this.date = date;
        this.score = score;
        this.comment = comment;
        this.customer = customer;
        this.menu = menu;
        this.restaurant = restaurant;
    }

    public Rating(Long id, Date date, int score, String comment) {
        super(id);
        this.date = date;
        this.score = score;
        this.comment = comment;
        this.customer = new Customer();
        this.menu = new Menu();
        this.restaurant = new Restaurant();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "date=" + date +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", customer=" + customer +
                ", menu=" + menu +
                ", restaurant=" + restaurant +
                '}';
    }
}
